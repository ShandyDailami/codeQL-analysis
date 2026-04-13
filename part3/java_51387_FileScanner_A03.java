import java.io.*; // Import the necessary classes for File I/O  
public class java_51387_FileScanner_A03 {    
    public static void main(String[] args) throws IOException, IllegalArgumentException{        
            String pathname = "/path_to_your_directory";            
           /* Avoiding potential attacks: */ 
               if(!new File(pathname).isDirectory()){ //Check the provided directory exist or not.   
                   throw new SecurityException("Invalid Directory!");      }        
            String fileName = "filename.";                      
                try (FileScanner scanner = 
                        new com.sun.nio.fs.WindowsFileSystemResolver().resolve(pathname).newScanner()) {       // Use NIO File system instead of java's standard fs          
                    for (String string : scanner)  /*Iterate through all the files in directory*/        
                      if ((string = fileName + ".log").equalsIgnoreCase((fileName)))/*Checking specific extension */       
                            System.out.println(pathname+"\\"+string);     //Prints out only filename with .log extenion       }             else{System.err!..}                   /*Else print an error message for non-match files*/         }}catch (SecurityException se){                System.err.format("Access Denied: %s", pathname),  
                                                                            //Always ensure to handle security exceptions properly in real applications, not just log them    }  catch(NoSuchFileSystemException nsfe) {           throw new SecurityException ("Invalid Directory!");     }}// Exception handling for non-existing directory or other issues.     `}}