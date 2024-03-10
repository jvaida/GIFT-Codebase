/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.tools.map.client.draw;

/**
 * An object describing the characteristics of a symbol as defined by MIL-STD-2525 military symbology. This symbol can
 * be rendered to a map by invoking a military symbol rendering service using a URL generated by a
 * {@link MilitarySymbolUrlGenerator}.
 * <br/><br/>
 * A showcase of military symbol characteristics and their visual representations can be found 
 * <a href="https://spatialillusions.com/unitgenerator/">here</a>;
 * 
 * @author nroberts
 */
    
public class MilitarySymbol{
    
    /** The default size of each military symbol */
    public static final int DEFAULT_SIZE = 35;
    
    /**
     * The affiliation of a military unit
     * 
     * @author nroberts
     */
    public static enum Affiliation{
        
        PENDING('P'),
        UNKNOWN('U'),
        ASSUMED_FRIEND('A'),
        FRIEND('F'),
        NEUTRAL('N'),
        SUSPECT('S'),
        HOSTILE('H'),
        NONE_SPECIFIED('O');
        
        /** A character code that identifies this affiliation */
        private char code;
        
        /**
         * Creates a new affiliation with the given code that identifies it
         * 
         * @param code the code identifying this new affiliation
         */
        private Affiliation(char code) {
            this.code = code;
        }
        
        /**
         * Gets the character code that identifies this affiliation
         * 
         * @return the code identifying this affiliation
         */
        public char getCode() {
            return code;
        }

        /**
         * Gets the affiliation of the entity based on its force identifier.
         * 
         * @param forceId the entity's force identifier.
         * @return the entity's affiliation.
         */
        public static Affiliation getAffiliationFromForceId(Integer forceId) {
            if (forceId == null) {
                return NONE_SPECIFIED;
            }

            switch (forceId) {
            case 1:
                return FRIEND;
            case 2:
                return HOSTILE;
            case 3:
                return NEUTRAL;
            default:
                return UNKNOWN;
            }
        }
    }
    
    /**
     * The status of a military unit
     * 
     * @author nroberts
     */
    public static enum Status{
        
        ANTICIPATED('A'),
        PRESENT('P'),
        PRESENT_FULLY_CAPABLE('C'),
        PRESENT_DAMAGED('D'),
        PRESENT_DESTROYED('X'),
        PRESENT_FULL_TO_CAPACITY('Y');
        
        /** A character code that identifies this status */
        private char code;
        
        /**
         * Creates a new status with the given code that identifies it
         * 
         * @param code the code identifying this new status
         */
        private Status(char code) {
            this.code = code;
        }
        
        /**
         * Gets the character code that identifies this status
         * 
         * @return the code identifying this status
         */
        public char getCode() {
            return code;
        }
    }
    
    /** The affiliation of the unit represented by this symbol */
    private Affiliation affiliation;
    
    /** The status of the unit represented by this symbol */
    private Status status;
    
    /** 
     * The color that this military symbol should be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the fill color to be rendered as fully transparent.
     * <br/><br/>
     * This string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     */
    private String fillColor;
    
    /**
     * The color that this military symbol's lines should use when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the line color to be rendered as fully transparent.
     * <br/><br/>
     * This string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     */
    private String lineColor;
    
    /** 
     * The color that this military symbol's text should be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the text color to be rendered as fully transparent.
     * <br/><br/>
     * This string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     */
    private String textColor;
    
    /** 
     * The color that the background behind this military symbol's text should be filled with when it is rendered. 
     * Note that the service that is used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only 
     * acknowledges 6-digit hexadecimal color values such as "0xFF00FF". Any other values will cause the background color 
     * to be rendered as fully transparent.
     * <br/><br/>
     * This string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     */
    private String textBackgroundColor;
    
    /**
     * The unique designation that identifies this entity. This will be displayed as text to the lower-left side
     * of this military symbol's icon.
     * <br/><br/>
     * This string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     */
    private String uniqueDesignation;
    
    /** The size (in pixels) that the core symbol (i.e. not echelon/health modifiers) should fit within (e.g. 25x25) */
    private Integer size;
    
    /**
     * Creates a new military symbol with the given characteristics
     * 
     * @param affiliation the affiliation of the unit that this symbol represents. Cannot be null.
     * @param status the status of the unit that this symbol represents. Cannot be null.
     */
    public MilitarySymbol(Affiliation affiliation, Status status) {
        setAffiliation(affiliation);
        setStatus(status);
    }
    
    /**
     * Sets the status of the unit represented by this symbol
     * 
     * @param status the status of the symbol. Cannot be null.
     */
    public void setStatus(Status status) {
        
        if(status == null) {
            throw new IllegalArgumentException("The status for a military symbol cannot be null.");
        }
        
        this.status = status;
    }
    
    /**
     * Gets the status of the unit represented by this symbol
     * 
     * @return the status of the symbol. Cannot be null.
     */
    public Status getStatus() {
        return status;
    }
    
