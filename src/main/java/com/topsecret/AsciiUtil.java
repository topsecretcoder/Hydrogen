package com.topsecret;

import java.awt.image.BufferedImage;

public class AsciiUtil {

	private static final char[] defaultCharacters =
            " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"
            .toCharArray();

	private static final char[] lowResCharacters =
            " .:-=+*#%@"
            .toCharArray();


	/**
	 * @param image
	 * @param x
	 * @param y
	 * @param lowres
	 * @param negative
	 * @return
	 */
	public static String getChar(BufferedImage mage, int x, int y, boolean lowres, boolean negative) {
		
		char[] chars = defaultCharacters;
		if (lowres) {
			chars = lowResCharacters;
		}
		int shade = 255- convertRGBToGrayscale(mage.getRGB(x, y));
		if (negative) {
			shade = 255-shade;
		}
		
		int chr =  ((chars.length*100)/255*shade/100);
		
		return String.valueOf(chars[chr]) ;
		}
	
	/**
	 * @param rgbColor
	 * @return int
	 */
	public static int convertRGBToGrayscale(final int rgbColor) {
		// extract components
		int red = (rgbColor >> 16) & 0xFF;
		int green = (rgbColor >> 8) & 0xFF;
		int blue = rgbColor & 0xFF;

		// convert to grayscale
		return (int) (0.3f * red + 0.59f * green + 0.11f * blue);
		}
}
