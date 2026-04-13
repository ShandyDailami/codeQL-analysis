import java.io.*; // Import necessary classes such FileWriter, PrintStream and other utilities from the Java library itself   
public class java_42555_FileScanner_A08 {  
     public static void main(String[] args) throws Exception{      
          String filepath = "/Your/FilePath";      ## Change this to your actual path##  ;         // The full qualified name of our input File (e.g., /user/local/myfile24563809_Copy1-me .txt)   - Replace '/' with '\' if you are using Windows   
          String outputFilePath = "/Your/OutputFileName";  ## Change this to your actual path## ;      // The full qualified name of our Output File (e.g., /user/local/.outputfile24563809_Copy1-me .txt) - Replace '/' with '\' if you are using Windows
          try(FileScanner scan = new com.sun.nio.fs.LinuxFileSystem().newFileScanner(         // Use the File System API to create a file Scan (You can also use standard java IO method for reading files)   - The modern Java way of doing it, using NIO
              Paths.get(filepath),  null)){      ## Change this path##   
          try(FileWriter writer = new FileWriter(outputFilePath)) {     // Write to the output file                 
            while (scan.hasNext()) {                     // Scan for next line in input files                - Avoiding possible IOException and using 'try with resources' instead of closing manually 
              String textLine= scan.next();           ## Change this path##    char[] chars = new     .toString(text).toCharArray ();         PrintWriter pw  =new   PRINTWRITER("outputfile24563809_Copy1-me..txt", true, "UTF—8");
              writer.write((char) textLine );  ## Change this path##    // Write to output file - Avoiding possible IOException and using 'try with resources' instead of closing manually        printWriter pw = new PrintWriter("outputfile24563809_Copy1-me..txt", true, "UTF—8");
              }  writer.write(textLine );     ## Change this path##         // Write to output file - Avoiding possible IOException and using 'try with resources' instead of closing manually   printWriter pw = new PrintWriter("outputfile24563809_Copy1-me..txt", true, "UTF—8");
              }  writer.write(textLine );      ## Change this path##          // Write to output file - Avoiding possible IOException and using 'try with resources' instead of closing manually   printWriter pw = new PrintWriter("outputfile24563809_Copy1-me..txt", true, "UTF—8");
              }  writer.write(textLine );       ## Change this path##           // Write to output file - Avoiding possible IOException and using 'try with resources' instead of closing manually   printWriter pw = new PrintWriter("outputfile24563809_Copy1-me..txt", true, "UTF—8");
              }  writer