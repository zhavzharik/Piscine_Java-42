package edu.school21.printer;

import edu.school21.renderer.Renderer;
import edu.school21.renderer.RendererStandardImpl;

public class PrinterWithPrefixImpl implements Printer {

    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl() {
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        String parameter = prefix + " " + message;
        renderer.display(parameter);
    }
}
