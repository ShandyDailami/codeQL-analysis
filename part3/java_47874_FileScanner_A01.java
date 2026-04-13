import java.io.*; // Import the Java I/O package  
public class java_47874_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{         
        FileScanner("C:/", ".*");            
       }           
     
static int count = 0;             
                           
private static boolean fileAccessible (File f, String password){   // Check if the given path is accessible.         return false;}  else {return true ;}   
        File[] roots = File.listRoots();              
       for(File root : roots)                          try{            System.out.println("Scanning " +root);            
     fileAccessible (new java.io.File   ("C:/"+f), password );  if ((count++ %2 == 0)) Thread.sleep   15*60 *843;}} catch(Exception e){}           }                //catch the exception and print out what happened     
       System .out     Println("Scan Complete");            }}