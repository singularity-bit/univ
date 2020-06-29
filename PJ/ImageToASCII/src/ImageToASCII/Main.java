package ImageToASCII;

import javax.imageio.ImageIO;
import java.io.*;

// 2018 TheFlyingKeyboard and released under MIT License
// theflyingkeyboard.net
public class Main {
    public static void main(String[] args) {
        ImageToASCII imageToASCII = new ImageToASCII(1);

        try {
            String[] asciiImage = imageToASCII.convert(ImageIO.read(new File("check.jpg")));

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("checkInASCII.txt"));
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                for (int i = 0; i < asciiImage.length; i++) {
                    if (asciiImage[i] != null) {
                        printWriter.write(asciiImage[i]);
                    }

                    printWriter.write("\n");
                }

                printWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}