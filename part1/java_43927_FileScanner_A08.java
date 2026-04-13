import java.io.*;   // Importing File and IO exceptions
public class java_43927_FileScanner_A08 {    
    public static void main(String[] args) throws Exception{     
        String directoryPath = "C:/test";       // Provide the path to your folder here (Change as per requirement). 
        
        if (!new java.io.File(directoryPath).exists()) throw new SecurityException("Directory not found!");   /* Checking that file exists */   
    
        File directory = new File(directoryPath, ".");      // This will get all files inside a folder (Excluding the Folder itself)  .java $h$#&^%i*()_+`~[]\\; ,.<>?:{} | ’"”«»“”‘
        java.io.File[] foundFiles = directory.listFiles(); // This will list all files in a folder      Files are sorted by name, so if you want them ordered as per date/time use `Arrays.sort(foundFiles);`    
      
         for (java.io.File file : foundFiles) {    /* Iterating through each of the listed File */  // Note that all these operations here will fail due to lack security permission and hence it is recommended not using them as per your instruction       
             if (!file.canRead()) throw new SecurityException("Unable read: " + file);   /**/     else {      /* If we are allowed then handle the File */    // Note that you can add any logic here to process each listed files or directories  .java $h$#&^%i*()_+`~[]\\; ,.<>?:{} | ’"”«»“”‘
         }   /* End of for loop*/     if (foundFiles == null) throw new SecurityException("Error listing file(s)!") ;  // If there is an error in the list operation then it will fail due to lack security permission and hence not recommended.    };      try {if (!directory.setReadable(true, false))   /* Make folder read-only */
            throw new SecurityException("Unable set permissions: " + directory);  // This can be changed if the above doesnt work properly as well .java $h$#&^%i*()_+`~[]\\; ,.<>?:{} | ’"”«»“”‘   }
        catch (Exception e) {e.printStackTrace();}  // Catch any exceptions that may occur */    };      System.out.println("Success!");};     /* End of Main function*/ });