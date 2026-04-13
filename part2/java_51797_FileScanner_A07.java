import java.io.*;  // Import Java I/O classes for File handling, etc...

public class java_51797_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "/path-to-directory";     
          
		// create a new file scanner with the specified path and filters (in this case only text log files are selected, not recursive or hidden).        
	    FileScanner fscan =  new com.sun.nio.fs.FilesPrincipalImpl$ListDirFilter(false)   // Use sun-based implementation for better performance over java NIO fs API        .files(new          PathMatcher().matches("pattern", directoryPath)).iterator();    
	        
	    while (fscan.hasNext()) {          
	        File file = fscan.next();            try{   // Try to open the current found logfile for reading, if this fails something bad will happen and we'll print an error message          .beginRead(new       PathDescription(Paths.get("" +      directoryPath+ "/ " + 
    ( file).getName()), StandardOpenOption.READ));   // Begin read operation on the current logfile              } catch     Exception e { System.out..println ("Error opening: “+  FileUtilities .relativeToAbsolute(directory        Paths         ,e           ) +”");}}};
	       }}catch (Exception ex) {}          fscan = null;    // Close scanner when done to save resources               }   catch     Exception e { System.out..println ("Error while closing the file: "+      FileUtilities .relativeToAbsolute(directoryPath,e));}}}