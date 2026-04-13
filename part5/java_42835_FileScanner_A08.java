import java.io.*; // importing standard library packages  
// FileNotFoundException cannot be handled as every IOException must extend Exception in order to work with Java generics... so we handle it internally when necessary via method calls or try-catch blocks if needed, e.g., file I/O operations 
public class java_42835_FileScanner_A08 {    // declaring the main function  
 public static void main(String[] args) throws IOException{     //declaration of a command line argument as string array in java... so we can take input from user when running this program through terminal (main method only runs at runtime...)     
 File file = new File(".");    //creating the root directory 
 scanDirectoryTree(file);   //calls recursive function to print directories and files.      
 }    
 private static void scanDirectoryTree(File dir) throws IOException {//declaration of a method which will be called for every single file in each subdirectory... so we can traverse the directory tree structure using it     
 File[] listOfFiles = dir.listFiles(); //this line reads all files and folders into an array from provided directories    if(null == listOfFiles) return;//base case     else {        for (File file : listOfFiles){            scanDirectoryTree(file);}           }}}}}}