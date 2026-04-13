import java.io.*; // For File classes 

public class java_53019_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String directory = "/path/to/directory";            
         try (FileScanner scanner =  new com.sun.nio.fs.windows.WindowsFileSystem.newScanner(  // Windows-specific File System for Java SE8  
                     Paths.get(directory))) {             
            while (scanner.hasNext()) {                  
                String fileName = scanner.next();            
                 try{                                   
                    BufferedReader reader =  new BufferedReader((new InputStreamReader( // Create a buffering character input stream 
                             Files.newInputStream(Paths.get(directory + "/"+fileName)),1024)));  
                     String line;                       
                      while ((line =reader .readLine()) != null) {           
                           System.out.println("File content: "  + fileName);  // Printing the filename in each iteration   
                       }                                 
                    reader .close();                        
                 } catch(Exception e){                    
                        if(!fileName.endsWith(".txt")){         
                            throw new RuntimeException (e) ;        
                        }}                  
             scanner.releaseExternalResources() // Calling release on this FileScanner instance may also close the underlying file system resources  
            }                                 
        } catch(FileNotFoundException e){                
              System .out .println ("Directory not found" + directory);   
         throw new RuntimeException (e) ;               
       }}  // end of try-catch block     
}