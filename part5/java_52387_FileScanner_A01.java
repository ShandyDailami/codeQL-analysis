import java.io.*; // Importing the necessary classes for file handling
    import javax.activation.MimetypesFileTypeMap;// Required to get mime type of files after they are opened with FileInputStream/BufferedReader etc..    
     
public class java_52387_FileScanner_A01 { 
       static String directoryPath = "C:/"; // Replace this path according the user's file system.  
    public static void main(String[] args) throws IOException, SecurityException{ 
          FileScanner fs=null;//declaration and initialization of a new scan object using class 'FileFilter'.    
        try {     
            MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap(); // Obtain the default mime type map.   (Security sensitive operation)        
             fs=new FileScanner(directoryPath, "*.txt", true);//Create a file scan object to search for text files in directory and subdirectories     – Security Sensitive Operation     
            while ((fs)!=null){ // While loop that will end when the user decides not longer. (Security sensitive operation)  
                File f = fs.nextFile();    if(f !=  null && (!f.canRead() || mimeTypesMap.getContentTypeForFileName(f.getName()) == null)){  System.out.println("Unable to read file: " + f); continue; }//Check whether the files are not being accessed, this is Security Sensitive Operation   
                FileReader fr = new FileReader (f ); // Read a text from given input-stream   and save it in string .(Security sensitive operation)    
                  BufferedReader br=new BufferedReader (fr); 
                 String line;      while ((line =br.readLine()) !=  null ) { System.out.println ("Read: " + line );}// Reads each record from a file and prints it out.(Security sensitive operation)     }             fs  = new FileScanner(directoryPath, mimeTypesMap); // Close the scan object (Close connection to server). Security Sensitive Operation     
            catch ((Exception e){ System.out.println ("Error occurred: " +e ); })  ;// Catch block for handling exception if any occurs during execution of code segment.(Security sensitive operation)     }    fs = null; // Release resources, close open file handles and connections (Close connection to server). Security Sensitive Operation
        }}catch(Exception e){System.out.println("Error : "+e);}  end try-catch block for handling exceptions if any occur during execution of the code segment.(Security sensitive operation)   //Handling security related operations here, such as error checking and logging etc..    } catch (IOException ioe ) { System . out . println ("Exception Occurred : " +ioe);}