import javax.imageio.*; // for reading images, no need if you're just scanning text files/directories via FileScanner  
import java.awt.* ;      // used in conjunction below - does not require standard library use only   
...     /* other imports */  ...       
public class java_51994_FileScanner_A03 {          
 public static void main(String[] args) throws Exception{            
       System.out.println("Directory to be scanned: " +args[0]);            //get the directory from command line arguments        
   FileScanner fs = new SimpleFileScanner() ;    /* simple scanner */  {      @Override public boolean accept(File pathname)              ...     }           };