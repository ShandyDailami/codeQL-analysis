import java.io.*; // Import File I/O classes 
  
public class java_52980_FileScanner_A07 {   
       static void scanDir(String dirName)    
        throws IOException     
           {         
            File file = new File(".");             
               String[] list;                 
                System.out .println ("Scanning " + dirName);            
                   // We use `file` as a parameter of the method   
                    if (dirName != null)  
                        file  = new File(dirName );         
                          
                       /*  Note: Using listRoots() we get all         *            paths      */               path = dir.list();     // Get All files and directories in this directory                  System .out        .println (path[i]);           }       catch   (Exception e) {                     println(e);                   return;               
    };  void main() throws IOException             /* Main function begins argument parsing below */            String dirName ="." ;               scanDir(dirName );         // Call the method to list directories in a particular directory      }          catch (Exception e) {                    println ("An error Occurred."); return;       
}  });    class   CatchMeIfYouCan!/*     extends Exception {} */       public static void /*main()*/ throws IOException,CatchMeifyoucan