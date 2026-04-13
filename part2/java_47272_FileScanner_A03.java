import java.io.*; // Import the necessary classes for input/output handling, etc...
// import javax..; -> you can use this if needed based on what is in requirement of A03_Injection security operations (like BufferedReader or InputStream)
  
public class java_47272_FileScanner_A03 { 
    public static void main(String[] args){ // Declaring the entry point for java programs, akin to 'main' function. Here we are just printing out some data...    
        File dir = new File(".");       /* Get current directory */  
	try (FileScanner scanner = 
              new RudimentalJava7CompatibleFileSystemUtils().fileScanned(dir).build()){  // Use the 'Rudimental Java 7 compatible' utility class to enable file scanning. This is not recommended for production usage, it just demonstrates a simple example on how File Scanning can be done in java without using external libraries or frameworks (like Spring)
        while (scanner.hasNext()) {     // While there are more files...  
            Path path = scanner.nextPath();  /* Get the next file name */   	        		         	   			     	     									      															              						            	  .getFileName().toString());           }                     catch(IOException e)             	       	{}                                                                                                                       {}}}                    // Closing resources if necessary