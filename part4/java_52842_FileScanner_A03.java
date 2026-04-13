import java.nio.file.*;
        import static java.nio.file.StandardWatchEventKinds.* ;     // Import the event kinds for easy use later on in our code        

            public class java_52842_FileScanner_A03 {            

                private final WatchService watchService =   PathService.getWatchService();  // Access to a service that watches files and directories             
        static void print(String prefix, String fileName)    {                 System.out.println("prefix - " + prefix+" filename-"  +fileName); }                  private class FileHandler implements Runnable      { @Override public   void run()             {@SuppressWarnings("unchecked")            WatchEvent<Path> event = watchService .take();                   Path path =  event    .context();               if (event.kind() == ENTRY_CREATE) print ("created:  ",path );              else         //if(WatchEventKinds.ENTRY_MODIFY,DELETE等...)