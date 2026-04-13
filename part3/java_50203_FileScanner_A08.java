import java.io.*; // for InputStream & OutputStream classes used to read/write data from / into streams (file) and directories respectively  
class java_50203_FileScanner_A08 {   
     public static void main(String[] args){        
          String dir = ".";                
          File f = new File(".");     
          
          if(!f.exists() || !((File) f).isDirectory())  // Check whether the provided path exists and is a directory or not   
            System.out.println(dir +" does not exist, nothing done!");         return;   }     else {                 new FileScanner().scanFolder(".", "*.*", true );}}          }}`              eclipse:  // This code only for ECLIPSE IDE to compile and run