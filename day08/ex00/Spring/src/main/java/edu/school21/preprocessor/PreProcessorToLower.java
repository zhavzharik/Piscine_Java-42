package edu.school21.preprocessor;

import java.util.Locale;

public class PreProcessorToLower implements PreProcessor {
    @Override
    public String covert(String parameter) {
        String newMessage;
        newMessage = parameter.toLowerCase();
        return newMessage;
    }
}
