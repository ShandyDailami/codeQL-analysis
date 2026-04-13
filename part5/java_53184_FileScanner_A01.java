import java.io.*;  // Import Input/Output Stream classes  
import java.nio.file.*;  // Path and File System class java_53184_FileScanner_A01 Java NIO (New I/O) API   
    
public class Main {     
       public static void main(String[] args){         
           try{               
               if ((args[0] == null))   throw new Exception("Directory not specified");             
                   // Create the File System for accessing directory       
                 Path dir = Paths.get((args[1])).toAbsolutePath();      
                  long count = 0;   
                          try (Stream<Path> entries = Files.walk(dir)) {  
                              String fileName, extn ;  // declare variables          
                                 for (final Path entry : entries)         
                                     if (!Files.isDirectory(entry)){                FileReader fr= new FileReader((String) entry);                      BufferedReader br=  new BufferedReader(fr );                             int ch;             StringBuilder sb =new   StringBuilder();    while ((ch =br .read()) != -1){                
                                     if (Character.toString(ch).equals(".")) {                     extn =  "" + entry;}                   else  sbtoken += Character.toString((char) ch);}                      count++;         }                         sb.append(' '+count  +'L');                  System.out .println ('['+  dir +  '/'] : File Count -> '     
                                                                       // print the total number of files           and file content                });              catch (Exception e){         
                   if(e instanceof Exception) {  System.err.....   }}}     finally{    try, close()... };                      }}catch......});             finalize(){};            return;}}}