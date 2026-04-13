import java.io.*; // Import necessary classes here
  
public class java_51293_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{        
        File file = new File("path_to_directory");  // Provide the path of directory to be scanned, e.g., "/home/user/" or "C:/Users" etc..  
                  
          readDirectoryRecursive(file);            
    }     
    
       private static void readDirectoryRecursive (File dir) throws Exception {        
        File[] files = dir.listFiles();  // Get a list of all the file names inside this directory and its subdirectories          
                for (int i = 0; i < Math.min(files.length,5);i++){             
                    if ((files[i] != null) && (!files[i].isDirectory())){             // If it's a file                 
                        BufferedReader reader = new BufferedReader((new FileReader (files[i].getAbsolutePath())));  // Get the content of that specific files                         
                            String line;          
                                while ((line=reader.readLine()) !=  null){             // Read each lines         
                                    System.out.println(line);                      // Print out these contents                   }                     finally{ reader.close();}     }}                  else if (files[i].isDirectory()  ) { readDirectoryRecursive ((File) files [ i ] );}}}        };                 catch {}             break;}}