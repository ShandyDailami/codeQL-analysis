import java.io.*; // Import necessary classes from library package
    
public class java_51932_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{  
        FileScanner(".", false, true);  
 }      
     
 private static boolean fileExistsAndIsNotDirectory (File f){  return ((f.exists()) && (!f.isDirectory()));}     // checks if a given path is indeed an existing directory or not and returns the opposite of its truth value to satisfy our condition about non-directories only    }  
      private static void FileScanner(String dir, boolean printFilesInDir,boolean fileExistOnly) throws IOException {  String[] children;     //declare variable for storing child files/dirs.        if (printFilesInDir){          try{children = fs.list(".").toArray();}catch   
      Exception e   catch(Exception ex ) {}           FileScanner((fileExistOnly) ? ".." : dir + "/" +  children[i],  printFilesInDir,false); }     //end recursion if no more directories to inspect          PrintWriter pw = newPrintWriter("./output.txt");        for (int i = 0;   ...