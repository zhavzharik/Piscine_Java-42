package edu.school21.printer.app;
import edu.school21.printer.logic.MyLogic;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("Wrong number of arguments!");
            System.exit(-1);
        }

        char white = args[0].charAt(0);
        char black = args[1].charAt(0);
        String pathImage = args[2];

        int[][] arrayImage = MyLogic.transformToArray(pathImage, white, black);

        for (int i = 0; i < MyLogic.getHeight(); i++) {
            for (int j = 0; j < MyLogic.getWidth(); j++) {
                System.out.print((char)(arrayImage[j][i]));
            }
            System.out.println();
        }
    }
}