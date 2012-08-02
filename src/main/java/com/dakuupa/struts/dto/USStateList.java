package com.dakuupa.struts.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etwilliams
 *
 * Struts 2 tag usage
 * <s:select name="permanentState" id="permanentState" list="states" listKey="key"
 *      listValue="displayName" headerKey="" headerValue="--select a state--"/>
 *
 */
public class USStateList {

    public static List<KeyValuePair> getList() {

        List<KeyValuePair> states = new ArrayList<KeyValuePair>(51);
        states.add(new KeyValuePair("AL", "Alabama"));
        states.add(new KeyValuePair("AK", "Alaska"));
        states.add(new KeyValuePair("AZ", "Arizona"));
        states.add(new KeyValuePair("AR", "Arkansas"));
        states.add(new KeyValuePair("CA", "California"));
        states.add(new KeyValuePair("CO", "Colorado"));
        states.add(new KeyValuePair("CT", "Connecticut"));
        states.add(new KeyValuePair("DE", "Delaware"));
        states.add(new KeyValuePair("DC", "Distict of Columbia"));
        states.add(new KeyValuePair("FL", "Florida"));
        states.add(new KeyValuePair("GA", "Georgia"));
        states.add(new KeyValuePair("HI", "Hawaii"));
        states.add(new KeyValuePair("ID", "Idaho"));
        states.add(new KeyValuePair("IL", "Illinois"));
        states.add(new KeyValuePair("IN", "Indiana"));
        states.add(new KeyValuePair("IA", "Iowa"));
        states.add(new KeyValuePair("KS", "Kansas"));
        states.add(new KeyValuePair("KY", "Kentucky"));
        states.add(new KeyValuePair("LA", "Louisiana"));
        states.add(new KeyValuePair("ME", "Maine"));
        states.add(new KeyValuePair("MD", "Maryland"));
        states.add(new KeyValuePair("MA", "Massachusetts"));
        states.add(new KeyValuePair("MI", "Michigan"));
        states.add(new KeyValuePair("MN", "Minnesota"));
        states.add(new KeyValuePair("MS", "Mississippi"));
        states.add(new KeyValuePair("MO", "Missouri"));
        states.add(new KeyValuePair("MT", "Montana"));
        states.add(new KeyValuePair("NE", "Nebraska"));
        states.add(new KeyValuePair("NV", "Nevada"));
        states.add(new KeyValuePair("NH", "New Hampshire"));
        states.add(new KeyValuePair("NJ", "New Jersey"));
        states.add(new KeyValuePair("NM", "New Mexico"));
        states.add(new KeyValuePair("NY", "New York"));
        states.add(new KeyValuePair("NC", "North Carolina"));
        states.add(new KeyValuePair("ND", "North Dakota"));
        states.add(new KeyValuePair("OH", "Ohio"));
        states.add(new KeyValuePair("OK", "Oklahoma"));
        states.add(new KeyValuePair("OR", "Oregon"));
        states.add(new KeyValuePair("PA", "Pennsylvania"));
        states.add(new KeyValuePair("RI", "Rhode Island"));
        states.add(new KeyValuePair("SC", "South Carolina"));
        states.add(new KeyValuePair("SD", "South Dakota"));
        states.add(new KeyValuePair("TN", "Tennessee"));
        states.add(new KeyValuePair("TX", "Texas"));
        states.add(new KeyValuePair("UT", "Utah"));
        states.add(new KeyValuePair("VT", "Vermont"));
        states.add(new KeyValuePair("VA", "Virginia"));
        states.add(new KeyValuePair("WA", "Washington"));
        states.add(new KeyValuePair("WV", "West Virginia"));
        states.add(new KeyValuePair("WI", "Wisconsin"));
        states.add(new KeyValuePair("WY", "Wyoming"));

        return states;
    }
}
