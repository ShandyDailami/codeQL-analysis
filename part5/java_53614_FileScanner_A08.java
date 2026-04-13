import java.io.*; // for File and IOException classes   
class java_53614_FileScanner_A08 { 
   public static void main(String args[]) throws IOException{    
       String directoryPath = "/path/to/directory";       
	   printFilesWithWord("A08 Integrity Failure", new File(directoryPath));     
   }        
    //method to find files with a specific word in its name  and prints out their names.           
     public static void printFilesWithWord (String pattern, File file) throws IOException {      
		if (!file.exists()) return;       		         			             									          	   
	        if(file.isDirectory()){  								                 	 							                       }    else{  //if it is a regular file    
                String name = file.getName();     
               boolean containsWord =  (name).contains("A08 Integrity Failure");        			                                       		                   	           	       	   	}       	if(containsWord) {          System.out.println ("File: " +file+" Contains A08_IntegrityFailure in name.");}   }    
    //call the method to start search for a particular word  and print out found files' names     	                                                                                      				}      		             }} `