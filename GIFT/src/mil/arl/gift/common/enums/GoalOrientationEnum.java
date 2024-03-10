/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.common.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mil.arl.gift.common.AttributeValueEnumAccessor;

import mil.arl.gift.common.EnumerationNotFoundException;


/**
 * Enumeration of the various Goal Orientation Levels
 * 
 * @author bgoldberg
 *
 */
public class GoalOrientationEnum extends AbstractEnum {

    private static final long serialVersionUID = 1L;
    
    /** complete set of enumerations of this class */
    private static List<GoalOrientationEnum> enumList = new ArrayList<GoalOrientationEnum>(2);
    
    /** set of enumerations that an author can pick from, a subset of the enumList */
    private static final List<GoalOrientationEnum> enumAuthorableList = new ArrayList<GoalOrientationEnum>(3);
    
    private static int index = 0;

    public static final GoalOrientationEnum UNKNOWN = new GoalOrientationEnum("Unknown", "Unknown", false);
    public static final GoalOrientationEnum MASTERY = new GoalOrientationEnum("Mastery", "Mastery");
    public static final GoalOrientationEnum PERFORMANCE = new GoalOrientationEnum("Performance", "Performance");

    private static final GoalOrientationEnum DEFAULT_VALUE = UNKNOWN;

    public static final AttributeValueEnumAccessor ACCESSOR = new AttributeValueEnumAccessor(enumList, enumAuthorableList, DEFAULT_VALUE, UNKNOWN);

    /**
     * Default Constructor
     *
     * Required to exist and be public for GWT compatability
     */
    public GoalOrientationEnum() {
        super();
    }

    /**
     * Set attributes
     * 
     * @param name name - the unique name of this enumeration
     * @param displayName - the display name of this enumeration
     */
    private GoalOrientationEnum(String name, String displayName){
        this(name, displayName, true);
    }
    
    /**
     * Set attributes
     * 
     * @param name name - the unique name of this enumeration
     * @param displayName - the display name of this enumeration
     * @param authorable - whether this value is authorable
     */
    private GoalOrientationEnum(String name, String displayName, boolean authorable){
        super(index++, name, displayName);
        enumList.add(this);
        
        if(authorable){
            enumAuthorableList.add(this);
        }
    }
    
    /**
     * Return the enumeration object that has the matching name.
     * @param name The name of the enumeration to find.
     * @return The matching enumeration.
     * @throws EnumerationNotFoundException if an enumeration with a matching
     *         name is not found.
     */
    public static GoalOrientationEnum valueOf(String name)
        throws EnumerationNotFoundException {
        return AbstractEnum.valueOf(name, VALUES());
    }

    /**
     * Return the enumeration object that has the matching value.
     * @param value The value of the enumeration to find.
     * @return The matching enumeration.
     * @throws EnumerationNotFoundException if an enumeration with a matching
     *         value is not found.
     */
    public static GoalOrientationEnum valueOf(int value)
        throws EnumerationNotFoundException {
        return AbstractEnum.valueOf(value, VALUES());
    }

    /**
     * Returns a List of the currently defined enumerations.
     * @return a List of the currently defined enumerations.
     */
    public static final List<GoalOrientationEnum> VALUES() {
        return Collections.unmodifiableList(enumList);
    }
}
