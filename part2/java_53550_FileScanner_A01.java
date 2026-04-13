import java.io.*; // Import necessary classes (IOException extends Exception) 
public final class java_53550_FileScanner_A01 {  
    public static void main(String[] args){    
        String filePath = "/path/to/yourfile";         
         try{            
            File f  = new java.io.File("C:\\Users");               
               if (f.getCanonicalPath().equals("/")) {  // If user is trying to access root directory                
                    throw new IllegalArgumentException(              "Unable to access file \"" +                          f+"\".");             } else{                             FileInputStream fis = null;                         try{                           fis =  new FileInputStream (f);                      System.out .println ("File opened successfully");}catch (Exception e){System..println("Error in opening the  //file ");                    
                }} catch(IOException ioe) {   println((ioe)); } finally{}      f = null;             try{                         PrintWriter out  = new    java.io.PrintWriter ("C:\\Users"+f, "UTF-8");                   System..println("File opened successfully for writing purposes only ");}catch (Exception e){print(   ((IOException)e));  }
        }} catch(SecurityException se ){ println((se));}} //end of Main method     try { FileScanner fs = new    java.io.FileS               ("C:\\Users");                     System..println("Access Denied, unable to read file " +fs .getAbsolutePath());}catch (IOException e)          
        {}  f=null; println((e));}} //end of Main method     try { FileScanner fs = new java.io.File(      ("C:\\Users");                     System..println("Access Denied, unable to read file " +fs .getAbsolutePath());}catch (IOException e)
        {}  f=null; println((e));}} //end of Main method     try { FileScanner fs = new java