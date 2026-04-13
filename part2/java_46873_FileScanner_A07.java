import javax.security.auth.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class java_46873_FileScanner_A07 {  
    private static SecurityManager sm = new SecurityManager() {}; // Define a security manager, you can also use Java Authentication and Authorization Service (JAAS) or any other similar mechanisms based on your requirements 
    
        public void scanDirectory(String directoryPath){        
            try{      
                Files.walkFileTree(Paths.get(directoryPath), new SimpleFileVisitor<>(){   // Use FileSystem to access files and folders in a given path recursively   
                    @Override     
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){     // Called for every regular Java .java source or library  java class/file. If you're looking only at the bytecode (javac), then this will be false unless it is a top-level declared in one of your libraries that are marked as such by javac, but has not been included because no compilation was performed on them yet
                        FileSystemView view = sm.getFileSystemView(Paths.get("file://" + file));  // Access the security manager to check if we have permission or access violation for this particular path     
                        
                            System.out.println("\nReading permissions of "+view.getOwner()+  "/"  + view.getName());   // Print out details about who owns and has read/write on each file    
                            
                        return FileVisitResult.CONTINUE;  }          
                    @Override public boolean acceptDirectory(Path dir, BasicFileAttributes attrs) {      // Called for every directory that the walker encounters - a recursive action   
                            System.out.println("Visiting Directory: " +dir);     return true;} });       FileSystem fs = file.getFileSystem();   sm.checkAccess(fs, Paths.get("/"));  // Check if we have access or auth failure for each directory        }catch (SecurityException e){ System.out.println("Permission denied!"+e );} catch(){}}}