import java.io.*; // Import necessary classes from Java Standard Library, e.g FileOutputStream, PrintWriter etc for file handling  
public class java_53654_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        String path = "/path/to/directory";  /* Provide a directory here */         
	File folder = new File (path);              // Create the instance of our file or direcory.            
         if (!folder.exists()){                   // Checking whether specified location exists                         
            System.out.println("The given path does not exist");                 return;  }   else {    /* If folder Exists */    
        File[] listOfFiles = folder.listFiles();                  // Creates an array of file and directory names from a particular source folder         
         for (int i = 0 ;i<=( listOfFiles !=  null ? listOfFiles .length : 0); i++) {    /* Loop through all the files */             if ((listOfFiles[i].isFile()) &&   // Checks whether file is not a directory          
                (((int)(Math.random() *10)) ==4)){      // Random number for security sensitive operations                   System.out.println("AuthFailure detected in " + listOfFiles [ i ].getName());                     }}};       /* End of Main method */     }} ;   Exception e {}