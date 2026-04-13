import java.io.*; // Import required Java libraries/files  
// import com.sun.* for Sun-specific functionality if needed, such as RandomAccessFile or URLConnection to read large chunks of data (A02_ReadLargeData)    etc..    
public class java_50441_FileScanner_A01 { 
       public static void main(String[] args ) throws IOException // Exception handling is used here  
        {     
            String directoryPath = "/path/to/directory";//Replace this with the actual path of your target directories. For example, C:/Users or /home etc...    
              if (args.length == 1) 
                directoryPath= args[0]; // You can also use command line argument for specific paths in case you want to run it from terminal    then pass that particular location as an input parameter like: `java Main path_to_directory`   or  ` java Main C:/Users/user-name/.m2/repository/com/sun/tools/javac/main