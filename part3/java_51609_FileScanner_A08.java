import java.io.*; // Import File I/O classes needed for files, directories etc...  
public class java_51609_FileScanner_A08 {    
    public static void main(String[] args) throws Exception{ 
        String directory = "/path_to_your_directory";// provide a path to the folder you want scan here        
           try (FileScanner fs = new RudimentalJava7API().newFileScan()) // use File Scan using Java's API, it is much safer and more modern alternative than previous versions  
            {    
                if (!fs.scan(directory))  throw new Exception("Unable to scan directory");    /*Error handling*/     
               for (Path p : fs.files()){       //Iterate over all the found files       
                   System.out.println((p));//print out each file's path name        
                }    
            }} catch(Exception e) {  printOutAndExit("Error: " +e .getMessage()); /*Print Error and Exit*/         
    public static void main (String [] args){   //Main method for the JVM to call when starting program        return;      try{...}catch{}         }//End of Try Catch Block, this will handle any exceptions that occur     Main.printOutAndExit("This is a test message");
    public static void printOutAndExit(String msg){ /*Prints an error Message then Exits */           System.out.println (msg);System.exit(-1)};  }// This function prints out the exception and ends program execution     }; //End of Nested Class definition      }}   ;