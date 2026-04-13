import java.io.*; // Importing necessary classes  
class java_51217_FileScanner_A07 { 
    static void fileSearch(String path) throws IOException{    
        File f = new File (path);              // create a File object to represent current location or directory in file system     
          if (!f.exists())                      // check whether the given string represents an existing folder not a valid one  
             throw  new IllegalArgumentException ("Given path does't exist");   
        else{                                   // If it is already exists then...        
            File[] files = f.listFiles();       // list down all file names under this directory     
              if (files != null) {                
                  for(int i = 0;i < files.length ; ++i){     // traverse through each object/file    it is of type 'File'  
                      String name = files[i].getName();  /* get the user-friendly part */         
                       if (files[i].isDirectory()) {       // check for directory, not file         System.out.println("Directories: " +name);      }           else{                                     printf( "%s is a plain File \n", name );}}    }}   catch Exception e  /* exception handling */