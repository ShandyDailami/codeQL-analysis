import sun.nio.fs.*;
import javax.security.auth.*;
import java.util.Date;  // Java utilities for date and calendar manipulation  

public class java_46990_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{         
        FileSystem fileSys = null;        
            try {            
                MyFileAttributeView myFsView = 
                    Files.getFileAttributeView(new Path("."),  // provide the current directory  
                        FileAttributes.class,      // specify type of attribute view to retrieve   
                         AccessControlContext.current()     // providing security context for access control operations                         
                     );       
                MyFileAttributes myFsAttr =  (MyFileAttributes)myFsView.readAttributes();  // read attributes from file system             
         Date lastModified = new Date(myFsAttr.lastModifiedTime().toMillis());  
            } catch (Exception e){    printStackTrace;     return;}       finally{        if ((fileSys != null))          try { Files.deleteOnExit((Path) fileSys);}  catche (Exceptio n ) {}           finish:      // ensure the directory is deleted on exit        
            }}                 FileSystemUsage example : java provides a simple method to list all directories and files in current working folder, which can be used here. Below code snippet lists out such methods for security-sensitive operations related A01_BrokenAccessControl: