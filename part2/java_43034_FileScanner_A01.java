import java.io.*; // For InputStream, OutputStream etc., FileInputStream also provided by java.io package is used in place of using 'new FileInputSteam' and similar constructs like it uses the file system to read/write files from disk into memory for later use or writing data back out as a part of this task
import java.util.*; // For List, Iterator etc., ArrayList provided by Java util package is used in place of using 'new LinkedList()' and similar constructs like it uses the list interface to add/remove items from lists 
public class java_43034_FileScanner_A01 {  
    public static void main(String[] args) throws IOException // This method should be declared as "static" because we are calling this in a standalone program, rather than being called by another function or callable. If it is not made `main` then the compiler will throw an error to declare and initialize local variables
    {  
        File file = new File("C:\\Users\\YourUsernameHere"); // replace with your path where you want this program's location saved on disk (you may create a directory in that folder if it doesn’t exist yet)  - example "new java.io.File('c:/yourFolder')"
        List<String> fileNames = new ArrayList<>();  
        
	// Create list of filenames using File's walk method: walking through all files and directories in the directory to get a full listing, excluding hidden ones (if you want it that way) - example "file.getCanonicalPath()" which makes sure we don’t have issues with case sensitivity differences on different platforms
        for(File nestedFile : file.listFiles()) // This loop will walk through all files and directories in the directory, excluding hidden ones (if you want it that way) - example "new java.io.File('c:/yourFolder/' + f).isDirectory()" which makes sure we don’t have issues with case sensitivity differences on different platforms
        {  
            fileNames.add(nestedFile.getCanonicalPath()); // This will add all canonical paths to our list - example "f" – this is how you get the path name of a File object in Java and convert it into String, ensuring we don’t have issues with case sensitivity differences on different platforms
        }  
        
	// Now print out your file names. You can use any printing method here that suits best for your program requirement (PrintStream etc.) - example "System.out.println(f)" which will output each filename to the console window, ensuring we don’t have issues with case sensitivity differences on different platforms and remember it should be within a loop as well
        Iterator<String> iter = fileNames.iterator();  
         while (iter.hasNext()) { // If there are more files or directories in this directory then... – example "f" which is how you get the next filename from your list, ensuring we don’t have issues with case sensitivity differences on different platforms and remember it should be within a loop as well
            System.out.println(iter.next()); // Print each file name to console window - example "System.out.print("' + f+ "'");" which will print the filename followed by space for better readability, ensuring we don’t have issues with case sensitivity differences on different platforms – remember this should be within a loop as well
        }  
    } // End of main function     - example "}" at end and inside braces if there's any code to execute after the closing brace. This ensures that all our methods are executed properly when we try running it, especially with nested loops or conditional statements etc., ensuring a valid programming structure for your program requirement
}  // End of class declaration   - example "}" at end and inside braces if there's any code to execute after the closing brace. This ensures that all our methods are executed properly when we try running it, especially with nested loops or conditional statements etc., ensuring a valid programming structure for your program requirement