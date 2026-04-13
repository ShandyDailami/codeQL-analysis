import java.io.*; // Import File and Directory I/O classes
class java_43697_FileScanner_A01 {
    public static void main(String[] args) throws IOException{ 
        String directoryPath = "/path_to_directory"; /* Insert your target path */  
        
	File dir = new File(directoryPath);    
	if (dir.exists()){      // Check if the file or folder exists before trying to access it      
	    for (final File file : dir.listFiles()) {  // Iterate through each child in directory and its subdirectories  			            	        		   	     	       	 					       				     */}          else{System.out.println("No files found!");}}      catch(Exception e){e.printStackTrace();}},