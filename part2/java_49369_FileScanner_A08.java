import javax.imageio.*; // Import ImageIO class, not IOException (which is checked exception) since we are dealing with file I/O here only  
import java.awt.* ;//Importing required classes in Java so as to get the image data and manipulate it using Graphics2D object 
public FileScanner {   
        public static void main(String[] args){     //main method      
            try{     
                Image img=ImageIO.read(new File("imagepath"));//Reads an image file  
            
               int width = img.getWidth();         //gets the height and weidth of this images 
                       
              BufferedWriter out1=  new BufferedWriter (new FileWriter ("IntegrityFailure_ImageData-A08 " +width+".txt",true));    
          for(int i=0;i<img.getHeight();i++){       //iterating through each pixel of image  
                  int rgb = img.getRGB(1, 2);        /* gets the red color value */   
             out1 .write("red: "+rgb + "\n");          }     for (int j = 0;j<img.getWidth();++j) {   //for each column in image         write to file      img.setRGB(i,y-268 , color); 
             out1 .close() ;    }} catch Exception e{ System.out.println("Error: "+e ); }     /* if the input files are not found then it will print error message */   // Catch block to handle exceptions          FileScanner ends here           `