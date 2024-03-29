/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.common.gwt.client.widgets.file;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.gwtbootstrap3.client.shared.event.TabShowEvent;
import org.gwtbootstrap3.client.shared.event.TabShowHandler;
import org.gwtbootstrap3.client.ui.Form;
import org.gwtbootstrap3.client.ui.TabListItem;
import org.gwtbootstrap3.client.ui.TabPane;
import org.gwtbootstrap3.client.ui.base.form.AbstractForm.SubmitCompleteEvent;
import org.gwtbootstrap3.client.ui.base.form.AbstractForm.SubmitCompleteHandler;

import mil.arl.gift.common.gwt.client.widgets.bootstrap.BsLoadingDialogBox;
import mil.arl.gift.common.io.FileTreeModel;

import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent.Handler;
import com.google.gwt.view.client.HasData;

/**
 * A widget that allows the user to either choose a file to upload to the server or select a file from the server. This widget works a bit 
 * differently than most views in the GAT in that it follows MVP practices for the most part but holds a reference to its own presenter. 
 * Because of this, no prior calls to a presenter class need to be made before using this widget in any interface. 
 * 
 * That said, this widget will not enact any file uploading or file selection logic until submitFileChoice(FileSelectionCallback) is called. 
 * This allows such logic to be delayed until another encompassing presenter determines that such operations should proceed, giving us the 
 * option of canceling a file upload or file selection if a validation check fails. The callback provided will be given the appropriate 
 * file name uploaded or selected once the corresponding operation has completed.
 * 
 * By default, no height is initially declared for the list of server files, meaning the list will be dynamically sized depending on the number 
 * of files in the currently selected directory. In order to set this list to a specific size and enable scrolling, a call must be made to 
 * setFileTableHeight(String height). 
 * 
 * !IMPORTANT!: When uploading a file, this widget MUST be attached to the DOM when submitFileChoice(FileSelectionCallback) is called, 
 * otherwise the upload request will not be sent. The reason for this is that the 'form' element generated by GWT will not be able 
 * to send the appropriate request to the file servlet unless it is attached to the DOM. Any logic that may cause this widget to be 
 * detached from the DOM (e.g. PopupPanel.hide() or DialogBox.hide()) should only be called after the upload request has been processed. 
 * 
 * @author nroberts
 */
public class BsFileSelectionWidget extends Composite implements FileSelectionView {
	
	/** The logger. */
    private static Logger logger = Logger.getLogger(FileSelectionWidget.class.getName());

	private static FileSelectionWidgetUiBinder uiBinder = GWT
			.create(FileSelectionWidgetUiBinder.class);
	
	/** The directory icon url. */
	private static String DIRECTORY_ICON_URL = "images/folder.png";
	
	/** The file icon url. */
	private static String FILE_ICON_URL = "images/file.png";

	interface FileSelectionWidgetUiBinder extends
			UiBinder<Widget, BsFileSelectionWidget> {
	}
	
	@UiField
	protected Form form;

	@UiField
	protected FileUpload fileUpload;
	
	/** The up arrow. */
	@UiField
	protected MenuItem upArrow;
	
	/** The up arrow. */
	@UiField
	protected MenuItem directoryName;
	
	/** The file name data grid. */
	@UiField
	protected CellTable<FileTreeModel> fileNameTable;
	
	/** The file name input. */
	@UiField
	protected TextBox fileNameInput;
	
	@UiField
	ScrollPanel fileTableScrollPanel;
	
	@UiField
	TabListItem uploadTab;
	
	@UiField
	TabPane uploadTabPane;
	
	@UiField
	TabListItem myWorkspaceTab;
	
	@UiField
	TabPane myWorkspaceTabPane;
	
	/**
	 * The file upload callback that will be used to handle when the user has made a file selection.
	 */
	private FileSelectionCallback fileUploadCallback = null;
	
	/**
	 * The presenter associated with this file selector. Ordinarily, we wouldn't give the view direct access to its presenter, but in this case, 
	 * we plan to use this widget in a number of places, so we want to keep the process of setting up the widget as simple as possible. Because 
	 * of this, most of the logic used to set up the presenter is handled in the view's constructor, making handling file uploads as simple as 
	 * calling the constructor and then calling submitFileChoice(FileSelectionCallback)
	 */
	private FileSelectionPresenter presenter;
	
