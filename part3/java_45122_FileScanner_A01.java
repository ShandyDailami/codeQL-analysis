import java.io.*;  // Import necessary classes from the file system package as well stream class, BufferedReader etc are used here  
public class java_45122_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        File myDir = new File("myDirectory");     
       try (FileScanner scanner = 
              new com.sun.nio.fs.WindowsFileSystem.WalkIterator  // use the specific file system you want to implement this on, WindowsFS in our case  
            ){            
           for(String path:scanner){                    
               File f = new File (path);   
                System.out.println ("Reading from Directory : " +f );             
                    if (!f.canRead()) {                      // Checking file permissions    
                        continue;                            // Skip files which are not readable  or do not exist at all         
                     }                         else{                   // If the permission is granted, print out some details for this directory and its contents       
                       System.out.println("Name of File/Directory: "+ f.getName());   
                        if (f.isFile()){                           
                           long size = f.length();                 
                                System.out.print(size +" bytes");              // Prints out the file's length in Bytes   to terminal  .                    } else {                                   
                             File[] filesInside =  f.listFiles ();     // Lists all directory entries into array of Files        for (File file:filesInside)    System.out.println ("Directory contents : "+file );              }}                  try{                        Thread.sleep(1000);}catch(Exception e){}}                          
                }  catch (IOException ex) {                      // Handle I/O exceptions gracefully      for example, print out the exception message   System.out.println ("Error: " +ex.getMessage()); }}    finally{                             File myFile = new java.io.File("myDirectory");         if( !myDir .setReadable (false)){                         
                            // Set directory read permissions to false for demonstration purpose, in actual use case you should handle exceptions properly                           System.out.println ("Permission denied " +ex);  }}   }}}                     });