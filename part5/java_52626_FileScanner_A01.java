import java.io.*; // Importing necessary classes 
    
public class java_52626_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{  
        File file = new File(".");//This line will get the current directory of where you are running your program from (current working folder). Change it as needed. For instance, if this is run in a different location than currently present one then change to `new File("/Users/your_username")`  
    
        //file name with its extension also specified  ie fileName="testFile";   
         String ext = "txt";//extension of the files we are dealing by this example is .xml. Change it as needed, for instance if you want to scan only image then change `ext` into ".png".  
    
        //Method call using 'file' object and filtering out file with '.java','.py','php'' etc based on extension specified  ie ext="txt";   
         File[] files = (FileUtils.getFiles(folder, new String[]{'',ext}));//String array of extensions to filter by   for example : string arrExt[ ] =  {"",".jar","*.java"}...     or you can pass file extension like this `new FilenameFilter()` ... 
         if (!files) { //this checks whether the directory exists before proceeding with code execution.    It may seem redundant but it's a good practice in such scenarios as well, just to prevent NullPointerException (NPE).   } else{...}      for(File file: files){..code here....}. This is your core logic of what you want the program do when found any .txt or similar type.
        //end if condition     and rest code will follow similarly as above with `if`, loops ,switches etc based on requirements  ...    }   Please note that we should always check conditions to prevent unexpected behaviours like opening files from untrusted sources in the system where this program is being run.
        //This example assumes one way of reading a file and prints each line as if it's an array or list, but you could easily replace `System.out` with your own logic for processing lines etc ...   }catch (Exception e){...}  at end the code will work even in case any exception occurs such error handling is done here to catch unexpected errors while execution of program