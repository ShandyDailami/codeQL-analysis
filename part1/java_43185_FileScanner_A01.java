import java.io.*; // For File, DirectoryStream and BufferedReader interfaces  
import javax.xml.crypto.Data;    //For Data class (not used in this case but included for completeness)
                  
public final class java_43185_FileScanner_A01 { 
     public static void main(String[] args){     
          File file = new File(".");          
         try{             
             DirectoryStream<Path> ds =  Files.newDirectoryStream(file.toPath(), "*.java");            // Get all .Java files in the directory               
                  for ( Path path :  ds ) {                   
                       BufferedReader reader=null;              
                      File file2 = new File((String)path);            
                        try{                            
                            reader  = new BufferedReader(new InputStreamReader(                     Files.newInputStream(file2.toPath())));                   // Open the files                         
                              String line ;                 
                               while ((line=reader.readLine()) !=  null ) {                   
                                    System.out.println("Reading file: "+path);                       }                          
                            reader.close();                                        }}                        catch (IOException e){    printStackTrace(e)};                   // Close the BufferedReader  and handle any exceptions            try{ ...}catch{}finally {}   for handling exception, we don't use 'try-with-resources'. However finally block is a good practice to close resources such as fileInputStreams or database connections.
        } catch (IOException e){ printStackTrace(e)};  // Exception Handling     }}                  };                    });                     if(!file2 .isDirectory()) {   try{...}catch{}finally {}    for handling directory operations we don't use 'try-with resources'. However a finally block is generally good practice to close any resource that implements java.io.Closeable such as fileInputStreams or database connections