package com.topsecret;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class ImageUtil {
	
	/**
	 * @param text
	 * @param font
	 * @return
	 */
	public static BufferedImage convertTextToGraphic(String text, Font font) {

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();

        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.WHITE);
        g2d.setBackground(Color.BLACK);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        return img;
    }
	/*
	 * Resize Image to width provided and height as percentage of original
	 */
	/**
	 * @param image
	 * @param width
	 * @return image
	 */
	public static BufferedImage resizeImageToWidth(BufferedImage image, int width) {
		int newHeight = (100*width) / image.getWidth() * image.getHeight() / 100;
		BufferedImage resizedImage = new BufferedImage(width, newHeight, image.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, newHeight, null);
		g.dispose();
		return resizedImage;
	}
	
	/**
	 * return image greyscale 
	 * @param img
	 * @return
	 */
	public static BufferedImage makeGray(BufferedImage img)
	{
		BufferedImage image = new BufferedImage(img.getWidth(), img.getHeight(), 
	                BufferedImage.TYPE_BYTE_GRAY); 
        Graphics g = image.getGraphics(); 
        g.drawImage(img, 0, 0, null); 
        g.dispose(); 
        float brightenFactor = 1.4f;

        RescaleOp op = new RescaleOp(brightenFactor, 0, null);
        image = op.filter(image, image);
        return image;
	}


}
