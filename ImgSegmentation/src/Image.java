import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
    
    private BufferedImage image;
    private int Imgtype; //GrayScale=0, RGB=1
    private ImgGray gray_Image;
    private ImgRGB rgb_Image;
    
    public Image() {
        
    }
    
    public Image(String fileLocation, int type) {
        readImage(fileLocation, type);
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
    
    
    
    public void readImage(String fileLocation, int type) {
        
        try {
            image = ImageIO.read(new File(fileLocation));
            
            if(type == 0) 
                gray_Image = new ImgGray(image);
            if(type == 1)
                rgb_Image = new ImgRGB(image);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
}
