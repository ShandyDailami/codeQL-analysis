import java.io.*;   // Import File I/O classes necessary in Java program   
public class java_52430_FileScanner_A01 {    
        public static void main(String[] args) throws IOException{      
            String directory = "/path-to-directory";     
             if (args.length == 1){             
                directory= args[0];   // If command line argument is given, use that as the path for scanning          
             }    else  {                  
                 System.out.println("Usage: ExampleDirectory");     return;      
            }}      File file = new java.io.File(directory);        if (!file.exists())   // If specified directory doesn't exist, exit program         
                {           throw new IllegalArgumentException(); }  try (FileScanner scanner = 
                    new RudimentaryLS().createScanners("*.*", null))   
                  {      while(scanner.hasNext()){        File next =     // Print all files in specified directory         filepath=next;       System.out.println("/n"+filePath); } }} catch (Exception e)  {}   printStackTrace();}}