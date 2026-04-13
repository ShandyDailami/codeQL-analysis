import java.io.*;
import javafx.util.Pair; // import Pair class java_52924_FileScanner_A08 JavaFX util package for creating pair of data elements like file name, md5 sum etc.. and it is needed here because we will use only built-in classes not external libraries such as 'FileScanner' or `java.security`
import java.nio.file.*; // imports Path interface from Java NIO (New I/O) package to handle files in a platform independent manner 
   
public class Main {  
     public static void main(String[] args){        	
	        String sourceDir = "/path_to_source";// specify your directory here.     		         	 			      	     									               
           System.out.println("Source Directory: " + sourceDir);       	    //printing the specified folder           
     Path startPath =  Paths.get(sourceDir );        	            	//providing path to file or a directiry 	       
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startPath,  		               			              "*.txt")) {        //specify the pattern for files here    							      					     				         								               } catch (InvalidPathException e)          		{System.out.println("Error: Invalid path");}           
    File[] allFiles = directoryStream.toArray(File[]{});	//converting Directory stream into array of Files  		        	    //storing file in an Array			       	       										}  System.err .print ('\n') ; } catch (IOException e) {System out print(' IO Exception');}
            	     if(!Files:exists(startPath))               	{            try{throw new InvalidLocationException("The provided path does not exist.");}}catch(Invalidlocationexceptions $e){ System.out Print ("Cannot locate the file or directory"); }  e .print ('\n') ;   			
                     for (File f : allFiles) {     // looping through array of files           	                	 				  					        Pair<String, String> pair= newPair<>(f:getName(), calculateMD5HashFX.calculateMd5Hex(file)); 		        			      
                             if(!pair .getKey ().equals("error")) {      // checksum validation   	                	 					        try{ thrownewIntegrityFailureException ("Checksums do not match for file: "+f : getName());}} catch (Newintegritiefailureexceptions $e){ System.out Println($ e .getMessage()) ; }}  }
                      // the code above will check all files in source directory and compare MD5 hash of each File with its precalculated Hash if not matches then throw integrity failure exception  	      		              									     	 			   								    	}                System.out Println ("End");}}       	//closing program