   /**
    * Sets the affiliation of the unit represented by this symbol
    * 
    * @param affiliation the affiliation of the symbol. Cannot be null.
    */
   public void setAffiliation(Affiliation affiliation) {
       
       if(affiliation == null) {
           throw new IllegalArgumentException("The affiliation for a military symbol cannot be null.");
       }
       
       this.affiliation = affiliation;
   }
   
   /**
    * Gets the affiliation of the unit represented by this symbol
    * 
    * @return the affiliation of the symbol. Cannot be null.
    */
   public Affiliation getAffiliation() {
       return affiliation;
   }

    /**
     * Gets the color that this military symbol will be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the fill color to be rendered as fully transparent.
     * 
     * @return a string representing the fill color. Can be null.
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * Sets the color that this military symbol should be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the fill color to be rendered as fully transparent.
     * <br/><br/>
     * The provided string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     * 
     * @param fillColorHex a string representing a hexadecimal color value (e.g. 0xFF00FF). Can be null.
     */
    public void setFillColor(String fillColorHex) {
        this.fillColor = fillColorHex;
    }

    /**
     * Gets the color that this military symbol's lines should use when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the line color to be rendered as fully transparent.
     * 
     * @return a string representing the fill color. Can be null.
     */
    public String getLineColor() {
        return lineColor;
    }

    /**
     * Sets the color that this military symbol's lines should use when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the line color to be rendered as fully transparent.
     * <br/><br/>
     * The provided string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     * 
     * @param fillColorHex a string representing a hexadecimal color value (e.g. 0xFF00FF). Can be null.
     */
    public void setLineColor(String lineColorHexHex) {
        this.lineColor = lineColorHexHex;
    }

    /**
     * Gets the unique designation that identifies this entity. This will be displayed as text to the lower-left side
     * of this military symbol's icon.
     * 
     * @return the string uniquely identifying this entity. Cannot be null.
     */
    public String getUniqueDesignation() {
        return uniqueDesignation;
    }

    
    /**
     * Sets the unique designation that identifies this entity. This will be displayed as text to the lower-left side
     * of this military symbol's icon.
     * <br/><br/>
     * The provided string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     * 
     * @param uniqueDesignation the string uniquely identifying this entity. Cannot be null.
     */
    public void setUniqueDesignation(String uniqueDesignation) {
        this.uniqueDesignation = uniqueDesignation;
    }

    /** 
     * Sets the color that this military symbol's text should be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the text color to be rendered as fully transparent.
     * 
     * @return a string representing the text color. Can be null.
     */
    public String getTextColor() {
        return textColor;
    }

    /** 
     * Gets the color that this military symbol's text should be filled with when it is rendered. Note that the service that is 
     * used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges 6-digit hexadecimal 
     * color values such as "0xFF00FF". Any other values will cause the text color to be rendered as fully transparent.
     * <br/><br/>
     * The provided string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     * 
     * @param a string representing a hexadecimal color value (e.g. 0xFF00FF). Can be null.
     */
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    /**
     * Gets the color that the background of this military symbol's text should be filled with when it is rendered. Note 
     * that the service that is used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges
     * 6-digit hexadecimal color values such as "0xFF00FF". Any other values will cause the text color to be rendered 
     * as fully transparent.
     * 
     * @return a string representing the text background color. Can be null.
     */
    public String getTextBackgroundColor() {
        return textBackgroundColor;
    }

    /** 
     * Sets the color that the background of this military symbol's text should be filled with when it is rendered. Note 
     * that the service that is used to generate the military symbols via {@link MilitarySymbolUrlGenerator} only acknowledges
     * 6-digit hexadecimal color values such as "0xFF00FF". Any other values will cause the text color to be rendered 
     * as fully transparent.
     * <br/><br/>
     * The provided string should not contain any special URL characters, since it will be used in a URLs generated by 
     * {@link MilitarySymbolUrlGenerator}.
     * 
     * @param a string representing a hexadecimal color value (e.g. 0xFF00FF). Can be null.
     */
    public void setTextBackgroundColor(String textBackgroundColor) {
        this.textBackgroundColor = textBackgroundColor;
    }
    
    /**
     * Sets the size (in pixels) that the core symbol (i.e. not echelon/health modifiers) should fit within (e.g. 25x25)
     * 
     * @param size the pixel size of the icon. Can be null if the default size should be used.
     * @return this military symbol instance. Can be used to chain method calls.
     */
    public MilitarySymbol setSize(Integer size) {
        this.size = size;
        return this;
    }
    
    /**
     * Gets the size (in pixels) that the core symbol (i.e. not echelon/health modifiers) should fit within (e.g. 25x25)
     * 
     * @return the pixel size of the icon. Can be null if the default size should be used.
     */
    public Integer getSize() {
        return size;
    }
}