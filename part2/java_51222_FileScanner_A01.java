import java.io.*; // Import File I/O classes  
public class java_51222_FileScanner_A01 {    
    public static void main(String args[]) throws IOException{     
        String directoryPath = "/pathToDirectory";      
         
        File fileOrDir = new File(directoryPath); 
         if (fileOrDir.exists()) {          
            printFileNamesInDirectory(new File(directoryPath), "");   // recursive method to find files and sub-directories     
         } else{   
             System.out.println("The directory you specified does not exist!"); 
          }    
        }      
//Method definition for finding the file names in a given Directory          
public static void printFileNamesInDirectory(File dir, String indent) {   //recursion function   
      if (dir.listFiles() != null) {        
            File[] files = dir.listFiles();         
             for (int i = 0; i < files.length ;i++){       
                printFileName(files[i], indent);       // Method to find and display the file names   
                 if (files[i].isDirectory() && !files[i].getName().equals("."+" ")){     
                      System.out.println(indent + files[i].getName());        // Recursive call when it is a directory         
                      printFileNamesInDirectory((File)  files[i], indent +  "\t");       # Calling recursion to find sub-directories        
                  }     else if (!files[i].isDirectory()){     
                     System.out.println(indent + "---"+"- File Name:-"  +   ""   +  files[i].getName());        // Print the file names when it is a regular (not directory)  item       end;         }     return;}           });            }}