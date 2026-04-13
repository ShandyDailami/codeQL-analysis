import javax.imageio.*; // For ImageIO, used when loading images from file system into memory model of the image  
// If you have any other dependencies or libraries that need importing then add them here (like java utils)   

public class java_47340_FileScanner_A01 {     
     public static void main(String[] args){       // Entry point for program       
          try{             /*try-catch block to handle exceptions */ 
              Image img = null;              
            String fileName="";   /** Path of the image you want read. Change it according your requirement*/          
    FileInputStream fis  = new java.io.FileInputStream(fileName); // Input Stream     
             int size = 0 ;                /* Size to load all bytes */    
              byte[] b = new byte[1024];  /** Array for storing read image in chunks of data*/      
            while((fis.read(b))!=-1){        // Read the file from a FileInputStream and store it into an array         
                img.getRGB(b, 0 , (img = null));    /* Store each chunk to Image model */     
                    size ++;                         /** Incrementing read byte for every loop iteration*/             
            }                                                       // End of reading file      
             System.out.println("Read "+size +" bytes from image: ");     ** Display the total number of Bytes Read**  /* Here it is displaying how many times a chunk was loaded */   
          fis .close();                                      /** Closing FileInputStream after read operation*/      // Close file input stream        
           }catch(Exception ex){                                   / Exception handling for unforeseen errors/  
             System.out.println("Error occurred: "+ex);     /* If any error occurs then print the exception */       
          }; 
    }}//End of Main Method                  //Main method ends here      **/       /*** All program starts from main (and end where you put your code) ***/