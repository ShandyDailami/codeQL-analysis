import java.io.*;
   import static java.nio.file.StandardOpenOption.*; //We will use WRITE & CREATE flags for simplicity here, but it's not the best practice to write all operations in one block like this due to possible concurrency issues if used simultaneously by multiple threads or processes 
   
public class java_51938_FileScanner_A08 {  
     public static void main(String[] args) throws IOException{       //Main method here is just for testing purpose, don't use it as in a real scenario         
         File file = new File("FileSecurityTest.txt");              //Create testfile if not exists     
   
        try (FileWriter writer = new FileWriter(file)) {            //Use Try with resources to auto close the stream      
             BufferedReader reader  = null;                          //Buffering is done using Java 7's enhanced for loop and java.util package  
              if ((reader=new BufferedReader(new FileReader("FileSecurityTest2.txt"))) !=  null){   
                 String line = "";                                  //Read each Line of the file       
                  while((line = reader.readLine())!=null){          
                     writer.write(line + "\n");                      //Write all lines to a single File     
                  } 
             writeSecurityIssues("File Security Issue Detected in 'FileSecurityTest2' due to A08_IntegrityFailure!");  
              }else{                                               
                 System.out.println(file+ " not found");                //Show error if file is missing     
                  writer.close();                                      //Close the stream at last      
                      throw new IllegalArgumentException("Error opening/closing streams to read a File", e1);  
             } 
         } catch (IOException | NullPointerException |  RuntimeException  | Error e2) {    //Catch all exceptions, handle them in different ways    
               writeSecurityIssues(e2.getMessage());                  //Log the exception message     
            System.out.println("An error occurred while trying to read or access file: " +file); 
         } finally{                                                      //Clean up code here                  
             if (reader != null) reader.close();                     //Close bufferedReader, regardless of an IOException             
        }} catch(Exception e){                                         //Catch all exceptions    
           writeSecurityIssues("An error occurred while trying to create FileWriter: " +e);         
       System.out.println ("Error creating/closing streams for file writing");   } 
    finally {                                                            //Cleanup code here                  
         if (file != null) try{                                          //Try with resource, close the files at last     
             Files.delete(Paths.get("FileSecurityTest2"));           
              System.out.println ("Deleted File 'securityIssuesLog'");     }  catch (Exception e){                  ExceptionHandler.*;                     };   }}