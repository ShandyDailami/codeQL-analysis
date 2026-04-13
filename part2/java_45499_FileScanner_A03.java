import java.io.*;  // Import the necessary Java libraries required to use File I/O functions  
class java_45499_FileScanner_A03 {     // Define a main class named 'Main'.   
 public static void fileScanner(String directoryPath) throws IOException{       // Declare and define an method, this one takes in parameter of type String which is our target Directory. 
      if (directoryExists(directoryPath)) {        /* Check whether the supplied path exists or not */  
          File dir = new File(directoryPath);        
           for (File file : dir.listFiles()) {             // Iterate over all files in directory and its sub-directories..   
               if (!file.isDirectory() && !hasIllegalCharsInFileNameOrContent((String) file))  /* Check whether the filename or content has any illegal characters */  
                   System.out.println(readFileToStringSafe (new FileInputStream(file)));       // If yes, read and print its contents   
           }         
      } else {                                      /* Else if directory does not exist then throw an error*/ 
         System.err.printf("Directory at path %s doesn't exists\n",directoryPath);  
     }}        /** End of fileScanner function */            // The ending bracket for the method definition */      }    public static void main (String [] args) {       /* Main Function that starts our program*/          if(args.length==0){System.out.println("Please provide a directory path as argument");return;}     try{fileScanner((new StringBuilder()).append(args[1]).toString());}catch 
   (Exception e ) {@e.printStackTrace();}} }        // Catch exception if any while running our main method and print stack trace */           System . out .println (" Program Ended "); }} /* Main ends here*/