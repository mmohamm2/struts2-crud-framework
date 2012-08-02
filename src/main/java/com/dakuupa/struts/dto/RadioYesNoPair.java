package com.dakuupa.struts.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etwilliams
 */
public class RadioYesNoPair {

    public static final String YES_KEY = "yes";
    public static final String YES_DESCRIPTION = "Yes";
    
    public static final String NO_KEY = "no";
    public static final String NO_DESCRIPTION = "No";

    public final static KeyValuePair YES_OPTION = new KeyValuePair(YES_KEY, YES_DESCRIPTION);
    public final static KeyValuePair NO_OPTION = new KeyValuePair(NO_KEY, NO_DESCRIPTION);

    public static List<KeyValuePair> getRadioOptions(){
        List<KeyValuePair> radioOptions = new ArrayList<KeyValuePair>();
        radioOptions.add(YES_OPTION);
        radioOptions.add(NO_OPTION);
        return radioOptions;
    }

}