	private FileSelectionView.Mode currentMode = FileSelectionView.Mode.UPLOAD;
	
	public ModeChangedCallback modeChangedCallback;
	
	/**
	 * The copy file request is used to house the logic to perform the copy file operation.  A copy file
	 * operation means that the dialog can be setup to copy the selected item from the my workspaces panel/tab
	 * to a specified destination.  The copyfilerequest object holds the logic to perform the copy operation.
	 */
	private CopyFileRequest copyFileRequest = null;
	
	/**
	 * Creates a new file selection widget
	 */
	private BsFileSelectionWidget(){
		initWidget(uiBinder.createAndBindUi(this));
		
		Column<FileTreeModel, String> fileIconColumn = new Column<FileTreeModel, String>(new ImageCell()){

			@Override
			public String getValue(FileTreeModel object) {

				if(object != null && object.isDirectory()){
					return DIRECTORY_ICON_URL;
					
				} else {
					return FILE_ICON_URL;
				}
			}
			
		};
		fileNameTable.addColumn(fileIconColumn);
		fileNameTable.setColumnWidth(fileIconColumn, "25px");
		
		Column<FileTreeModel, String> fileNameColumn = new Column<FileTreeModel, String>(new TextCell()){

			@Override
			public String getValue(FileTreeModel object) {
				return object.getFileOrDirectoryName();
			}
			
		};
		
		fileNameTable.addColumn(fileNameColumn);
		fileNameTable.setColumnWidth(fileNameColumn, "100%");
		
		fileUpload.setName("bsUploadFileElement");
		
		form.setAction(GWT.getHostPageBaseURL() + "");
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
		
		form.addSubmitCompleteHandler(new SubmitCompleteHandler() {

            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
            	
            	BsLoadingDialogBox.remove();
            	
            	FileSelectionWidgetUtil.handleFileUploadResponse(event.getResults(), fileUploadCallback);
            }
        });
		
		uploadTab.addShowHandler(new TabShowHandler() {
			
			@Override
			public void onShow(TabShowEvent event) {
				
				currentMode = FileSelectionView.Mode.UPLOAD;
				
				if(modeChangedCallback != null){
					modeChangedCallback.onModeChanged(currentMode);
				}
			}
		});
		
