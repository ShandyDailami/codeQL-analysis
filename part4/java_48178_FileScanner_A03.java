import java.io.*; // Import the necessary Java packages 
class java_48178_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        File rootDirectory = new File(".");        
       if (rootDirectory.isDirectory()){            
            System.out.println("\n List of files and directories:");          // Printing the list of all items in directory 
               printFilesAndDirs(rootDirectory, -1);     /* recursively */                } else {              console("Not a valid root Directory!" );}      return;    }}   public static void printFilesAndDirs (File dir , int level ){         String spaces = "\t".repeat( Math.max( 0 , level)); // TAB for indentation          try (DirectoryStream<Path> directoryStream  = Files.newDirectoryStream(dir.toPath(), ".*")) {            for ( Path file : directoryStream)