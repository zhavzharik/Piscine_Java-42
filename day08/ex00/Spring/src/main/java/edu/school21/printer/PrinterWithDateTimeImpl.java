package edu.school21.printer;

import edu.school21.renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private LocalDateTime dateTime;
    private Renderer renderer;

    public PrinterWithDateTimeImpl() {
        dateTime = LocalDateTime.now();
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String message) {
        String parameter = dateTime.toString() + " " + message;
        renderer.display(parameter);
    }
}
