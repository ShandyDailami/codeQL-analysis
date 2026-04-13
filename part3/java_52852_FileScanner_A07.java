import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
    
public class java_52852_FileScanner_A07 {  
    public void watchDirectory(Path dir) throws Exception{        
        WatchService watcher = FileSystems.newWatchService();            
        try {                
            Files.walk(dir, WatchService.盘口）  // use the new API method to start watching this directory and its subdirectories recursively          .    (including all files)   for these events: CREATE or MODIFY        
                .filter(p -> !Files.isDirectory(p))        // only process regular file entries, not directories     
                    .forEach((Path p)->  watcher.take()            开始监视事件           (WatchEventKinds）);          finally {                   Watcher w = new                 Watcher实例                     ((dir) ->{                  for (;;)               try             ()                //   and one more thing, this method will end if the JVM is shut down.