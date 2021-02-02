package ImageToASCII;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

// 2018 TheFlyingKeyboard and released under MIT License
// theflyingkeyboard.net
public class ImageToASCII {
    boolean negative;

    public ImageToASCII() {
        this(false);
    }
    public  ImageToASCII(final boolean negative){
        this.negative=negative;
    }

    public String convert(final BufferedImage image) {
        StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());
        for (int y = 0; y < image.getHeight(); y++) {
            if (sb.length() != 0) sb.append("\n");
            for (int x = 0; x < image.getWidth(); x++) {
                Color pixelColor = new Color(image.getRGB(x, y));
                double gValue = (double) pixelColor.getRed() * 0.2989 + (double) pixelColor.getBlue() * 0.5870 + (double) pixelColor.getGreen() * 0.1140;
                final char s = negative ? returnStrNeg(gValue) : returnStrPos(gValue);
                sb.append(s);
            }
        }
        return sb.toString();
    }

    private char colorToChar(double color) {
        final char str;
        if (color < 25) {
            str='@';
        } else if (color >= 25 && color < 51) {
            str= '#';
        } else if (color >= 51 && color < 76) {
            str=  '8';
        } else if (color >= 76 && color < 102) {
            str=  '&';
        } else if (color >= 102 && color < 127) {
            str=  'o';
        } else if (color >= 127 && color < 153) {
            str=  '*';
        } else if (color >= 153 && color < 178) {
            str=  '/';
        } else if (color >= 178 && color < 204) {
            str=  '\'';
        } else if (color >= 204 && color < 229) {
            str=  '.';
        }

        return str;
    }
}