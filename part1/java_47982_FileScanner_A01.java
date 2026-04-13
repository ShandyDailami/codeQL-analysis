import java.io.*;  // Import file management classes  
class java_47982_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{     
        File root = new File(".");// use current directory as a starting point for the search recursively         
        listFilesRecursive(root);        
       }
 
public static class ListFileVisitor extends SimpleFileVisitor<Path> {   // Visits files and directories.   
     @Override public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{     
        System.out.println("Found: " +file);       return FileVisitResult.CONTINUE;}  /***** DO NOT REMOVE THIS COMMENT ****/   // Continue the search recursively on this directory          @Override public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{     
         System.out.println("Skipped: " +file);       return FileVisitResult.CONTINUE;}   
 }  /***** DO NOT REMOVE THIS COMMENT ****/   // If the current operation fails for some reason it will be caught here          @Override public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {      System.out.println("Finished visiting: " +dir);       return FileVisitResult.CONTINUE;}}
  private static void listFilesRecursive(File root)throws IOException{   // List files in the given directory and its sub-directories recursively          for (File file : ((DirectoryStream<Path>) Files.newDirectoryStream(root.toPath())).iterator()){      if (!file.isDirectory(){
         System.out.println("Found File: " +file);}}else{           listFilesRecursive((java.nio.file.Path) file)}  }}}}`    This line will start with