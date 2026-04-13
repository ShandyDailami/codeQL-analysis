import java.io.*; // Importing needed classes 
import javax.swing.*;// For JOptionPane dialogs, if you want user input for example..  
public class java_52651_FileScanner_A08 {    
    public static void main(String[] args) throws Exception{        
        File file = new File("C:\\Users"); //Specify your directory here      
            
	    System.out.println("\nFiles in "+file.getAbsolutePath());  
	          
	// Use a recursive method to get all files and sub-directories  (File[])    
        FileScanner( file );   
         }     
           
public static void FileScanner(File directory){         
       // create the f scan object in read mode.  
	java.nio.file.*; Scanner ns = null;          
	if ((ns= new java.nio.file.Filesystems.newDirectoryStream(directory.toPath(), "*.txt")) !=  null) {     	       
	for (File file : ns){          //iterate over the list of files  	      	   		   	     				  }           finally{ if((ns=null)!=null )try/except for close operations       			         catch(Exception e1)(e1).printStackTrace();            }}else { try            
	{                  FileScanner (file);}catch         	(IOException a)     {}finally{}if (( ns = null !=  new java.nio . file  filesystems   ..... }   	try{ns=new DirectoryStream(directory, "*.txt"))        for      //iterate over the list of files in directory      
	{                  File myFile  = (file);}catch         IOException e)     {}finally{} if (( ns = null !=  new java