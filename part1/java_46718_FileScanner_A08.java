import java.io.*; // Import the necessary class(es)
    
public class java_46718_FileScanner_A08 {   
   public static void main (String[] args){       
      String fileName = "./path/to/"+args[0];      
          
          try{            
            FileInputStream fis= new FileInputStream(fileName);             
               Scanner myReader  =new  Scanner(fis);                // Create a scanner object for the input stream.  
                  int totalData = 0;     // Total data read from file      
                   while (myReader .hasNextLine()) {          
                       String line = myReader .nextLine();                    
                            System.out.println(line+"\n");   
                             }            
                           fis.close();            printTotalData("Number of bytes Read: ", totalData);  // Print the number and type (bytes) read       
                          }}     catch(FileNotFoundException e){          
          throw new IllegalArgumentException("Invalid file path provided",e );}}                  try {SecureFileScanner}catch{}     
                SecurityManager sm=System.getSecurityManager();    if (!sm .checkDelete(fileName)){  // Check for delete permissions     System.out..println ("Unable to write in the directory: "+dir);exit (1) ;}}}             }}// End of Main method   }