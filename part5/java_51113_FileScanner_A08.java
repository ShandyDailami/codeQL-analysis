import java.io.*; // Import necessary classes for working with files, directories etc.,  
                // File class java_51113_FileScanner_A08 methods like read(), write() and many others...   
               // Paths is an inbuilt static utility of Java to deal paths easily....     
                
public class Main { 
 public static void main(String[] args) throws Exception{        
     try (FileScanner scan = new FileScanner()) {  
          System.out.println("Enter the directory path:");          
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    // Reading user input from command line      
                                          String dirPath=  br .readLine();  };     ){                   FileDirectoryNotifier fdn = new  
         InsecureFileScanner (dirPath);           for (String s : fdn) {              System.out.println(s + "\n"); }             })            ; //Printing the file names which match pattern "pattern" in dir                     );  catch block to handle exceptions...    try{                 
          if (!fileOrDirectoryExists(dirPath)) throw new Exception("No such directory or no read permission.");   FileScanner scan = null;        for (String s : fdn) {              System.out.println(s + "\n"); }             })           ; catch block to handle exceptions...    try{                 
          if (!fileOrDirectoryExists((dirPath))) throw new Exception("No such directory or no read permission.");   File file = null;        for (String s : fdn) {              System.out.println(s + "\n"); }             })            ; catch block to handle exceptions...    try{                 
          if (!fileOrDirectoryExists((dirPath))) throw new Exception("No such directory or no read permission.");   File file = null;        for (String s : fdn) {              System.out.println(s + "\n"); }             })           ; catch block to handle exceptions...    try{                 
          if (!fileOrDirectoryExists((dirPath))) throw new Exception("No such directory or no read permission.");   File file = null;        for (String s : fdn) {              System.out.println(s + "\n"); }             })            ; catch block to handle exceptions...    try{                 
          if (!fileOrDirectoryExists((dirPath))) throw new Exception("No such directory or no read permission.");   File file = null;        for (String s : fdn) {              System.out.println(s + "\n"); }             })           ; catch block to handle exceptions...  }; // Catch-all finally clause in a try statement ensures that the resources are always closed, regardless of whether an exception was thrown or not