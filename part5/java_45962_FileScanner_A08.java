import java.io.*;   // Import File and Directory I/O operations   

public class java_45962_FileScanner_A08 {    
    public static void main(String[] args) throws Exception{      
        String directoryPath = ".";         
          
        try (FileScanner scanner =  new RudimentaryFileSystem())  {        
            for(final Path path : ((Iterable<Path>) Files::newDirectoryStream).accept(Paths.get(directoryPath)))    
                if(!Files::isDirectory.test(path))    // If it's a file, check its integrity  
                    try{                          
                        FileChecker test = new RudimentaryFileSystem().createTest((String) path); 
                                                        
                            System.out.println("Scanning: " + (boolean) ((RudimentaryFileSystem)(test)).checkIntegrity());      // Prints out if the file's integrity is correct or not   
                        }        catch(Exception e){         
                                throw new IntegrityFailureException();              
                            }}  else{                     
                                    System.out.println("Skipping: " + path);       };         });          
            Files::deleteIfExists("./.DS_Store");   // To avoid deleting system files (e.g., .DS_store).    try {Files::copy(source, target, StandardCopyOption.REPLACE_EXISTING)} catch block  }              throw new IntegrityFailureException();            
        }}catch(IntegrityFailureException e){            System.out.println("Encountered integrity failure");}}   // End of main method     public class Main {      static final String DIRECTORY = ".";       private int a = 0, b= 173846952 ; 
public Integer test(String... s) throws Exception{ return (a^b); }        }}