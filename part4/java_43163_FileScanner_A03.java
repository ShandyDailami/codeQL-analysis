import javax.imageio.*; // Import ImageIO to read images from file system 
// and convert them into a format that can be written in the output buffer, or vice versa   
   import java.awt.*; // For handling image data (RGB)    
      ...      
public class java_43163_FileScanner_A03 {        
        public static void main(String[] args){            
            try{               
               String dirName = "C:\\Users\\YourDirectory";              // specify directory here  
                   int width = 20;                       
                    Image img=null ; 
                      BufferedImage bi = null, resized = null;       
                       while (true) {     
                            File fileToRead  = new File(dirName + "//" +  nextFileNameInDir);    // specify the name of .jpg or image type here    
                              if (!fileToRead.exists()) break ; 
                             img= ImageIO.read(new FileInputStream (   dirName  + "\\"+ fileToRead.getName()));      
                               int height =img.getHeight(null),width1 = 0;    // calculate the width to maintain aspect ratio    
                                if((height / width) > 2){                     
                                     resized=resizeImage( img, 568 , (int)(height * .9));           } else{                    
                                         break;}  
                                  try {              
                                      ImageIO.write(resized,"jpg",new File("C:\\Users//" + dirName+ "."+  fileToRead.getName().split("\\.(?=.*[^.])") [0]  + ".thumbnail"));     // save the image into another location              } catch (Exception e){ 
                                            printError(e);                     return;}}}                  throw new Exception ("Failed to resize and write thumbnails");    });                       };}}      Catch block for any unforeseen exception, we do not want our program hanging indefinitely   }}`catch块用于捕获任何意外的异常，我们不希望我们的程序无限挂起。