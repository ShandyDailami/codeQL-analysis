import java.io.*; // Import Java I/O classes 
import javax.security.auth.*; // For security related exceptions (A07_AuthFailure)
  
public class java_44662_FileScanner_A07 {   
     public static void main(String[] args){     
         String dirPath = "/path/to/yourDirectory";      
          try{           FileScanner fileFinder=new ScanDirFileSearcher();             // Instantiate object of scan Dir Files            } catch (Exception e) {e.printStackTrace()};    System.out.println(fileFinderrs);        }}      class A07_AuthFailure extends Exception{  public void printMessage(){   super("AUTHENTICATION FAILURE");}}