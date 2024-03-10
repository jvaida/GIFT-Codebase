/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.common.enums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mil.arl.gift.common.EnumerationNotFoundException;

/**
 * Different types of survey elements GIFT supports
 *
 * @author jleonard
 */
public class SurveyElementTypeEnum extends AbstractEnum implements Serializable {

    private static List<SurveyElementTypeEnum> enumList = new ArrayList<SurveyElementTypeEnum>(2);

    private static int index = 0;

    public static final SurveyElementTypeEnum QUESTION_ELEMENT = new SurveyElementTypeEnum("QuestionElement", "Question Element");

    public static final SurveyElementTypeEnum TEXT_ELEMENT = new SurveyElementTypeEnum("TextElement", "Text Element");
    
    private static final long serialVersionUID = 1L;

    /**
     * Default Constructor
     *
     * Required by GWT to exist and be public because it is Serializable
     */
    public SurveyElementTypeEnum() {
        super();
    }

    private SurveyElementTypeEnum(String name, String displayName) {

        super(index++, name, displayName);
        enumList.add(this);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;

        } else if (obj instanceof SurveyElementTypeEnum) {

            SurveyElementTypeEnum enumObj = (SurveyElementTypeEnum) obj;

            return enumObj.getValue() == getValue();
        }

        return false;
    }

    @Override
    public int hashCode() {

        int hash = 5;
        hash = hash * 31 + getValue();

        return hash;
    }

    /**
     * Return the enumeration object that has the matching name.
     *
     * @param name The name of the enumeration to find.
     * @return The matching enumeration.
     * @throws EnumerationNotFoundException if an enumeration with a matching
     * name is not found.
     */
    public static SurveyElementTypeEnum valueOf(String name)
            throws EnumerationNotFoundException {

        return AbstractEnum.valueOf(name, VALUES());
    }

    /**
     * Return the enumeration object that has the matching value.
     *
     * @param value The value of the enumeration to find.
     * @return The matching enumeration.
     * @throws EnumerationNotFoundException if an enumeration with a matching
     * value is not found.
     */
    public static SurveyElementTypeEnum valueOf(int value)
            throws EnumerationNotFoundException {

        return AbstractEnum.valueOf(value, VALUES());
    }

    /**
     * Returns a List of the currently defined enumerations.
     *
     * @return a List of the currently defined enumerations.
     */
    public static List<SurveyElementTypeEnum> VALUES() {

        return Collections.unmodifiableList(enumList);
    }
}
