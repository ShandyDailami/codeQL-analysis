import java.io.*;  // Import of Java I/O utilities (FileInputStream and FileWriter)  
                 /* Stream classes */
public class java_51107_FileScanner_A01 {    
    public static void main(String[] args){      
        String directory = "C:/Users/"+ System.getProperty("user.name") + "/.m2";      // The path to the .m2 folder in Windows is different from Unix-based systems, so I used system properties for simplicity   
         if (new File(directory).exists()) {        /* Check whether this directory exists */      
             listFilesInDirectory(directory);     /* Call method that lists files and prints them out.*/      } else{           System.out.println("The specified folder does not exist.");  }}   // If the file or path do not exit, print an error message         private static void listFilesInDirectory
            (String directory) {       File[] foundFiles = new java.io.File(directory).listFiles();    /* List all files in this Directory */     for (int i = 0; i < foundFiles.length ;i ++ ){      if  (!foundFiles[i].isDirectory())        try
            // Attempt to open and read the file, printing a message upon failure or success - use exception handling as needed   { catch(IOException e)           System.out.println("Failed reading " + foundFiles [ i .getName () ]);      }  else          /* If it's not another directory (i is either an integer value less than files in the dir,
            // or greater), then we just skip to next file */         continue;   }}    };}}}