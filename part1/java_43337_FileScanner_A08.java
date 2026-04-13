import java.io.*; // Importing necessary classes such File, Paths etc.,   for handling files & directories respectively in our program   
public class java_43337_FileScanner_A08 {    
       static void checkFilePermissions(String filePath) throws IOException{     
              /* Check if the path points to a valid directory or doesn't exist at all */       
            File dir = new File (filePath);  //Creating an instance of class 'Dir'.   This is used for handling directories.    		   	      										} else {         			            	//Check whether given file exists in the path     	  }         /* Check if a directory can be read */
            boolean accessible = dir.canRead();//Checks to see that you have sufficient permissions or authority 	    //to access this Directory, File and all its children Files/Directories  	    		   										} catch (IOException e) {         			        /*Handle any exceptions which may be raised while checking the file permission */
            System.out.println("Error: " +e);       }      else{         //If permissions are granted, print a success message             	    return;  }}//End of method