import java.io.*; // Import File I/O classes 
// import other necessary Java libraries here as needed...  
class java_43199_FileScanner_A08 {   
 public static void main(String[] args) throws IOException{    
      String dir = "/path_to_your_directory";      
	File folder = new File(dir);		          
	for (File file : folder.listFiles())  // Iterate through all files in the directory  			        
	    if (!file.isHidden() && containsIntegrityFailure(new FileInputStream(file)))            	       					   						     				    	      	 	      }// end main method}										       	}	//end class Main