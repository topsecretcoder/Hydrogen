import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
/**
 * Java program to convert text input into corresponsing ascii art by converting text into image.
 * Since challenge mentioned "input of your choice", I considered it to be text. 
 * @author mkekre 
 * email: mkekre86@gmail.com
 *
 */
public class AsciiArtFromText {
    public static void main(String[] args) throws IOException {
        int width = 70;
        int height = 30;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text for which you want to see ASCII art: ");
        //Input Command
        String input = sc.nextLine();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.ITALIC, 20));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(input, 2, 20);
        for (int y = 0; y < height; y++) {
            StringBuilder asciiartstring = new StringBuilder();
            for (int x = 0; x < width; x++) 
                asciiartstring.append(image.getRGB(x, y) == -16777216 ? " " : "a");
            if (asciiartstring.toString().trim().isEmpty()) 
                continue;
            System.out.println(asciiartstring);
        }
        sc.close();
    }
}