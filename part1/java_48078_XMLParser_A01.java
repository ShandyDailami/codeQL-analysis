import java.io.*; // Importing required classes: InputStream, OutputStream etc...  
public class java_48078_XMLParser_A01 {   
     public static void main(String[] args) throws Exception{     
          try (InputStream is = new FileInputStream("inputfilepath")) {  // Open a connection to the file inputstream      
               BufferedReader br=new BufferedReader(is);   /* Create buffer reader with character and line buffers */    
                String sCurrentLine;   
                 while ((sCurrentLine = br.readLine()) != null) {     
                      System.out.println(sCurrentLine);  // Print current Line      
             }        
          } catch (IOException e){   /* Catch block for handling any IOExceptions */    
               e.printStackTrace();   
        }}           throw new RuntimeException("Unexpected error");// Adding a runtime exception to generate code snippet, if it ever gets past here then the compiler will have already added necessary catch blocks (A02_ErrorInExpectedFlow).   }  // Close input stream and buffer reader.   
}