//Author: Satyajeet and Amit
package com.nacre.emailmarketing.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SaveImageUtil {
/* public static void saveImage(String currentName, Integer newName){
	try {
		File file=new File("C:\\Users\\Admin\\Desktop\\Picture\\"+currentName);
		BufferedImage image=ImageIO.read(file);
		file=new File("F:\\Nacre\\MajorProject\\emailmarketing\\WebContent\\IMAGES\\"+newName+".png");
		ImageIO.write(image, "png", file);
	} catch (IOException e) {
		e.printStackTrace();
	}
 }*/
 public static void saveImageFromBase64(String image, Integer productId){
	 byte[] imageByte = ImageUtil.decodeImage(image);  
	 String directory = StringConstants.IMAGE_PATH+"\\"+productId+".png";
	 try{
	 FileOutputStream outputStream = new FileOutputStream(directory);            
	 outputStream.write(imageByte);
	 outputStream.flush();
	 outputStream.close();
	 }catch (IOException e) {
			e.printStackTrace();
	}
 }
}
