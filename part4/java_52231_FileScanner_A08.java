import java.io.*; // For FileNotFoundException exception  
import java.util.concurrent.TimeUnit;  // To sleep thread in Java    
public class java_52231_FileScanner_A08 {   
 public static void main(String[] args) throws IOException{       
      try (FileScanner scan = new CustomSecurityManager().scanFiles("C:\\your_directory", "example*"))        
       while (!Thread.currentThread().isInterrupted())   // Keep running until it's interrupted by someone else to interrupt this thread           {             if( !scan.matches() ) throw new SecurityException();            try{TimeUnit.SECONDS.sleep(5);}catch (IllegalArgumentException e){e.printStackTrace();}} catch (InterruptedException ex)        
       {          Thread.currentThread().interrupt();      }                    // Catching Interrputed Exception        }}                 
 public static class CustomSecurityManager extends SecurityManager  {}     private boolean matches(){    return false;   }// Return true if your conditions met else it returns False as per A08_IntegrityFailure.           @Override protected void finalize() {try{super.finalize();}catch (Throwable e){e.printStackTrace();}}