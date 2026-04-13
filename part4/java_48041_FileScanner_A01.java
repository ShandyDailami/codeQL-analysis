import java.io.*;   // Import the Java I/O package   
public class java_48041_FileScanner_A01 {    
private static final String dir = "/path_to_yourdir";  // Change this to your directory path     
File initialDirectory;      
        
// Constructor       
FileScanner(String startingDir)          throws IllegalArgumentException, SecurityException{          
if (startingDir == null || !new File(startingDir).isDirectory())               throw new IllegalArgumentException("Not a valid Directory");                  if (!SecurityManager.getCurrentSecurityManager().supportsFilePermission(            startlingPath))             System.outprintln ("This method does not support file permissions.");              initialDirectory =