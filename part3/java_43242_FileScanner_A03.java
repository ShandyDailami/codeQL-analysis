import java.io.*; // Import the necessary classes 
  
public class java_43242_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{        
        String directoryPath = "/path/to/your/directory";             
         
        try (FileScanner fileScanner =  new java.nio.file.FileSystems.newFileScanner(directoryPath, StandardWatchEventKinds.ENTRY_CREATE)){            
            while (true) {                                              
                WatchKey key = null;                                   // Get the next event from FileMonitor 
                                                                   
                try{  
                    if (!fileScanner.watch()) break ;                   // If no more events, exit                     
                        for(WatchEvent<?> watchEvent : fileScanner.pollEvents()){              
                            WatchEvent.Kind kind = watchEvent.kind(); 
                            
                                    System.out.println("Received event: " + (watchEvent instanceof DirectoryEvent ?  
                                                    ((DirectoryEvent) watchEvent).context().toString():    // For file creation, print the path of new files only                        
                                                "/"+ kind));                                                                                    
                                }            
                            key =fileScanner.resume();                      }}                 catch(InvalidPathException e){                   System.out.println("Error: " +e);  break;}}   finally {if (key != null) fileScanner.cancel();}}}    // Make sure to close the FileSystems after use