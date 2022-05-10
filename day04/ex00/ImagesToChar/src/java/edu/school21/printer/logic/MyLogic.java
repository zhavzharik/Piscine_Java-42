package edu.school21.printer.logic;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class MyLogic {

    public static int width;
    public static int height;

    public static int[][] transformToArray(String pathImage, char white, char black) throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream(pathImage));

        width = image.getWidth();
        height = image.getHeight();
        int[][] arrayImage = new int[width][height];

        for (int x = 0; x < height; x++){
            for (int y = 0; y < width; y++){
                int color = image.getRGB(x, y);
                if (color == Color.WHITE.getRGB()) {
                    arrayImage[x][y] = white;
                }
                else if (color == Color.BLACK.getRGB()){
                    arrayImage[x][y] = black;
                }
            }
        }
        return arrayImage;
    }

    public static int getHeight() {
        return MyLogic.height;
    }

    public static int getWidth() {
        return width;
    }
}