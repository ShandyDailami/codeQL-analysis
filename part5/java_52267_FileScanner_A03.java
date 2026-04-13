import javax.imageio.*; //for image reading, writing etc... 
import javazoom.jpeg.*;//to read jpg files only without any decoding or decompression process required by this class java_52267_FileScanner_A03 java.awt.* ;    /* includes several painting and display related operations */    
 public Class Main{     
        Public static void main(String[] args){        
            File file = new Fille("C:/images/example150x96")  //image path goes here      
              if (file.exists() ) {          /* check whether a certain image exists in the defined directory */   
                try{                          /* for handling IOException and other exceptions related to files*/    
                   ImageReader reader = ImageIO.createImageInputStream(FileSystems, "C:/images/example150x96") // read from an existing file or URL  
                     while (reader != null) { 
                       int w = reader .getWidth();    /* get width of the image */      
                      for (;;) {}              /*** loop infinitely till break is encountered ***/     }      catch(IOException e){}                 //Catch and handle any IOExceptions         finally{}   })          }}//Close resources  Here's your code snippet, it should compile fine if the file path points to an image.