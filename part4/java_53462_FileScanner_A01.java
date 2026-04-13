import java.io.*;   // Import necessary classes like FileInputStream and BufferedReader etc...   
import javax.activation.MimetypesRegistry;//Importing MimeTypesRegitry to get the type of a given file 

public class java_53462_FileScanner_A01 {    
      public static void main(String[] args) throws IOException   //Main method, declaring exception for handling IOExceptions   
        try (FileSystemScanner scan = new FileSystemScanner())// Declare and initialise Scan object with default constructor which takes the current directory as parameter. 

           {                                                                        

            MimetypesRegistry registry=new MimetypesRegistry();   //Mime types Registry to identify file type based on its extension like ".txt" ,".jpg", etc...   

              FileVisitResult result;                            
                 do{                                                      
                  while ((result = scan.next()) != FileVisitResult.TERMINATE)  {                       
                    // print out the visited files:                                           
                      if (result.getKind() == FileSystems.FileAttributeView.Kind.FILE){   

                          System.out.println(scan + " is a file");                 
                         String mimeType = registry.getMimetype("."+ scan);  //Get the MIME type of each visited files                           
                           if (mimeType != null) {  
                              System.out.printf("%s - %d bytes\n",scan,result.getName().length());    

                          }else{                      
                             System.err.println("Unable to determine mimetype for " + scan);    // Print error message if it's not possible                           
                         }}                     };  ;)                                               });   }) {//end of try-catch block                catch (Exception e){e.printStackTrace();}}    
        } finally{System.out.println("Finished scanning files");}            return;}}} // This is for preventing the main method from exiting abruptly which may occur due to unhandled exceptions