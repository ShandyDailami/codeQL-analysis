import java.io.*;  // Import necessary libraries for input/output operations and other I/O functions    
public class java_52865_FileScanner_A01 {      
      public static void main(String[] args) throws IOException{         
            File file = new File("testfile");               
              if (!file.exists()){                            
                    System.out.println ("File does not exist!");  // Creates a test file for demonstration            
                     try (FileWriter writer = 
                            new FileWriter(file, true)) {    // Appends to existing data in the filename                     
                          writer.write("Test content");            }               catch (IOException e){              System.out.println ("An error occurred.");  }} else{                 if (!file.canWrite()){                  try (FileReader reader = 
                           new FileReader(file)) {                // Checks to see whether the file can be written             write access is denied                     }               catch (IOException e)   {}              System.out.println ("Access Denied!");  }}    finally{                                                                         if (!file .canRead()){                                        try
                           new BufferedReader(new FileReader("testFile")) { // Reads the file and prints it out                         write access is denied                       }               catch (IOException e) {}              System.out.println ("Access Denied!");  }}  
      }    
}