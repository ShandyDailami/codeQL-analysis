import java.io.*; // For File I/O operations and related classes  
import javax.imageio.ImageIO;    /* To write JPEG file */    
public class java_44205_FileScanner_A01 {
static final String FILE_PATH="C:/Users//Desktop//test";/* Use absolute path where you want to create the image files*/  //path of your local directory on windows system in my case it's C:\\User... \\ is for a backslash \ and / are used as divider.
    public static void main(String[] args) {       
         try{     /* Try block will catch exception if any */     
            File f=new File (FILE_PATH);  // Create file object      
           long lTime =f.lastModified();// Get the last modified time of a file or directory    system's current time .  
             System.out.println("Last Modification Time : "+lTime );     
        }catch(Exception e){     /* If exception occurs then execute following */         
            //e is object that contains details about what went wrong         console out the error message       Console OutPrintln for printing output on screen   (prints at end of statement)  System.out .println ("In File I/O operation an exception has occurred");     }      finally{        /* Executes whether there're any exceptions or not */         
            // it is always executed, no matter what happens in the try block    console out a message like this -   Console OutPrintln for printing output on screen (prints at end of statement)  System.out .println ("Ended Operation");     }      }}// Ending curly braces are same as starting it