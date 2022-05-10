package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererErrImpl() {
    }

    public void setPreProcessor(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void display(String parameter) {
        String newMessage = preProcessor.covert(parameter);
        System.err.println(newMessage);
    }
}
