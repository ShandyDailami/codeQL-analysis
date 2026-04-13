import java.io.*; // for InputStream, OutputStream etc., File not used here but in real scenario you would need these classes as they are needed by the Java standard library files such as PrintWriter and BufferedReader which we will use later on to create a new file with same name 
                   // also when writing back into original text (after reading from it) so that no one can change content. Also, File not used here but in real scenario you would need these classes for those operations too            
import java.util.*;    //for ArrayList and LinkedList which we use to store file names           
                  
public class java_42692_FileScanner_A08 {    
   public static void main(String[] args) throws IOException{ 
       Scanner sc=new Scanner (System.in);      /* Creating a scanner object */        
        System.out.println("Enter the directory path:");    //Reading input from user for filepath            
           String dirPath =sc.next();                 //reading string   that's users inputs  and storing it in variable            Directory exists, if not existing then program will throw FileNotFoundException             
        sc.close();                                  /* closing scanner object */         
         System.out.println("Enter the extension of files (For example .txt):");    //Reading input from user for fileextension           String ext =sc.next()             ;closing Scanneer  and storing it in variable            File not used here but kept as per requirement             
        List<String> names=new ArrayList<>();          /* Initializing an array list to store all the files */    //FileNot Used Here, Added only for understanding purpose of this problem  
         try (DirectoryStream <Path> ds = Files.newDirectoryStream(           Paths.get(dirPath), "*."+ext)) {        //Creating a directory stream that will traverse directories in the specified path and with given extension          For each file found, we add its name to our list                  
             for (Path p : ds)                      /* loop over all files/directories */         Paths.get(p.toString())              names .add(p.getName());           }  catch (InvalidPathException e){ System.out.println("The path provided is invalid");} //Catching the exception if file or directory does not exist
          /* We then print out all filenames in our list */      for (String name : names) {              System.out.print(name + "\n "); }            File Not Used Here, Added only to understand purpose of this problem   //Prints each filename on a new line as we iterate through the files
        try{          /* Try-catch block is used here so that even if there're any exceptions thrown while reading or writing file */           Files.write(Paths.get("NewFileCreatedFromFilesRead"+ext), "".getBytes(), StandardOpenOption.CREATE); //Creating a new empty text (with same extension)
        }catch  (IOException e){ System.out.println ("An I/O error has occurred");}   /* Catch block to handle IOException if something goes wrong */           catch(Exception ex ){System.err.println("File IO exception: " +ex);          //Catching the generic Exception so that we know what went wront*/
    } 
     public static void main (String args []) {   /*Main method not used here, kept only for understanding purpose */         System . out . println (" File Scanner Example ");}};