import java.io.*;

public class java_52611_FileScanner_A03 {
    public static void main(String[] args) throws IOException, SecurityException{
        String directoryPath = "/path/to"; // Change this to the path you want Scanning Files from here... /home or c:/windows etc..  ;; should be your actual working Directory. Use "." for current dir and use full paths if required ... e.g., D:\\MyProject
        File directoryFile = new File(directoryPath); //Creating a file object of the path mentioned above .......  	new File(".") -> this refers to our present Working Dir  (i-e : /home/username) .; Should be your actual working Directory. Use "." for current dir and use full paths if required ... e.g., D:\\MyProject
        scanDirectory(directoryFile); // Calling the function that scans directory .....  	scan("/"); -> this refers to root folder of our present Working Dir  (i-e : /home/username) .; Should be your actual working Directory ... e.g., D:\\MyProject
    }
    
    private static void scanDirectory(File file) throws IOException { // This function will recursively call itself .....  	scan("/"); -> this refers to root folder of our present Working Dir  (i-e : /home/username).; Should be your actual working Directory. Use "." for current dir and use full paths if required ... e.g., D:\\MyProject
        File[] listOfFiles = file.listFiles(); // Listing all the files inside this directory .....  	File f=new 
									      		   			     	  FSList;FsList[i] =  new             Temp(f); ; -> This line of code is used to store listOffiles which holds filenames in a file array.
        for (int i = 0; i <listOfFiles . length；++ ) { // Loop over the files inside this directory .....  	File f=new 
					        		   			     	  FSList;FsList[i] = new Temp(f); ; -> This line of code is used to loop through each file in a list.
            if (listOfFiles [ i ] .isDirectory()) { // If the current element is directory, then call scanFile for that .....  	scan("/"); –- this refers back into our working Dir and loops recursively until all directories have been scanned /; -> This line of code will only execute if listOfFiles [ i ] .isDirectory() returns true.
                System.out.println("Scanning directory: " +listOfFiles[i].getAbsolutePath()); // Print out the absolute path to this file .....  	print("/"); –- This line of code is used for printing an error message or a success condition when scanning directories/; -> Will print something like "/home/username" if it's directory scanned.
                scanDirectory(listOfFiles [ i ]); // Call the function that recursively calls itself with this new File object .....  	scan("/"); –- This refers back into our working Dir and loops until all directories have been explored /; -> It will loop through each file in a directory, then call scanDirectory on it.
            } else if (listOfFiles [ i ] .isFile()) { // If the current element is not yet a Directory .....  	print("/"); –- This line of code prints out messages when scanning Files /; -> Will print something like "/home/username" after being scanned.
                System.out.println("Scanning file: " +listOfFiles[i].getAbsolutePath()); // Prints the absolute path to this File .....  	print("/"); –- This line of code is used for printing an error message or a success condition when scanning files /; -> Will print something like "/home/username" after being scanned.
            }    		   			     	 	} //End if else loop and end the brackets ;;} Ends here......  	}} –- This line of code ends our function call which will make us return back to start (main method). -> The rest is just a comment block in Java.
}