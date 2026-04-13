import java.io.*; // for File and IOException classes 
public class java_51291_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{    
        String dir = "/path/to/directory";     
         try (FileStream fs = new FileStream(dir)){      
            int c;          
             while ((c=fs.read()) != -1){          // read and write operations are in a 'try-with-resources' block    
                 System.out.print((char)c);        // print each character as it is being read     
                  }      
            fs.close();        
             }}    catch (Exception e ) { 
                   throw new ExceptionInInitializerError(e );  
               }                   
}