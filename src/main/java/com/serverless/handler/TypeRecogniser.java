package com.serverless.handler;

import com.serverless.model.InputType;

import java.util.Locale;

public class TypeRecogniser {

    public InputType recognise(String key) {

        String fileType = getTypeFromFilename(key).toUpperCase();
        InputType inputType = InputType.UNKNOWN;
        try {
            inputType = InputType.valueOf(fileType);
        } catch (Exception e) {

        }
        return inputType;

//        if (key.startsWith("clients")) {
//            return InputType.CLIENTS;
//        }
//
//        if (key.startsWith("accounts")) {
//            return InputType.ACCOUNTS;
//        }
//
//        if (key.startsWith("transactions")) {
//            return InputType.TRANSACTIONS;
//        }
//
//
//        if (key.startsWith("portfolios")) {
//            return InputType.PORTFOLIOS;
//        }

    }


    public String getTypeFromFilename(String filename) {
        final int DATE_AND_FILE_ENDING_LENGTH = 13;
        int typeEndPosition = filename.length() - DATE_AND_FILE_ENDING_LENGTH;
        return filename.substring(0, typeEndPosition).toUpperCase();
    }
}
