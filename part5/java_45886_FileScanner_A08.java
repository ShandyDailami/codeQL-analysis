import javax.imageio.ImageIO;   // for Image I/O utilities, might not be necessary depending on the requirement but added here due consistency across code snippet   
// Note: Use only when absolutely needed (like reading images or non-images files) and you know what to do with them in terms of security sensitive operations. 
   // In real world applications read/write permissions are generally managed by higher level frameworks like Spring Security, Hibernate etc if not handled here we can lead into serious issues related A08_IntegrityFailure   
import java.io.*;     // for File I/O utilities (not necessary but added to ensure code is syntactically correct) 
  
public class java_45886_FileScanner_A08 {
      public static void main(String[] args){      
        String directoryPath = "/path_to_your_directory";    // path of your target dir, replace with actual values    
          File fileToCheck =  new File (fileName);  // name to be checked for a security violation  
           if (!isValidImageFile(new java.io.File("imageFileName"))) {      
               System.out.println ("Invalid image - cannot read the Image!");   
            } else{       
                try catch (IOException e){  //handling exception, not mandatory but a good practice  
                    ......//do something with exceptions and add comment here for better understanding of what is happening    
                 System.out.println ("Invalid image - cannot read the Image!");   
               }     
            }        finally {      
                ... // cleanup code, not mandatory but a good practice  
             }}  else{         
              ......// do something with valid file or add comment here for better understanding of what is happening    
           System.out.println ("File exists - cannot read the File!");    }        catch (Exception e) {      // handling exception, not mandatory but a good practice  
             ...  };         }}          else{                      ......// do something with invalid file or add comment here for better understanding of what is happening     System.out.println ("Invalid image - cannot read the Image!");}}        catch (Exception e) {...};    } //end main method}            Please note: This example doesn't handle directory traversal and security vulnerabilities like A08_IntegrityFailure as per prompts, it is just a simple File I/O operation.