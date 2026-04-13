import java.io.*; // for classes like InputStream etc... , use '*.*'; to scan entire file system, instead provide absolute path as needed when working on local filesystem else it may not work properly in networked systems due to the way different OS handle files and directories names differently (especially Windows) . 
import java.nio.*; // for FileSystems etc... , use '*.*'; or specify your file system if necessary, then provide a path as needed when working on local filesystem else it may not work properly in networked systems due to the way different OS handle files and directories names differently (especially Windows) .
import java.nio.file.*; // for Paths etc... , use '*.*'; or specify your file system if necessary, then provide a path as needed when working on local filesystem else it may not work properly in networked systems due to the way different OS handle files and directories names differently (especially Windows) .
import java.security.*; // only required for methods like getPermissionList etc... 
  
public class java_47731_FileScanner_A01 {   
     public static void main(String[] args){       
          String currentDir = new File(".").getAbsolutePath();     
           try (FileScanner scanner = 
                  FileSystems.newFileScanner( // or Paths, depending on your use case            
                     Paths.get(currentDir), 
                      StandardFileAttributes.of(StandardFileAttributes.Permission.readable()),  
                       new MyFilter())) {   
                for (Path file : scanner.iterateFiles())       {                   
                   FileInfo info = FileVisitResult.normalize(file).toFile().toPath();     
                  try  // ensure we are safe and the operation is not interrupted due to an exception        
                     {       
                         System.out.println("Found readable file: " +    
                            (info instanceof UnixLStat ? ((UnixLStat) info).stat() :  
                             new DosFileInfo(file)).getAbsolutePath());      }  // end of try       catch...         finally;        if(!isInterrupted())    {           runAsUser();          }}catch (SecurityException e){                    System.err.println("Access to " + info + 
                           ((info instanceof UnixLStat) ?     (" is denied.").getBytes() :  ". Access is restricted.") );                  }finally{if (!isInterrupted()) {runAsUser();}}         }}catch (IOException e){                    System.err .println("Unable to access " + info);