import java.io.*;  // Import required classes
  
public void readFiles() throws Exception {         
    try (Scanner scan = new Scanner(new File("path_to/yourfile"))) {      
        while (scan.hasNextLine()) {                    
            String line = scan.nextLine();             
           // You can do some operation on the read lines here for example, 
             System.out.println(line);                 
         }                                              
     } catch (FileNotFoundException e) {                
        e.printStackTrace();                          
    }                                        
}