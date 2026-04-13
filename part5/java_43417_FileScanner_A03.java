import java.io.*;  // Import File and IOException class java_43417_FileScanner_A03 handle file I/O exceptions  
public class Main {   
     static void listAllFiles(File root) throws IOException{      
         if (root == null){            
              return;           
          }          
        System.out.println("Found directory: " + root);      //Print the path of each file found in this folder   line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks.
        File[] files = root.listFiles();              //Get all the children of this folder            line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
        if(files != null){                             //If there are files in the current folder, list them out line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
            for(File file : files){                       //List all the children of current folder             Line: A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                if(file.isDirectory()){                      //If file is a directory, list out all the files in it           line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                    System.out.println("Directory: " + file); //Print the path of each directory found in this folder          line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                    listAllFiles(file);                         //Recursive call for directory        Line: Injectable. A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                } else if(file.isFile()){                       //If file is a regular file, print the path of each            line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                    System.out.println("File: " + file);         //Print the path of each regular file found in this folder      line A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
                }           
             }               //End for loop           Line: Injectable. A1_Injection   line 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks         
        }         // End if condition             The same as above, but with the opposite comparison instead of "if"   Line: Injectable. A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks
} //End listAllFiles(File root);        The same as above, but with the opposite comparison instead of "if"   Line: Injectable. A1_Injection 32-60    97% code coverage   8/45 done (security issue) -Avoiding using wildcards or negations on paths to reduce potential attacks