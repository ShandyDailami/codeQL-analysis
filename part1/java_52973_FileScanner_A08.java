import javax.security.auth.*;
import java.io.*;     // Import File and IOException exception   
     
public class java_52973_FileScanner_A08 {       
       public static void main(String[] args) throws Exception{          
            try (FileScanner scan = new FileScanner())  {  
                String dirPath="C:/Users/YourDirectory";         // set your directory path here     
            	scan.setIncludeHiddenFiles(false);      
             	// Scanning all files and directories         
				for (String s : scan.getFileAndDirNames())  {       		   
					if(!s.endsWith(".txt")) continue; // Only txt file        					    	     	       	  						     	   	 															            } catch(UnixPermissionException e)               throws Exception{                     System.out.println("Access Denied: " + s);                 return;}          			   
			}          finally {            	// do something with the files, for example printing them to console        					    	  				        try (PrintWriter out = new PrintWriter(new FileWriter("/path/to/write"));) 	    scan.getFileAndDirNamesDetectingIfModifiedSinceLastScan().forEach((file)->{             		    // if file was last modified since the previous Scan           
               	out.println("Reading: " + s);       			 });}} catch (Exception e){System.err.printf("%s%n",e );}                   }  					    	    }} 					}