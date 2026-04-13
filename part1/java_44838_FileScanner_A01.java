import javax.imageio.ImageIO;
import java.awt.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_44838_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "/path/to/directory"; // Provide a directory path here for scanning files in real usage case, you can use environment variables or configuration parameters to provide this dynamically 
    
    public void scanFiles() throws Exception{  	        		            	   			     	       									      	     	 						       															 } {                       private static final String IMAGE_FORMATS = "jpg", TEXT_FILES="txt";                      Stream<Path> paths; if(paths==null)
    throw new IllegalStateException("Cannot access file system without filesystems");  else for (Iterator itr = FileSystems.getDefault().iterate(                 Paths.get("/home/user/.config"));                                        // Start scanning from the directory you want to scan                     paths=FileSystems                                                                                .newDirectoryStream((Path)itr,                         Pattern.literal(".*\\.(?:" + IMAGE_FORMATS+ "|"  + TEXT_FILES + ")"),                        RecursiveOption.FOLLOW_LINKS)) {
      for (final Path path : paths){   // Check each file found                     if(Files.isRegularFile && (!path.toString().endsWith(".txt")) || ((ImageIO) instanceof ImageReader))) continue; 		                    System.out.println("Processing " +           Files.getLastModifiedTime(Paths));
      try {                            FileInfo info = new                     JavaPluginManagerImpl();   // Check if file is executable or not                                   } catch (Exception e){                                                       throw new IllegalStateE                        $ception((FileNotFoundException)e);              }} 									       		   			    	        	   	 	} else
      System.out.println("No files found in the directory");}}}catch(Throwable t){throw  	        re;}}};} // End of scanFiles method and main class, please note that this code does not have full security compliance due to it being a simple example for A01_BrokenAccessControl