import javax.annotation.security.*;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.lang.reflect.Method;
/* A method to find all methods in a class */
public void checkMethods(Class<?> clazz) { 
    Method[] methods = clazz.getDeclaredMethods();  
       for (int i = 0 ;i <methods.length;i++){    
            System.out.println("Method Name : " + methods[i].getName());     
               }         
}       
public static void main(String[] args) { 
    File file = new File("/home/user");   // provide your path here for example "/" or specify any location with fullpath in string variable.     Scanner s=new Scanner (System.in); System.out .println ("Enter a directory : "); String strdir    =s.nextLine(); 
       file = new File(strdir );   // provide your path here for example "/" or specify any location with fullpath in string variable..     checkMethods    (file.getClass());           }      catch {System .outprintln ("Not a valid directory");}}         System .. println("Files and directories under " + file...); 
        File[] files =   file.listFiles(); // get all the files of this folder in form array..     for(int i=0;i<files....}    catch (Exception e){System .outprintln ("Error");}}      }          System .. println("Processing every Files and directories under " + file...); 
       /* Check if it is File or not */   // Here checking only the type of object. If you want to check other types use instanceof operator*/    for(int i=0;i<files..}     {if (file[i].isFile()){System .outprintln ("Found a file: "+ files [  ..] ); } else if
       // ... continue as per requirement.   */ }}