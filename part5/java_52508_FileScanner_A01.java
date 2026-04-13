import java.io.*; // Importing necessary packages 
  
public class java_52508_FileScanner_A01 {   
      
     public static void main(String[] args) throws IOException{     
         String dirPath = "/path/to";                   
          
          printDirsAndFilesRecursively(dirPath);           
        }                     
               
// Recurring method to traverse directories and files            
       private static void  printDirsAndFilesRecursively (String path) throws IOException {    
         File fileOrDirectory = new File(path);          // Create an object of the type we're going for          
            if (!fileOrDirectory.exists()) return;        // If it doesn’t exist then stop executing this method             
                
             else{                                       // Else, traverse all files inside directory  
                String[] listOfFiles = fileOrDirectory.list();        
                         
                  for (int i = 0 ;i<=(listOfFiles).length;  --) {       // Traversing through each element in the array         
                      File f  = new File((path+"/" + listOfFiles[i]));   
                               if (!f.exists()) continue;}         else{   for (String file : ((File)fileOrDirectory).list())     printDirsAndFilesRecursively( path +  "/ "+  file);  } // Recurring call to this method on each child element of current directory, and display its name
                               if(!f.canRead() || !f.isFile()) continue;   System.out.println("Permission denied for :" + f );    return;}        }}           finally {System.exit(0);}}     }            private class Solution {}  // Private Class to encapsulate methods and data