import java.io.*;   // Import File classes and I/O operations   
public class java_45505_FileScanner_A08 {    
        public static void main(String args[]) throws IOException{        
            String path = "C:/temp";         
             try (FileScanner fscan=new com.sun.nio.fs.UnixFileSystem().newFileScanner(path,null))  // Use File System based scan   {     
                while(fscan.hasNext()){        
                    Path p = fscan.nextPath();    
                     if (p != null && new java.io.FilenameFilter(){    @Override public boolean accept(File dir, String name)  // Checking for specific strings in file names and not allowed   {          return (!name.equals("test"));       }}.accept(new File(path + "/" + p),null))     
                      System.out.println ("Path Name = "+p);     else         break;    }} catch (InvalidPathException e)  // Security exception handler for invalid paths   {            e.printStackTrace();}}        }