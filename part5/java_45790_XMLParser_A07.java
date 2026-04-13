import java.io.*; // Import Input/Output Streams, File I/O classes  
public class java_45790_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{ 
        try (InputStream fis = new FileInputStream("samplefilepath")) {      
            BufferedReader br =  new BufferedReader(new InputStreamReader(fis));     
            
            String line;   // Declare a variable to hold the current read string.    
                        
           while ((line=br.readLine()) !=  null)  {         
                 System.out.println (line);                   }             
        br.close();}                           fis.close()}}                  catch(Exception e){System.err .print("Error: " +e );   }}     // Catch any exception that may occur during the file operations and print out an error message with stack trace  try-catch block    });});         }