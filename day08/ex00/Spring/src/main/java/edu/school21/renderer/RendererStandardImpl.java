package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererStandardImpl() {
    }

    public void setPreProcessor(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void display(String parameter) {
        String newMessage = preProcessor.covert(parameter);
        System.out.println(newMessage);
    }
}
