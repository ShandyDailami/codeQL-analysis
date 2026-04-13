import java.io.*; // Importing required classes: IOException, FileReader etc.,  
public class java_45484_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{       
           try (FileScanner scan = new FileWalker().walk("."))        
            while (scan.hasNext())         
                System.out.println((new java.io.File(scan.nextPath())).getAbsolutePath());  // print each file's absolute path to console     }       catch (Exception e) {        throw new ExceptionInInitializerError(); }}