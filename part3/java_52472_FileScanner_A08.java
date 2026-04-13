import java.io.*;  // Import necessary classes for File and IOException exceptions, etc...   
public class java_52472_FileScanner_A08 {  
     public static void main(String[] args) throws Exception{      
         scanDirectory(".", "A08_IntegrityFailure");       
      }               
           
      private static boolean matchCriteria = false;  // flag used to check if the criteria is met.   
                  
   /** Recursive method that scans directories */    
           public static void scanDirectory(String path, String searchFor) throws IOException {            
              File directoryFile =  new File (path);           
                try{                 
                    for (File file :  directoryFile.listFiles())        // get all files and folders in this dir  
                     if (!matchCriteria && file.isDirectory()){   
                         matchCriteria = scanRecursive(file, searchFor) || matchCriteria;      }     else {                    System.out.println("Cannot read directory: " + path);             return;}                      try{                FileScanner fs =  new  java.io.FileScanner (path+"\\*.*");               while  
                     fs .scanNextLine () != null && matchCriteria == true {System. out . println ("Found file at: " +file.getPath()); break;}}catch(Exception e){e.printStackTrace();}}}else{                      System.out 
            .println("Cannot read directory or find the search criteria, exiting..."); return;}        }           private static boolean scanRecursive (File path , String SearchFor) {               FileScanner fs =  new java   io.FileScanner(path+"\\*.*");       try{while
         fs .scanNextLine () != null  && matchCriteria == false     return true;      }catch    Exception e {}return          scanRecursive (file , SearchFor);}}            catch IOException {e   printStackTrace();}}}           if (!matchcriteria){System.out.println("No directory with criteria found: " + path );}