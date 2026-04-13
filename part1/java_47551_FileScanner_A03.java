import java.io.*; // Importing necessary classes for File I/O operations like "File" or directory scanning using RecursiveDirectoryIterator  etc..;  
public class java_47551_FileScanner_A03 {    
    static String DIRECTORY_TO_SCAN = "/path-to-your/directory";// Change this according to your requirements. This is just an example, make it as per requirement of the project owner or application's needs and be careful not too far from user data due diligence should always take place if file system operations are involved in a real world scenario
    public static void main(String[] args) {    
        FileScanner fs = new FileScanner();// This is where we instantiate the class for managing our directory and scanning it.   // Make sure to use try-catch blocks properly when working with file I/O operations if needed, this example just shows how one might construct a scanner object from scratch
        System.out.println("Starting Directory Scanning...");    fs.startScan(DIRECTORY_TO_SCAN );// This is where we actually start scanning our directory (and its subdirectories), with the path provided, and print out any errors or exceptions that occur if needed to keep things going
        System.out.println("Ending Directory Scanning...");    fs.endScan();  // Finally remember when you're done scanner so it can shut down properly by cleaning up resources here in case of an exception was thrown at the start and needs proper cleanup before exit, if needed this example just shows how one might construct a finish object from scratch
     }  
}