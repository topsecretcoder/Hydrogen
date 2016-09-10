package com.topsecret;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ascii {


	/*
	 * Args: <String or filename>, (int Width), (boolean lowChars)  
	 */
	public static void main(String[] args) {
		
		if (args != null && args.length > 0 && args[0] != null && !args[0].equals("")){
			Ascii ascii = new Ascii();
			int width = 200;
			boolean lowchars = false;
			if (args.length > 1 && args[1] != null) {
				width = Integer.parseInt(args[1]);
			}
			if (args.length > 2 && args[2] != null) {
				lowchars = Boolean.valueOf(args[2]);
			}
			ascii.generateAscii( args[0], width, lowchars);
		} else {
            System.out.println( "File or Text!!");
		}
		
	}
	
	public Ascii() {

	}
	
	/**
	 * Generate Ascii from the input
	 * @param toConvert String : text to generate or filename path
	 * @param inWidth int : desired width to resize to
	 * @param lowChars boolean : true if require low character representation
	 */
	public void generateAscii(String toConvert, int inWidth, boolean lowChars) {
		
		int width = inWidth;
		int height = 46;
		boolean negative = false;
		BufferedImage image;
		try {
            image = ImageUtil.makeGray(ImageUtil.resizeImageToWidth(ImageIO.read(new File(toConvert)),width));

		} catch (IOException e) {
			negative = true;
			image = ImageUtil.makeGray(ImageUtil.convertTextToGraphic(toConvert, new Font("SansSerif", Font.BOLD, 30)));
		}
		width = image.getWidth();
		height = image.getHeight();

		//save this image
		//try {
		//	ImageIO.write(image, "png", new File(toConvert+"_converted.png"));
		//} catch (IOException e) {
		//	
		//}
		
		for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
                // 
                if (y % 2 == 0){
                    sb.append(AsciiUtil.getChar(image, x, y, lowChars, negative) );
                }                  
            }
		
            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
		}
		
	}

}
