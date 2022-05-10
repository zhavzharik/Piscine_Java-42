package edu.school21.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String covert(String parameter) {
        String newMessage;
        newMessage = parameter.toUpperCase();
        return newMessage;
    }
}
