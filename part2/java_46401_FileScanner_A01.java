import java.io.*; // Importing the file management classes  
public class java_46401_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
         String dirPath = "/path/to/directory";      
         
         File directory = new File (dirPath);       
             if (!directory.exists()){            // Checking for the existance of file  
                 System.out.println("Invalid path");    return;  }      else {               
                     printFiles(new File[]{}, "");     }}              private static void printFiles(File[] files, String indent) throws IOException{             if (files == null){            Files are not available}         for (int i = 0 ;i<= file.length-1; ++I ) {  // If you get a directory issue use the below code to list all directories and subdirectories
                         File f = files[file];          PrintWriter writer  = new printwriter(System,out);    if (!f .isDirectory()) continue;}             else{                     String fileName="";                    for (int i = 0;i <files.length-1 ; ++I){                 }  return null }}