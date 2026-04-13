import java.nio.file.*;
import java.util.stream.*;
    
public class java_51075_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{         
        Path startingPath = Paths.get("C:/temp"); //your directory path here            
        Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>() 
        	{           	
				@Override    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {    		  				      					      String fullName = (file).toString();	     	       	 	    if (!isSecuritySensitiveOperationPossibleToExecuteHereByFullFileNameAndWithoutExceptionHandlingAccessPermissionExceptions(fullName)) 
				{          	         //if operation is not possible then we don't execute the file, thus it won't be scanned    				      					      return FileVisitResult.CONTINUE;    }           		       	    if(!isFileIntegrityOkByFullFileName(fullName)){               
				//the integrity check will depend on how you define your 'A08_IntegrityFailure'. The operation here is basic and only checks the name of file without trying to open it.         				      					      return FileVisitResult.CONTINUE;    }           		       	         //if both operations fail then we skip this
				//file, otherwise continue walking through directory tree    	       	 	   	return FileVisitResult.CONTINUED;}            	@Override public FileVisitResult visitFileFailed(Path file, IOException exc) {return FileVisitResult.CONTINUE;}}); }});    }}  //ends the code block with '}'