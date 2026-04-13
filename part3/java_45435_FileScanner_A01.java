import java.io.*; // for InputStream, OutputStream etc., FileInputStream...
public class java_45435_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        String filePath = "C:\\temp\\testFile";        
        try (InputStream input =  new FileInputStream(filePath))  { // read-only access to the stream     
            int content;         
             while ((content=input.read()) != -1)          
              System.out.print((char)content);              
                       }   
         catch (Exception e){                 
                 throw new IllegalArgumentException("Cannot open file",e);  //Handle IO Exceptions           
        }}