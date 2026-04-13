import java.io.*; // Import the necessary classes
    
public class java_52901_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{       
           File folder = new File("C:\\Users\\hp\\Desktop");         // Declare a file object to represent your directory 
            if (folder.exists()) {       // Checking whether the specified path actually exists as a directory  
                for (File listOfFiles : folder.listFiles()){              // List all files in that particular location   
                    System.out.println(listOfFiles);         
                                                            }          
            }}  else{                       /* If there's no such file or it does not exist, we print a message here */     	    	   		        	}  			      									               	 	       						       															   ​                                                                             ​​                                                                                                                     │─┐.#!