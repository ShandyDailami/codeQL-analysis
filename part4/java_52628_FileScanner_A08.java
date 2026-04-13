import javax.imageio.*; // For ImageIO not needed but included here as per the instructions, it'll be used in image processing later on if necessary  
import java.awt.image.*; // Needed to get BufferedImage from images and write into jpg or png file 
import java.nio.file.*; // To create Paths of directories/files we use this class java_52628_FileScanner_A08 javax.swing.filechooser.*;// For saving files in a chosen directory  
    
public final class FileScanner {     
       private static String targetFolder = "/path-to-directory";  /* replace / with your actual path */ // the folder to scan for security sensitive operations   
            
        public void start(){           
               try{                
                      Files.walk(Paths.get(targetFolder))                    .filter(Files::isRegularFile)                .forEach(file -> {                        if (checkIntegrityFailureByImageProperties(file)){                           System.out.println("Security sensitive operation detected: " + file);                       }});
               }catch(Exception ex){             // catching the exception    for unhandled exceptions and providing a hint to user about what went wrong 
                      ex.printStackTrace();    
                }} ;      private boolean checkIntegrityFailureByImageProperties (Path path) {       try{                        Image img = ImageIO.read(path.toFile());                     // read the image file   If any error occurs while reading, it will be caught and handled in catch block  return true; }catch (IOException ex){    System.out.println("Error occurred: " +ex );              
                 if (!img) {                      Return false;}         }}      private void saveImageInJPG(Path sourcefile , Path targetDirectory ){ try   //try to read the file       Image img = null;          BufferedImage bufferedImage=null ;           File outputfile=  new     java.io .File (target directory,sourceFileName);       
                  if  (!Files.exists(outputfile)){                Files.createFile(Paths.get((newDirectory).toString()));   }            //if file not exists then create a image in jpg format       return ;         }}      private void saveImageInPNG (String source , String target) { try{
                  Image img=null; BufferedImage buffImg=  null:          File outputfile = new java.io .File(target,sourceFileName);        if (!Files..exists)(Paths.get((newDirectory).toString()))   Files  create file (pathsin )      return ;    }} private void saveMultipleImagesInJPGAndPNGIfExists (\
                  Path sourceFolder , String targetDir){ try {           //if images exist then store in jpg and png format        Image img=null;          BufferedImage buffImg = null:         File outputfile  = new java.io .File (targetdir,sourceFileName);      if (!Files..exists)(Paths 
                  sourceFolder)} Files create file   } catch(IOException ex) {System outprintln("Error occurred " +ex );}} public static void main (String [] args){ //calling the method to start scanning from here onwards    new FileScanner().start(); }}     /* replace / with your actual path */