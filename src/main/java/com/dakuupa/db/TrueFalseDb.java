package com.dakuupa.db;

/**
 *
 * @author ETWilliams
 */
public class TrueFalseDb {

    public static final int TRUE = 1;
    public static final int FALSE = 0;

    public static boolean getBooleanValue(int value){

        if (value == TRUE){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getDbValue(boolean value){

        if (value){
            return TRUE;
        }
        else{
            return FALSE;
        }

    }

}
