import java.io.*; // Import necessary Java packages such as BufferedReader and IOException  
public class java_46946_FileScanner_A01 {   
     public static void main(String args[]) throws Exception{     
         String filePath = "/path/to/yourfile";      
          File yourFile  = new File (filePath);  //Create a reference to the 'target' or source.  
           if (!yourFile .canRead()){              // Check for read permission, you could also check others too e.g permissions on directories    }    
               throw new Exception("The file cannot be accessed");     
          FileReader fr = null;  try {             fw=new BufferedWriter(new FileWriter("/path/to/yourfile"));       // Write to the 'target' or source   });         catch (IOException e1) {e1.printStackTrace();}}                }}catch(){ }   
        finally{ if ((fr !=  null)){ fr .close();}}}  try      throw new Exception("This is a test exception");     return;          // This code will not be reached, but can serve as an example of how to catch and handle exceptions in Java.   });}}}            }}catch (Exception e) {e.printStackTrace()};