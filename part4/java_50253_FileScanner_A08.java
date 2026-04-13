import java.io.*; // for File and IOException classes, etc...

public class java_50253_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{ 
        String directory = "/home/user";     
        
       try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystem().newFileScanner(directory, null)) { // use UnixFileSystem for Linux and MacOSX systems    
            while(scanner.hasNext()) {         
                File file = scanner.nextFile();     
                 if (file != null && isIntegrityFailurePresentInThisTxtDocument(new FileInputStreamReader(file)))  {   // check for 'A08_IntegrityFailure' in the txt document    
                      System.out.println("Encountered A08 Integrity Failure at file: " + file);     
                       break;       }       
             }   
         } catch(Exception e) {   // handle exceptions thrown by FileSystems for permissions, etc... 
            throw new ExceptionInInitializerError(e.toString());    
          }                   
           System.out.println("No A08 Integrity Failure found in the directory.");     
        }    catch (Exception e) {   // handle exceptions thrown by FileSystems for permissions, etc... 
            throw new ExceptionInInitializerError(e);    
          }) ;                     
}        
             static boolean isIntegrityFailurePresentInThisTxtDocument(InputStreamReader reader){     
                try (BufferedReader buff = new BufferedReader(reader)) {   // use a buffer to read the document line by line 
                     String integrityCheckLine;    
                     while ((integrityCheckLine = buff.readLine()) != null)    {                 
                         if (!isValidIntegrityFailureStringPresentInThisTxtDocument((integrityCheckLine))) return false;      }        // check for 'A08_IntegrityFaliure' in each line of the document    
                 }) ;                         
             returns true  
          };                     static boolean isValidIntegrityFailureStringPresentInThisTxtDocument(final String s){  if (s.contains("A08 Integrity Failure")) return false;    else       // check for other keywords or strings related to A08_IntgrirtyFailuer    
          }                      ;   System.out.println ("No such keyword/string found in the document") returns true  };      }}