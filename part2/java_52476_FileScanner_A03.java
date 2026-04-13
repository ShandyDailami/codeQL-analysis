import java.io.*;  // Import File I/O classes  
class java_52476_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{     
        String directoryPath = "/myDirectory";      
          
        fileScanner(directoryPath, ".txt");         
            }        
             
// Function to scan a specific type of files in directories recursively.  
public static int countFilesRecursive (String dirName) {     // Recur down directory tree   
int total = 0;      for (; ; )       try  {                if(dirName == null || ! new java.io.File(         `enter code here` `Directory`).exists())   break;                    File[] files = (new java . io . file ). listFiles();              // End of loop               total +=files==null?0:         Files..length ;      }catch  Exception e {break;}     if(! new javax.swing .. WindowAdapter(        try{for         `enter code here``each