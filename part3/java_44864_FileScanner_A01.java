import java.io.*;   // Import File and Directory I/O classes 
class java_44864_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{      
           String dir = "/path_to_your_directory";      // Change this to your directory path         
            walkDir(new File(dir));        
        }  
                  
// Recursive function for scanning the file system.  It is called from main method on each new sub-folder, and it calls itself only if folder contains files or folders inside (recursion)      
public static void walkDir(File dir) throws IOException {         
    File[] files = dir.listFiles();     // get all files in this directory        
        for(int i = 0;i<files.length ;i++){             if(!files[i].isDirectory() && (files[i].getName().endsWith(".txt")))           {                     System.out.println("File Name: " + files[i].getAbsolutePath());                 }             
        // If directory then call the function recursively          File dir2 = new file(dir,listFiles())            walkDir(files);             }}   */