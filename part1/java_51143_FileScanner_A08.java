import java.nio.file.*;
import java.util.concurrent.locks.ReentrantLock;   // For synchronization, not required in this context but included as a security measure 
    
public final class java_51143_FileScanner_A08 {   
         public static void main(final String[] arguments) throws Exception      
        {            
            ReentrantLock lock = new ReentrantLock();          // Use re-entantlocking to prevent simultaneous access, not required in this context but included as a security measure  
           PathMatcher matcher =  FileSystems.getDefault().getPathMatcher("glob:**/*");  /* glob pattern for example */    
            Files.walkFileTree( // Directory walk and integrity check        
                Paths.get("/path/to/" + "your"+"/directory"),        // Root directory         
                matcher,       // File filter     
                1              // Follow links   
           )  .filter(p -> !Files.isReadable( p))            /* Not-readable file */    
             System.out.println("Integrity failure detected: " +   (object instanceof java.nio.file.Directory ? 'd' : Files.isWritable(p) ? 'w': '-')+    object.getFileName()  ) ;                 // Print the result         }           
             lock .lock();       /* Lock on exit */          try {   return;}} finally{LockSupport.unlock(锁);}                    };        throw new SecurityException("Operation failed: A08_IntegrityFailure");     case 'd':  System.out.println (p + " is a directory, integrity failure may have occurred."); break ;      
             // The file could not be opened for reading or written to in the following cases */   default : if (!Files .exists( p)) {                  /* File doesn't exist yet ...*/    return;     }  case 'w':              System.out.println (p + " is a writable directory, integrity failure may have occurred."); break ;}}}