		myWorkspaceTab.addShowHandler(new TabShowHandler() {
			
			@Override
			public void onShow(TabShowEvent event) {
				
				currentMode = FileSelectionView.Mode.MY_WORKSPACE;
				
				if(modeChangedCallback != null){
					modeChangedCallback.onModeChanged(currentMode);
				}
			}
		});
	}
	
	/**
	 * Creates a new file selection widget
	 * 
	 * @param uploadServletUrl the URL for the servlet to which this widget should upload files
	 */
	public BsFileSelectionWidget(String uploadServletUrl){
		
		this();
		
		String hostURL = GWT.getHostPageBaseURL();
		
		if(uploadServletUrl.contains(hostURL)){
			form.setAction(hostURL + uploadServletUrl);
			
		} else {		
			form.setAction(hostURL + uploadServletUrl);
		}
		
		uploadTab.setVisible(true);
		myWorkspaceTab.setVisible(false);
		
		uploadTabPane.setActive(true);
		myWorkspaceTabPane.setActive(false);
		
		presenter = new FileSelectionPresenter(this, null, null);
		
		uploadTab.showTab(true);
	}
	
	@Override
	public void submitFileChoice(final FileSelectionCallback callback){				
		presenter.submitFileChoice(callback, currentMode);
	}
	
	@Override
	public void uploadChosenFile(final FileSelectionCallback callback){
		
		StringBuilder errorMessage = new StringBuilder("");
	    String fileName = fileUpload.getFilename();
	    if (!verifyFileName(fileName, errorMessage)) {
	        callback.onFailure(errorMessage.toString());
	        return;
	    }

		fileUploadCallback = callback;
		
		form.submit();
	}
	
	@Override
	public void setAllowedFileExtensions(String[] extensions){
		
		StringBuilder acceptValue = new StringBuilder();
		
		for(int i = 0; i < extensions.length; i++){
			
			int lastDotIndex = extensions[i].lastIndexOf(".");
			
			String metaExtension;
			
			/*
			 * Most browsers only recognize the last period and onwards as an actual file extension, so we can't filter for extensions like 
			 * .course.xml or .dkf.xml during uploads. We can, howerver, use the .xml part to have a little bit of filtering, 
			 */
			
			if(lastDotIndex >= 0 && lastDotIndex < extensions[i].length()){
				metaExtension = extensions[i].substring(lastDotIndex, extensions[i].length());
				
			} else {
				metaExtension = extensions[i];
			}
			
			if(i == 0){
				acceptValue.append(metaExtension);
			
			} else {
				acceptValue.append(", ").append(metaExtension);
			}
		}
		
		fileUpload.getElement().setAttribute("accept", acceptValue.toString());
		
		presenter.setAllowedFileExtensions(extensions);
	}
	
	@Override
	public HasData<FileTreeModel> getFileNameDataDisplay() {
		return fileNameTable;
	}

	@Override
	public void setUpArrowCommand(ScheduledCommand command) {
		upArrow.setScheduledCommand(command);
	}

	@Override
	public HasEnabled getUpArrow() {
		return upArrow;
	}

	@Override
	public HasText getDirectoryName() {
		return directoryName;
	}

	@Override
	public HasValue<String> getFileNameInput() {
		return fileNameInput;
	}
	
	/**
	 * Sets the size of the file selection table
	 * 
	 * @param width the width of the file selection table
	 * @param height the height of the file selection table
	 */
	public void setFileTableSize(String width, String height){
		fileTableScrollPanel.setWidth(width);
		fileTableScrollPanel.setHeight(height);
	}
	
	/**
	 * Gets the element used to select a file to upload
	 * 
	 * @return the element used to select a file to upload
	 */
	public FileUpload getFileUpload(){
		return fileUpload;
	}
	
	/**
	 * Resets all fields.
	 */
	public void reset(){
		
		form.reset();
		presenter.refresh();
	}
	
	@Override
	public void resetScroll(){
		fileTableScrollPanel.scrollToTop();
	}
	
	@Override
	public void addCellPreviewHandler(Handler<FileTreeModel> handler){
		
		fileNameTable.addCellPreviewHandler(handler);
	}
	
	@Override
	public boolean isUploadingFile(){
		return currentMode.equals(FileSelectionView.Mode.UPLOAD);
	}

	@Override
	public void setModeChangedCallback(ModeChangedCallback callback) {
		this.modeChangedCallback = callback;
	}

	@Override
	public void filterOutFiles(List<String> relativePathsOfFiles){
		
		if(presenter != null){
			presenter.filterOutFiles(relativePathsOfFiles);
		}
	}
	
	@Override
	public void setShowFoldersOnly(boolean showFoldersOnly){
		
		if(presenter != null){
			presenter.setShowFoldersOnly(showFoldersOnly);
		}
	}
	
	@Override
	public void filterOutExtensions(List<String> extensions){
		
		if(presenter != null){
			presenter.filterOutExtensions(extensions);
		}
	}
	
	@Override
	public void setFoldersSelectable(boolean foldersSelectable){
		
		if(presenter != null){
			presenter.setFoldersSelectable(foldersSelectable);
		}
	}
	
	@Override
	public boolean getFoldersSelectable(){
		
		if(presenter != null){
			return presenter.getFoldersSelectable();
			
		} else {
			return false;
		}
	}

    @Override
    public void copyChosenFile(FileTreeModel source, final FileSelectionCallback callback) {
        
        StringBuilder errorMessage = new StringBuilder("");
        logger.fine("copyChosenFile - called with callback object of: " + callback);
        
        String fileName = source.getRelativePathFromRoot(true);
        if (!verifyFileName(fileName, errorMessage)) {
            callback.onFailure(errorMessage.toString());
            return;
        }
        
        
        fileUploadCallback = callback;
        
        // Kick off the copy request on the server.
        if (copyFileRequest != null) {
            copyFileRequest.asyncCopy(source, new CopyFileCallback() {

                @Override
                public void onSuccess(FileTreeModel file) {
                    
                    logger.fine("copyChosenFile - success received");
                    callback.onServerFileSelected(file.getRelativePathFromRoot());
                    
                }

                @Override
                public void onFailure(String reason) {
                    
                    logger.fine("copyChosenFile - onFailure():" + reason);
                    callback.onFailure(reason);
                    
                }

                @Override
                public void onFailure(Throwable thrown) {
                    logger.fine("copyChosenFile - onFailure() throwable exception occurred:" + thrown.getMessage());
                    callback.onFailure(thrown.getMessage());
                    
                }
                
            });
        }
    }
    
    /**
	 * Internal function used to verify the filename against the allowed extensions
	 * that are used in the dialog.
	 * @param fileName - The filename that is selected in the dialog.
	 * @param errorMsg - Contains the returned error message (if any) if the file is not verified.
	 * @return - true if verified, false otherwise.  If false is returned, the errorMsg should contain the reason why it failed.
	 */
	private boolean verifyFileName(String fileName, StringBuilder errorMsg) {
		
	    boolean verified = true;
	    errorMsg.setLength(0);
	    
	    String[] allowedExtensions = presenter.getAllowedFileExtensions();
	    List<String> filteredExtensions = presenter.getFilteredFileExtensions();
	    
	    
	    logger.fine("verifyFileName called for filename: " + fileName + ", extensions to check: " + Arrays.toString(allowedExtensions));
	    
	    
        
        try {
            if(allowedExtensions == null && filteredExtensions.isEmpty() ) {
                logger.fine("verifyFileName - no verification needed. Allowed extensions are not specified and there are no filtered extensions specified.");
                return true;
            }
            
            
            // Check allowed extensions if there are any set.
            if (allowedExtensions != null) {
                
                boolean hasAllowedExtension = false;
                
                for(String extension : allowedExtensions){
                    
                    if(fileName.endsWith(extension)){
                        hasAllowedExtension = true;
                        break;
                    }
                }
                if(!hasAllowedExtension){
                    
                    StringBuilder sb = new StringBuilder();
                    sb.append("The file selected must have a file name ending in ");
                                
                    sb.append(formatExtensionList(Arrays.asList(allowedExtensions)));
                    sb.append(".");
         
                    errorMsg.append(sb);
                    verified = false;
                }
            }
            
            
            // Only keep validating if the filename is still valid and there are filtered extensions to check against.
            if (verified && !filteredExtensions.isEmpty()) { 
                // Check for filtered extensions.
                boolean hasFilteredExtension = false;
                
                for (String filterExt : filteredExtensions) {
                    if(fileName.endsWith(filterExt)) {
                        hasFilteredExtension = true;
                        break;
                    }
                }
                
                if (hasFilteredExtension) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The file selected must NOT have a file name ending in ");
                    sb.append(formatExtensionList(filteredExtensions));
                    sb.append(".");
                    
                    errorMsg.append(sb);
                    verified = false;
                    
                }
            }
        } catch (Exception e) {
            logger.severe("Error occurred: " + e.toString());
            errorMsg.append("Error occurred: ").append(e.toString());
            verified = false;
        }
        
	    
        logger.fine("verifyFileName - returning value of: " + verified +  ": reason = " + errorMsg.toString());
	    return verified;
	}
	
	/**
	 * Helper function to format a list of extensions to be used in a dialog message.
	 * 
	 * @param extensions - List of extensions to be formatted.
	 * @return formatted string of the extensions.
	 */
	private StringBuilder formatExtensionList(List<String> extensions) {
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < extensions.size(); i++){
            
            if(i == extensions.size() - 1){
                
                if(extensions.size() == 1){
                    sb.append(extensions.get(i));
                    
                } else {
                    sb.append("or ");
                    sb.append(extensions.get(i));
                }
                
            } else if(i == extensions.size() - 1 && extensions.size() == 2){
                sb.append(extensions.get(i));
                sb.append(" ");
                
            } else {
                sb.append(extensions.get(i));
                sb.append(", ");
            }
        }
	    
	    return sb;
	}

	/* (non-Javadoc)
	 * @see mil.arl.gift.common.gwt.client.widgets.file.FileSelectionView#setWorkspaceLoadingIconVisible(boolean)
	 */
	@Override
	public void setWorkspaceLoadingIconVisible(boolean visible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Focusable getFileNameFocusInput() {
		return fileNameInput;
	}
	
	@Override
	public HasKeyUpHandlers getFileNameKeyUpInput() {
		return fileNameInput;
	}
}
