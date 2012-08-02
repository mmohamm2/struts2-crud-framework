package com.dakuupa.struts.dto;

/**
 *
 * @author ETWilliams
 */
public class KeyValuePair {

    String key;
    String displayName;

    public KeyValuePair(String key, String displayName) {
        this.key = key;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
