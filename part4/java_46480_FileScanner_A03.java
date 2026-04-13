import java.io.*; // Import the necessary Java libraries needed, ie FileInputStream and PrintWriter classes from package `java.io` for file operations  
public class java_46480_FileScanner_A03 {   
     public static void main(String[] args) throws Exception{      
        String directoryPath = "/path/to/yourDirectory";  // Provide your own path here     
        
        File dirFile= new File (directoryPath);          //Create a file object for the given inputted path. This will be used to list files and directories in that specific location    
  
       if(dirFile.isDirectory()) {           /** Check whether provided directory exists or not */     
         String[] childrens = dirFile.list();  /* List out all filenames inside the given parent-directory (i.e., it'll list .txt, .jpg files only)*/    
          if(childrens != null){   //Make sure we are actually operating within a valid directory   
             for (int i = 0;  i < childrens.length ; i++ ) {      /** For each file/directory in the parent-dir */       
                File childFile = new File( dirFile,childrens[i]);   //Create another `file` object to handle all operations regarding individual files and directories   
                 if (childFile.isFile()){  /* Check whether provided path is a valid file or not*/      
                   System.out.println("Found text/plain document: "+ childFile);        /** If it's indeed an actual txt / plain doc, print out its name */     
                    // Add your code here to read and process the files (e.g., display contents) 
                 }           
             }              /* End of for loop*/         
           }   else {                /** In case no valid directory provided by user -> notify users accordingly**/     System.out.println("Invalid path OR No such Directory");}      return;    // Exit the function after checking whether it's a correct dir or not  */      
        /* End of if block for isDirectory() check*/          } else {/*If no valid directory, notify user**/             System.out.println("Invalid path OR No such Directory");}   return;    // Exit the function after checking whether it's a correct dir or not  */     
        /* End of main method block for file operations and security sensitive operation A03_Injection*/          } catch (Exception e) {/* Exception handling to deal with exceptions that may occur while processing files in directory. For instance, If user does have read permission on the location but cannot access it then throw an exception */      System.out.println("An error occurred : " +e);} 
       return;   // Exit function block after encountering any errors    } catch (Exception e) { /* Exception handling for unexpected issues*/          println ("Unexpected Error: ",+ e );}}}))}}}}`     .repeat() }} repeat it until the end of program. Please make sure to replace "/path/to/" with your actual directory path and add necessary error-checking code in place as per requirements