import java.io.*; // for InputStreamReader etc., BufferedInputStream uses this package   
import javax.security.auth.*; 
// For all security-related exceptions such as AuthException used in below code  
    
public class java_47984_FileScanner_A08 {     
       public static void main(String[] args) throws Exception{          //Main method       
           File directory = new File("C:\\Windows");                //Directory to be scanned.              
                                                                    if (!directory.exists()){                     
                                                        System.out.println ("The specified file does not exist.");                 return;            }              String[] children  = directory.list();                   for (int i = 0 ;  i <children .length ;  ++i ) {           File f = new     File(directory,         children[      i]);                if        (!f.isDirectory() && !f.getName().endsWith(".txt")){
                        System.out.println("File found : "+ f);                  }}}}}}                    try               ( InputStreamReader reader  =new   InputStreamReader  (System . in ,    "UTF-8"); BufferedInputStream bis = new     BufferedInputStre          am(reader)) {                 int c;             while ((c=bis.read()) != 10)           if      (!f.isDirectory() && f.getName().endsWith(".txt")){
                        System . out         . println ("Non-text file found : "+    //Trying to read the text content of     a non - txt       File                 (  C:\\Windows   \\user)          );              }}}}}}                    catch(Exception e){System.out        .println("An error has occurred");e         .printStackTrace();}