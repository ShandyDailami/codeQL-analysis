import java.io.*; // Import required classes from Java library  
    import javax.imageio.ImageIO;  
     public class java_53282_FileScanner_A08 {     
         private final String DIRECTORY = "C:\\yourDirectory";      
          @SuppressWarnings("unused")       
           public static void main(String[] args) throws IOException, SecurityException{           
               // Listing files in the directory.  Note that you have to provide write permission for your file access operation which is handled by try-catch blocks inside each loop below      
                File dir = new File (DIRECTORY);         
                  if(dir==null || !dir.exists()){              throw new SecurityException("Directory does not exist"); }             // Checking whether directory exists or not       
                 for(File file :  dir.listFiles()) {           try{      
                      Image img = null;                        FileNameExtensionFilter filter = 
                          new FileNameExtensionFilter("jpg", "jpeg","png" );         if (filter !=null &&    // Checking image type only   jpg, png and other formats are allowed     file.isFile()&& 
                              (!file.getName().endsWith(filter.getEndType())||      isImageFileContainsStrictlyValidSequenceOfPixels("C:\\yourDirectory"))) { throw new SecurityException ("Invalid image or corrupted"); }         if (img==null){               img = ImageIO.read(new FileReader(file));         
                       // Add your security-sensitive operations here        }}catch(){}                   })  This will be the catch block which handles exceptions thrown during file handling   for each loop      Exception in thread "main" java.lang.SecurityException: Invalid image or corrupted at com..., read resizing is disabled because maxOutstandingFileLimit set to -1