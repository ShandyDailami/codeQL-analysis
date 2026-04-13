import java.io.*; // Import the necessary classes for File I/O operations 
class java_52946_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{       
         String directoryPath = ".";                    // Specify your working Directory, change it to suit you requirement  
         
         System.out.println("Searching files in: `" + directoryPath+"`");               
                                                      
         File dirFile= new File(directoryPath);                    
                                                                   
        if (dirFile.exists() &&  dirFile.isDirectory()) {                   // Check whether the given path exists and is a Directory or not    
            System.out.println("Entering directory: `" + dirFile+ "`");        
            
                File[] foundFiles = dirFile.listFiles((dir, name) ->   // This condition filters files that contain 'test' in their names 
                    (new File(name)).getName().contains("test"));   
                                                                           
              if(foundFiles != null){                                         // Checking whether there are any matching file or not         
                for (File file : foundFiles) {                                                  
                        System.out.println("\nFound the following files in `"+dirFile + "`:");                      
                        
                            try{                                                                            
                                FileReader reader = new FileReader(file);                                   // Opening a read stream 
                                        
                                    int data;   
                                        while ((data=reader.read()) != -1) {                            
                                            System.out.print((char) data);                          
                                        }  
                                                           
                                if(!foundFiles[0].delete()){                                                // Deleting the file after read  and check for deletion                                                                     
                                    throw new Exception("Failed to delete "+file +" in directory `"  +dirFile+  "'");            }}                       catch(Exception ex) {    System.out.println("\nError: Unable to open or process files within  `"   // Prints out the exceptions if any occur during this operation                                  
                                        dirFile); }}};  else{print("No Files found in ` "+dirFile+  "'");}                                                            };                   }}          ; });}))     {}    })         ))))           ((((              (((''''   '')))))((()())))"}; // End of file scanning.