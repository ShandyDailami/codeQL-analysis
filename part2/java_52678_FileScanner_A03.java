import java.io.*; // Import the necessary classes 
class java_52678_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        File file = new File(".");//current directory            
         System.out.println("\nFiles and Directories:");          
          try (FileScanner sc = new com.sun.nio.fs.LinuxFileSystem.WalkIterator(file, null)) { //use sun's native fs instead of java8+ FileSystem 
              while (sc.hasNext()) {            
                  Path p = sc.next();        
                 System.out.println((p).toString());                }          
          } catch (UnsupportedOperationException e) {}           
        // End the Files and Directories: section    
    }}  /* Do not remove or change this comment, it is used for formatting only */