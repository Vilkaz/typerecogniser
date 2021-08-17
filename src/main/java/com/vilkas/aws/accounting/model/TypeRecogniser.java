package com.vilkas.aws.accounting.model;

import org.apache.log4j.Logger;

public class TypeRecogniser {

    private static final Logger LOG = Logger.getLogger(TypeRecogniser.class);

    // This method is easyer to read, but has higher Cyclic complexity overall
    public InputType getInputTypeForFile(String filename) {
        if (filename.startsWith("clients")) {
            return InputType.CLIENTS;
        }

        if (filename.startsWith("accounts")) {
            return InputType.ACCOUNTS;
        }

        if (filename.startsWith("transactions")) {
            return InputType.TRANSACTIONS;
        }

        if (filename.startsWith("portfolios")) {
            return InputType.PORTFOLIOS;
        }

        return InputType.UNKNOWN;
    }


//    Those methode are written without any IF. But it is harder to read !
//    I would use those, if the contracts limits our cyclic complexity or if we are
//    maintaining the code ourself forever and all like this style.
//    The functions are also test covered.

//
//    I would not use that, if we have to pass the code to the client.


    /**
     * This method gets the type of the file handled, and turns it into an enum
     *
     * @param filename The full filename
     * @return Enum that represents the Type of the file
     */
    public InputType getInputTypeByFileTypeLowerCyclicComplexity(String filename) {
        String fileType = getTypeFromFilename(filename);
        try {
            return InputType.valueOf(fileType);
        } catch (Exception e) {
            LOG.error("Exception while recognising the type of the file ", e);
            return InputType.UNKNOWN;
        }
    }

    /**
     * This method filters the word from the file, that starts before data
     *
     * @param filename full filename
     * @return subtract the last 13 characters from filename and return it
     */
    // package private for testing
    String getTypeFromFilename(String filename) {
        final int DATE_AND_FILE_ENDING_LENGTH = 13;
        int typeEndPosition = filename.length() - DATE_AND_FILE_ENDING_LENGTH;
        return filename.substring(0, typeEndPosition).toUpperCase();
    }


}
