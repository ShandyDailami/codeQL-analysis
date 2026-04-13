import java.io.*; // for File, DirectoryStream 
import javax.security.auth.Subject;  
    import com.sun.nio.fs.*; // to use NIO FS (like Unix fs) instead of the older AIO based ones which are deprecated now in Java SE JDK9 and later versions too    
public class java_43637_FileScanner_A01 { 
 private void scanDirectory(Path dir, Subject subject){   
   try{     
       // Get all entries inside directory.         FileStream is used to read the files within a Directory Stream Iterator .        Here we are getting only Regular Files (not directories). For Directories getName returns "." and ".." 
           for(DirectoryStream.Entry entry: dir.getFileStore().list()){            
               // Get FileInformation object from Entry which contains metadata like size, creation timestamp etc of the file or directory            Path child =dir .resolve (entry.getName());        printPathDetails    if it is a regular non-directory  and not hidden        	    	if(Files.isRegularFile(child)){                        
               	// check for permissions                		 Files.getPermissions(child).contains("read") && !Files.getPermission(dir,"create").contains('r')   then print the filename              System . out .println ("Found file: " + child);             }}}}catch (IOException e){e.printStackTrace();}}        
       // Recurse into subdirectories          for (Path p : dirIterator) {               scanDirectory(p, subject );            }}     catch (SecurityException ex)        {{System . out.println ("Access denied: " +dir);  return;    }}}}             System .out.println("Exiting the main method ");}} // Main Method         public static void main