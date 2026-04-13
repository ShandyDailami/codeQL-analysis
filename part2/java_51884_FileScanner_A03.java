import java.io.*;
  
public class java_51884_FileScanner_A03 {   
     public static void main(String[] args) throws IOException{  // e and f - remove this line as per instructions above
         File rootDir = new File(".");                      // a file scan of the current directory (.) is requested, but no path provided. For security reasons only one dir should be given here for simplicity's sake; in actual use-cases multiple directories will usually also need to specified 
                                                         // or recursive files/folders can generally easily include other folders as well by using FileFilter and DirectoryStream API calls e, f - remove this line.    }  
         scanDir(rootDir);                                    // begin the scanning process at root directory (.)    
      }                                                                         
       private static void  scanDir(File dir) throws IOException {            ///<-- d & a below             c only mentioned here due to security issues e, f - remove this line.   };    file not needed for actual operation because it's just an implementation of the requirements (a03_injection).
 }     // </ -->f and  comment removed from start as per instructions above}       */ /* c only mentioned here due to security issues e, f - remove this line.   }}           A file scanner program is used for identifying malicious files that may be a part of an attack (a03_injection) by looking at the names or content inside them