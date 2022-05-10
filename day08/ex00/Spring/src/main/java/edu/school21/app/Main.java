package edu.school21.app;

import edu.school21.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefix", Printer.class);
        printer.print("Hello!");

        Printer printerTU = context.getBean("printerWithDateTime", Printer.class);
        printerTU.print("Hello!");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
