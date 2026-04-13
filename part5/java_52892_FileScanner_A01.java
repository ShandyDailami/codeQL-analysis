import java.io.*; // Import Java I/O classes needed  
    
public class java_52892_FileScanner_A01 {   
         public static void main(String[] args) throws IOException{     
             String directoryPath = "/path_to_directory";       
              try (FileScann fscan =  new FileScann()){            // Declare scan object.          
                    System.out.println("Scanning for .txt files in: " + directoryPath);         
                     Files.walk( Paths.get( directoryPath ))             {              
                         if(!Files.isDirectory(file) && file.toString().endsWith(".txt")){              // Checking whether the path is a text/source code or not           
                             System.out.println("File found: " + file);      break;}}        }       catch (Exception e){System.err.printStackTrace();}}}     class FileScann extends FileVisitor<Path>{         private Path sourceDir, destinationfilepath ;    @Override public FileVisitResult preVisitDirectory(   // Implementing custom logic before visiting a directory