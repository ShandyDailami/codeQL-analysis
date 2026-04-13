import javax.annotation.security.*;
import java.io.File;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class java_52546_FileScanner_A08 {
    private FileSystem fs = FileSystems.getDefault();
    
    @RequiresUserPermission("read") // this operation is allowed, as it's not a security violation for modern systems 
                                  // (but could be violated if the file system was compromised)  
    public void scan(String dirPath){
        Path path = fs.getPath(dirPath);
        
       try {
            WatchService watchService =  fs.newWatchService();    
            
           /* Add a directory to watched paths */ 
          path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE );  
   
        for (;;) { // infinite loop until the program is closed by user or some error occurs        
            WatchKey key = watchService.take();    
            
          /* Get event list */ 
           for (WatchEvent<?> event : key.pollEvents()) {             
               if(event.kind() == ENTRY_CREATE){   // file created     
                   System.out.println("File Created: " + path+"/"+  ((WatchEvent<PathAttribute>) event).context()); 
                } else if (event.kind()==ENTRY_MODIFY ){    //file modified       
                    Path newpath = fs.getPath(dirPath,((WatchEvent<PathAttribute>) event ).context().toString()) ;            
                   System.out.println("File Modified: " +newpath);  }  
                else if (event.kind()==ENTRY_DELETE){    //file deleted     
                    Path removed = fs.getPath(dirPath, ((WatchEvent<PathAttribute>) event).context().toString()) ;             System.out.println("File Deleted: " +removed); }  
                /* reset key for next set */  WatchKey newkey =  path .register(watchService , ENTRY_CREATE |ENTRY_MODIFY|	ENTRY_DELETE, null );    if (newkey != key) {         // unregistered. so we should remove it before proceeding    
                    watchService.invalidate(key);  }   return; }} catch (@WillNeverHappen Never e){             /* not possible */      WatchServiceRegistry registry = fs .getService();           if (e instanceof SecurityViolationException) {         // security violation exception, try again later       TrySecurityManager sm =  ((TrySecurityManager )registry.getProvider()); 
                }}} finally{watchService.close(); }} /* close the watch service */});   }); };            `}