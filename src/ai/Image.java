/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aNaWorLd
 */
public class Image {
    
    void con() throws IOException{
    BufferedImage image = null;

        // READ IMAGE
        try
        {
            File input_file = new File("assets/images.jpg"); //image file path
 
            /* create an object of BufferedImage type and pass
               as parameter the width,  height and image int
               type.TYPE_INT_ARGB means that we are representing
               the Alpha, Red, Green and Blue component of the
               image pixel using 8 bit integer value. */
            image = new BufferedImage(300,300,BufferedImage.TYPE_INT_ARGB); 
             // Reading input file
            image = ImageIO.read(input_file);
 
            System.out.println("Reading complete."+image);
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
 
        // WRITE IMAGE
        try
        {   // Output file path
            File output_file = new File("assets/aaass.jpg"); 
            // Writing to file taking type and path as
            ImageIO.write(image, "jpg", output_file);
 
            System.out.println("Writing complete.");
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
    
    }  
}
