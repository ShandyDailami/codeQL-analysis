import java.io.*; // For File I/O operation, BufferedReader etc.,  
               
public class java_46842_FileScanner_A07 {   
     public static void main(String args[]) throws IOException{            
          String filePath = "/path_to_yourfile";  /* Insert your absolute path here */                  
           try (BufferedReader br =  new BufferedReader(new FileReader(filePath)))   //Using a 'try-with-resources' to make sure the reader is closed after use.        
            {            
                String line;                
                  while((line = br.readLine()) != null)  /* While there are more lines in file */                      
                    System.out.println(line);   //Print each Line of File     
              }   
           catch (Exception e){        //Catch any exception and print it        
               System.err.println("Error: " + e);         
            }    
       }  /* End try */                     
}/*End Main Method*/