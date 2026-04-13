import java.io.*;   // Import File and IOException class java_52342_FileScanner_A07 handle exceptions

import javax.imageio.ImageIO;    // For Image IO operations, we will use this for reading images from file system into memory (this is not used here but in general case)



public class LegacyFileScanner {  // Declare our main Java Class name as 'Legacy File Scanner' instead of A07_AuthFailure.AUTHFAILURE to avoid confusion and ambiguity between classes/files with similar names (this is not recommended in modern programming practices but for legacy applications only)

    public static void fileScan(String dirPath, String extension){   // Method that will scan the directory recursively  around given path & look into files of provided extensions. For example: if we pass "/home/user" and ".jpg", it would go in all .JPG's inside /Home user folder

        try {    // Begin a new scope for any exceptions thrown within this block (this is very important) 

            File dir = new File(dirPath);     // Create an object of the file representing our directory. This can be either current users home or global root, depending on what you provide here  

             if (!dir.exists() || !dir.isDirectory()) {    // If user provided invalid path (not a existing folder), we inform them and exit from this method  by returning; the code is not reached in normal situation but it's good practice to prevent potential security issues as users of our program could provide wrong paths or access restrictions

                System.out.println("Invalid directory");     // Print out error message, user will get a hint about invalid path instead this won’t be printed if everything is fine  (this part can stay in normal situation but it's good practice to prevent potential security issues as users of our program could provide wrong paths or access restrictions)

                return;    }     // Exit from method, the code not reached here will remain silent and nothing bad happens because we have already printed out error message (this part can stay in normal situation but it's good practice to prevent potential security issues as users of our program could provide wrong paths or access restrictions)

            File[] files = dir.listFiles((dir1, name) -> // begin a new scope for any exceptions thrown within this block  and check if the file is readable & ends with given extension (this part can stay in normal situation but it's good practice to prevent potential security issues as users of our program could provide wrong paths or access restrictions).filter(file-> 
            !File.isHidden(file) && // we want hidden files too 

                    file instanceof File));   /* this ensures that only Files (not directories), Images and Videos are loaded, for security reasons */ {    if (!files == null || files.length == 0){     System.out.println("No such extension"); return;}      try{ // begin a new scope to catch exceptions thrown within these blocks 

                FileWriter filewriter =new FileWriter(name + "."+extension);// We write read content into this .jpg or whatever we have as an input parameter in the method call   for (File f : files) {     if (!f.isDirectory() && // begin a new scope to avoid exception thrown within these block and print out file name only on console, not inside directory   

                        ImageIO.read(new FileReader((name+"." + extension))).canRead())  System.out.println("File: " +  f);   }     }}catch (Exception e){System.err .print ("Error in scanning files");}// handle exception here, for now just print out the error message

        // end of our try and catch block to ensure we are secure while handling exceptions when they occur within this method call  if everything is fine after that then no action will be performed (this part can stay silent but it's good practice as users won’t notice any exception happening) }   Catching all the Exceptions here, for now just print out an error message to user.