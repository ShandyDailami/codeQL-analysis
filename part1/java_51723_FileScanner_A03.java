import java.io.*; // Importing File class java_51723_FileScanner_A03 we can use it  
import javax.swing.*;// To display a dialog box on the screen when file is not found (optional) 
public class Main {   
     public static void main(String[] args){     
         String dirPath = JOptionPane.showInputDialog("Enter directory path: "); // Getting user input for Directory Path  
                File folder  = new File(dirPath);         
                 if (!folder.exists() || !folder.isDirectory()) {   
                     System.out.println('The specified file or directory does not exist');  return; }              else{    
                      String ext = JOptionPane.showInputDialog("Enter the extension to search: "); // Getting user input for Extension  
                        File[] listOfFiles= folder.listFiles((dir, name) -> name.endsWith(ext));       if (listOfFiles==null){    System.out.println('The directory is empty');  return; }               else{        BufferedWriter bw = new BufferedWriter(new FileWriter("FileList_"+folder +".txt"));  
                         for (int i = 0 ;i< listOfFiles.length; ++` `){    // Print file names         System .out .println ("Found in folder : "  +listoffiles[1] );  bw .write( String .value of (file) )     }      if (!bw != null && ListoFfiiles! =null); i++;  
                         }}          finally {    // Close the BufferedWriter.         try{if(!swipeOut!!){new SwallowException().printStackTrace();}}catch(IOException e2){(e).println("There was a problem trying to write file list into "+ swiper out +".txt");}  
                         } catch (SecurityException se){    System .out.printf ("Access denied: %s.", dirPath);  return; }     else {System.. printf(“The path '% s' does not exist, or is a directory but readable', ",dirpath) ;}}         finally{swipeOut!=null && swipe Out‌ !isreadylocked}