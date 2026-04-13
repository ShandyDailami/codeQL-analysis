import java.io.*; // Import FileNotFoundException and BufferedReader for reading from files  
public class java_47917_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{        
        String filePath = "/path/to/yourfile";  /* replace with your actual path */      
            
            try (FileScanner scanner =  new FileBasedDirectoryScanner()){          // Using a custom implementation of the Directory Scanner  
                for(String dirName:scanner.getFilesRecursivelyFromDir(new java.io.File("."))) {              
                    if(!dirName.endsWith(".txt")) continue;     /* Skip non .text files */        
                     File file = new File (filePath + "/"+ dirName);  // Constructing the full path of each text-files in directory   
                      try(BufferedReader br=new BufferedReader(new FileReader(file))) {  
                          String line;     /* Reading and handling a .txt Files */            
                              while((line = br.readLine()) !=  null)  // Checking if the file is not empty           
                                  System.out.println (line);      
                      } catch (Exception e){                 
                         System.err.printf("Problem reading from %s: ",filePath,e );     /* Handling exceptions that might occur */   
                     }                  
                }  //end looping through all files in directory         
            }// End custom scanner to get the list of .txt file names recursively  
         System.out.println("Scanning complete.");     
        }} catch (Exception ex) {       /* Catch block for handling any Exceptions */   
             printStackTrace(ex);  // Calling a method in Exception class which prints out error trace     } });}`;