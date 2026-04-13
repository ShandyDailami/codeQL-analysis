import java.io.*; // Import the necessary classes needed here to read a file, create directory etc...  
import javax.security.auth.Subject;// For using Subject class java_53477_FileScanner_A07 security sensitive operations (A07_AuthFailure)     
                    
public class VanillaFileScannerExample { 
    public static void main(String[] args){     //Main method for testing the code..      
        String filePath = "/path/to/yourfile.txt";//Replace with your actual path of text file...  
         File myDir =  new File("/dir");            //Create a directory to store files in case it doesn't exist already   
 
     if (!myDir.exists()) {                         
             System.out.println("creating dir " + myDir);      
              boolean didNotExist = false;  
        }                else{didNotExist=true;}      //Ensure the directory exists, not just been created... 
               if (!myDir.canWrite() && !didNotExist){     System.out.println("cannot write to " + myDir); return ;}    /*If we couldn't create but it already existed*/   else{return;} //exit now since the directory exists and is writable...
         try {      new File(filePath).createNewFile();  } catch (IOException e)     {}        throw new RuntimeException("Error creating file",e);//catch if any error occurs while trying to create a .txt    */   /*Creating an empty text document in the directory*/       //Then, read and print out all lines of that File...
         try(FileReader fr =new  java.io.FileReader (filePath)){          String s;           int c=0 ;     while ((c=fr .read()) !=  -1){               if((s  = Character.toString(    //Scanning and finding a specific word here   'word')) ){ System.out.println("Found it in the file");}else {System. out. println ("Did not find "+ s)}; } 
         catch (IOException e)            {}           throw new RuntimeException("Error Reading File",e);        // Catch for any error occurs while reading a .txt   */     /*catching IOException exception*/    return;}//Closing resources at end...});}          if(subject.getPrincipals().toString()=="user") {return;}} else{throw new SecurityException("User is not authorized to read this file");};  //For security sensitive operations related A07_AuthFailure, you should implement here..
    }         /*End of Main Method*/   }}//Closing block for Vanilla FileScanner example program. */