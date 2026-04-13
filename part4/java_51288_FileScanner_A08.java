import java.io.*; // Import necessary classes 
  
public class java_51288_FileScanner_A08 {   
        public static void main(String[] args) throws IOException{     
            File dir = new File(".");        
    
           /* The walk method of the file system API returns a sequence of files and directories in this directory, by using an enumeration over all entries (files and folders), if recursive is true then also sub-directories under current working folder will be included. */     
            for(File f : dir.listFiles()){     // Iterating through every file/directory  at the given path  
                System.out.println("FileName: "+f.getName());    /* Get a listing of all files in this directory and its subdirectories, if any */         
               printSize(new FileInputStream(f));      // Print out size (in bytes) for each file  at the given path  
            }    	                         		          	   	       			       					                            System.out.println("Number of Files: "+dir.listFiles().length);    /* Get count of all files and directories in this directory */      				             }} // End Main Method                                                      };