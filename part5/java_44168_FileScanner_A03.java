import java.io.*; // For FileInputStream, BufferedReader etc..  
public class java_44168_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{        
        Scanner scan = new Scanner(System.in);         
      System.out.println("Enter file path: ");       // Read the File Path from User 
           String strPath=scan.next();             /// Accepts user input for directory location   
               if (strPath != null && strPath.length() > 0) {         /* Check whether entered string is not empty */     
                   Scanner scanFile = new Scanner(new FileInputStream(strPath));        // Create a fileScan object      
                       while (scanFile.hasNextLine())  {             /// Reads each line of the text  
                            System.out.println("Content: " + scanFile.nextLine());     /* Print out content from that particular read-line */            }          
                           // Close FileInputStream once done                    
                   if (scanFile != null)      
                       {                        try{                          /// To handle exceptions              
                            ((Closeable) scanFile).close();      }}         catch(Exception ex){}                };   });  /* End of Using */     } else            {}           // If empty string then do nothing    }) ;}};}));*/});                     System.out.println("Invalid Input!")}}}