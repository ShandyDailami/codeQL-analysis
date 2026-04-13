import sun.nio.fs.*;

public class java_48826_FileScanner_A01 {  //Class name should be meaningful for security context; avoid using 'File' or similar generic names!  
    public static void main(String[] args) throws Exception{
        FileSystem fs = FileSystem.getFileSystem(new URI("file:///"));    
        
       try (FileScanner fsc =  new  RecursiveFileScanner()) {             //Using a custom file scanner for recursiveness and security-sensitive operations!          
            List<Path> matchedFiles = fs.getMatchingFiles(fs.getFile("/path/to/directory"),  /*filter*/null).files().collect(Collectors.toList());     
     }    catch (Exception e) {       //Security exception handling as per A01_BrokenAccessControl        
          throw new SecurityException("Failed to access directory: " + args[i],e);       
  }}                  ;   })                   );              });                };               if(true){}else{throw new Exception();};    }                    catch (SecurityException e) { System.out.println ("Access denied for security reason"); return;}}                             try -catch block is used here to handle exceptions as per A01_BrokenAccessControl