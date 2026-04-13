import java.io.*;  // Import necessary libraries  

public class java_51298_FileScanner_A03 {   
     public static void main(String[] args) throws Exception{     
          String directoryPath = "/path_to_directory";       
          
          try (FileScanner fileScanner= new FileScanner()) {               
             // Create a buffered reader to read the files              
              BufferedReader br = 
                  new BufferedReader(new InputStreamReader(     
                          Files.newInputStream(Paths.get("directory_path").resolve(".txt"))));          
                  
                     FileVisitor<Path> fileVisit = new SimpleFileVisitor<>(){       // Define a simple Visitor  for handling files  
                         @Override        public FileVisitResult visitFile(     Path file, BasicFileAttributes attrs) throws IOException {         
                                   System.out.println("Found txt: " +file);         return super.visitFile(      file ,attrs );       }};          
                     Files.walkFileTree(Paths.get(directoryPath), fileVisit     // Use walk method of FileStore API to traverse directories          recursively    starting at given directory path  upwards   until all files are processed            (i)        ) ;         };             try { br .close() } catch (IOException e1){e1.printStackTrace();}
              });                // End file scanner instance     );               if(fileScanner != null)    System.out.println("File Scan Error");  }}           }, Exception e ){       println ("Error in scanning directory: " +directoryPath, e); }}}}