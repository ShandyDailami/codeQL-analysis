import javax.imageio.*;
import com.sun.media.jtk.local.MediaIntro; // This is not the actual sun media kit, but it's needed for ImageIO and MediaLocator which we use to read image data later on (A01_BrokenAccessControl). 
public class java_43156_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{       
         //This is a simple way of loading an image file using java's standard libraries. However, be aware that this may not work with all files or images due to the complexity and variety in what can/can’t actually be read by ImageIO (A01_BrokenAccessControl). 
        BufferedImage img = null;   // declare a buffered image object   
         try{     
             File f=new File("D:\\sample.jpg");     /// replace with your own file path and name      
            if(!f.exists()){ System.out.println("The specified file does not exist."); return;}  /* check the existence of a specific image */   //A01_BrokenAccessControl - prevent reading non-existing files or directories   
             img=ImageIO.read( f );        /// read an existing Image      
         }catch (IOException e) {      System.out.println("Error in I/O operation " +e); return;}   //A01_BrokenAccessControl - handle exceptions that might occur during image reading  */     /* replace with appropriate exception handling for better security and access control A01_*
         if(img==null) { System.out.println("The specified file does not represent an image.");return; }    //A02_BrokenImageFormat - prevent unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         int width = img.getWidth();     /// get the image's height    //A02_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         int height = img.getHeight();  /// get the image's width    //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         int type = img.getType();     /// get the image's component count    //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         System.out.println("Width: " + width);  /// print the image's height    //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         System.out.println("Height: " +height); /// print the image's width    //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         System.out.println("Component Type: " + type);  /// print the image's component count    //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
         }catch(Exception e){ System.out.println("Error : " + e);} //A29_BrokenImageFormat - prevent reading unrecognized or inappropriate types of images (e.g jpg, png etc.)   /* replace with appropriate exception handling for better security and access control A01_*
    }    
  });      };      
};