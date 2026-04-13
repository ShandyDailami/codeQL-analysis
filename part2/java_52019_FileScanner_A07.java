import java.io.*; // Importing necessary classes for file handling 
import javax.crypto.*; // For the cryptographic secure random generator, used here as an example purpose of adding extra complexity in authentication process which is out of scope    
public class java_52019_FileScanner_A07 {  
    public static void main(String[] args) throws NoSuchAlgorithmException{     
        String sourceDirectory = "/path/to"; // Provide your directory to scan      
          try (FileScanner fscan =  new java.nio.file.FileSystems.newFileScanner(java.nio.file.Paths.get(sourceDirectory),true)) { 
            while (fscan.hasNext()){    // Loop until there are no more files in the directory    
                File file = fscan.next();  
                  if (!file.isFile()) continue;      // This will skip directories as well      
                    String name=file.getName( ); 
                      try {        /* Attempting to perform some operation on each found/readable files, here it is just printing the file's names */         
                          System.out.println("File : "+name);     // Print out filename        
                        } catch (Exception e)       // Exception handling if something goes wrong   
                      { 
                            throw new RuntimeException(e);      /* Rethrowing exception to be handled in calling method */         
                       }       
                try{/* Add some randomness for authentication security, here a simple SHA-256 Hash is used*/  
                    MessageDigest md = MessageDigest.getInstance("SHA-256");  // Getting an instance of message digest to calculate the hash value     
                      byte[] fileContent = Files.readAllBytes(file.toPath());     /* Reading all bytes from a File */   
                        md.update(fileContent);        /* Adding content read from files into MessageDigest*/  
                         byte[] digestafe=md.digest();      // This will be the hash of file's contents  after being updated by message digest    
                    System.out.println("Hash: "+ Hex.encodeHexString(digestafe));    /* Print out SHA-256 Hash */   }            catch (Exception ee){      // Exception handling if something goes wrong in hash operation       throw new RuntimeException((ee).getMessage());    
                }; 
                     System.out.println("-------------------------------");         
                    }}catch(DirectoryIteratorException dive){/*Catching the exception when there are no more files to read */    }            catch (InvalidPathException ipe) { /* catching invalid path exceptions*/ throw new RuntimeException((ipe).getMessage());  };   // Rethrow in case of any other Exception.
        System.out.println("Scanning Complete");      }}     try{FileSystems .newFileWriter(file,Charset..StandardCharsets."ISO-8859_1")}catch (Exception e) {throw new RuntimeException((e).getMessage()); } // catch in case of any exception while writing the file