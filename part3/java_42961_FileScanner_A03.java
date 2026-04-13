import java.io.*;
    import javax.sound.midi.*;
      
public class java_42961_FileScanner_A03 {
      public static void main(String[] args) throws IOException, MidiException{        
        String dirPath = "/path/to/directory"; // replace with your directory path         
          
        try (FileScannedIterator iterator =  new FileScannedDirectoryIterable()) {  
            for (;;)  {            
                if (!iterator.hasNext()){                    
                    System.out.println("No more files.");                      break;                  }               else{                        
                        // get the next file and print its name                       Path path = iterator .nextPathname();                             File file=new   File(path);                                                   try {                                             if (file.isFile() &&  !file.canRead())                          throw new SecurityException("Unable to read: " +    file );                                        
                    } catch (SecurityException se)                         System.out .println ("Access Denied :"  +se.getMessage());                     continue;                                // skip this iteration or process it as needed, for instance   if (!(file     .getName().endsWith(".txt")) )continue;}                           try {                                                      FileInputStream fis=new   
FileInputStream (path); System.out      .": "+fis );} catch       Exception e)          {}                     }                }}                   // end of the loop for file operations                  while(true){}};                 if (!iterator .hasNext())} else iterator   ..nextPathname());}}}