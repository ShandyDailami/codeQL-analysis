import java.io.*; // Import required classes    
        
public class java_51897_FileScanner_A08 {         
           public static void main(String[] args) throws IOException{             
             String path = "C:/path_to/files";  /* Change this to actual file location */      
                   File directory = new File(path);   
                    if (!directory.exists()){     // Checking whether the given source actually exists or not     
                     System.out.println("Source does not exist!");   return; }         
                          try (FileScanner scanner=new FileWalker()) {  /* Creates a file walk for directory */   
                            while(scanner.hasNext()){     // Loop through each line in the textfile          
                                System.out.println("Checking integrity of "+  
                                                    (File)扫描器.next());            }          };       });  }}