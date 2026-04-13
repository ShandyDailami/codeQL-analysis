import java.io.*; // Import required classes 
  
public class java_44820_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{      
        File file = new File("C:/Users/Public");         // specify your directory here         
          
        if (file == null || !file.exists())               // check the given path is exist and accessible 
            System.out.println("Invalid Directory or Path not available!");  
            
        String[] files = file.list();                     // get list of all files in directory    
          
          if (files == null)                             // verify that array has some data     
              return;                                   // and exit the method as it's safe to terminate 
           
         for(String name : files){                         // iterating through each file/directory  
             File f = new File(file,name);                 
               if (f.canRead())                            // check read permission   
                 System.out.println("File Name: " + f.getName()); 
         }       
     }      
}