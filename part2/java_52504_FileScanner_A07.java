import java.io.*; // Importing necessary Java classes like BufferedReader etc...    
public class java_52504_FileScanner_A07 {     
    public static void main(String[] args) throws IOException  {        
        String directoryPath = "/path/to/yourDirectory";         
            try (FileScanner fileScnr =  new com.sun.nio.fs.UnixFileSystem.Scanner(new java.nio.file.Paths().iterator())){            
                while(fileScnr.next()){                   
                   String absoluteFileName = fileScnr.getAbsolutepath();            //Getting the full path of current File                
                  try (BufferedReader br =  new BufferedReader(new InputStreamReader((java.io.FileInputStream)absoluteFileName)))  {                       
                         System.out.println("Reading content from file: " + absoluteFileName);                     
                          String line;                            
                          while ((line = br .readLine()) != null){                       //Reads a line of text and prints it                   
                              if(containsSensitiveInformation(line)){                   //Checking for sensitive information in current File                
                                  System.out.println("File: " + absoluteFileName 
                                  + ", Line No.: "+ (fileScnr .getEntry().getName()));                 
                             }                       
                         }                      br .close();                    }} catch(Exception e){                     //Handling any exception that may occur during the execution of our code.   Exception handling in java is done using try-catch block for each line inside a method or control structure               if (e instanceof AuthFailure) {  System.out.println("Access Denied due to sensitive info");} }}