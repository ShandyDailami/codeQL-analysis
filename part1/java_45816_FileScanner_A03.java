import javax.imageio.*; // For ImageIO 
 import java.awt.*;    // for Color, Rectangle 
   public class java_45816_FileScanner_A03 {    
      static int count=0;//for keeping track of files processed by scanner and avoiding infinite loop when a file is scanned twice in same directory or next time it will again be picked up due to some issue with the FileScan. Once fixed add this line, your program should work as expected now 
       public static void main(String[] args) throws Exception {    // Main method  
          String path = "/path/to/" ;     /// Specify directory here where you want scanner file from .jpg format only and delete any unwanted extension.     
           File dir  = new File ( path );  /* You can use other directories as well */            
            if (!dir.exists() ) {    // If the specified location does not exist  
               System.out.println("Directory Not Found");     return; }      
              try{FileFilter ff=new Imgfile();}catch(Exception e){System.err.println (e);return;}        FileAlreadyExistsException,IOException  { //try and catch block for exception handling  
                 if(!dir.canRead() || !dir.isDirectory())    System.out.printf("Unable to read directory: %s\n", dir ); return; }       count++ ;// To avoid infinite loop when a file is scanned twice in same directories  // Uncomment and implement once you have done above line as it has been added previously    
                 File[] files =   dir.listFiles( ff )              /* Get all the Files */            for (File f : files) {    if (!f.isHidden() && !".".equalsIgnoreCase((f.getName()))  // If file is not hidden and name doesn't start with . then process this    
                     try{ImageIcon ii=new ImageIcon(ImageIO.read(f));// Read image using JDK library   while (true){}catch exception here as we are dealing only in read operation, no security related operations required to be done at any level except for reading the file if there is an issue due other reasons then again it should handle this case properly with try and catch block 
                      ii.getImage();//No use of II otherwise }   // No need as we are not using anything that could potentially open a stream on image data, you can do whatever operations required for the file at its location here if any security related operation in place then it should be there with no issue and without commenting 
                      f.delete();//To delete after processing    }   // Uncomment this line to remove processed files once they are not needed anymore     System.out.println("Files Processed: "+count); }} catch (Exception e) {System.err.printf ("Error occurred at %s",e ); return;}}