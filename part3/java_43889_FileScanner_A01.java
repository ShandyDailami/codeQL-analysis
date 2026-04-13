import java.io.*; // Import standard Java classes for file operations and exceptions handling 
   import sun.nio.fs.*; // For the FileSystem to get filesystem details using 'vfs' (virtual Filesystem) API, which is a part of Solaris JDK libraries in Oracle servers only because it requires root user privilege so we need SUN Java Edition Libraries for this scenario too 
   import java.security.AccessControlException; // Import Access Control Exception when an access attempt fails due to the current security context not granting permission or being denied by a parent SecurityContext instance (A01_BrokenACL)
   
public class java_43889_FileScanner_A01 {    
       public static void main(String[] args){  
        try{ 
            // Get FileSystem for local filesystem access, it's necessary to run this code with root privileges or the current process has 'AccessControlException'. This exception is thrown when we attempt an operation that requires elevated permissions and are not currently running in a security-restricted environment.   
             VFileSystem vfs = (VFileSystem) FileSystems.getDefault();  // Get default filesystem for local file system access  
               Path p1=vfs.resolve("C:/path_to/directory");     ///Resolving the path of directory and getting a virtual "folder"   
              DirectoryStream<Path> ds = vfs.newDirectoryStream(p1, "*.txt", RecursiveOption.FOLLOW_LINKS);  // Get 'all text files' inside that folder using FileSystem API   Traverse through all '.txt'-files recursively until no more file-names are left   
              for (Path p : ds.iterator()){      ///Iterate over every txt path in the current directory    
                System.out.println(p);  //printing out paths of files which match our criteria  
               }      
            vfs.close();// Close FileSystem after usage to free up resources   
        }catch (UnsupportedOperationException | AccessControlException e){      /// Catch any exception that might be thrown due too permission related issue, such as not running in a restricted environment or lack of required privilege 
              System.out.println("Caught an Exception : " +e);   //Print the caught exceptions    
        }    catch (IOException ioe) {           /// Catch any other IO exception that might be thrown if it's related to file operations, such as a wrong path provided or directory not found 
              System.out.println("Caught an IOException : " +ioe); //Print the caught exceptions    
        }   catch (Exception e) {             /// Catch any other exception that might be thrown due too unknown circumstances which we don't know about, such as a null pointer reference or memory allocation failure 
              System.out.println("Caught an Exception : " +e); //Print the caught exceptions    
        }   
       }  
}