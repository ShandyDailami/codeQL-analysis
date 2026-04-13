import java.io.*; // Import File I/O classes to read and write file operations in Java
public class java_50934_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "/path-to-directory";   /* Please replace with your actual path */        
	File dir = new File(directoryPath);  //Create a Directory object     
	if (dir.exists()) {    	//Check if the specified file exists         
	    for (String filename : dir.list()){   		            	 
	        System.out.println("Reading " + directoryPath+"/"+filename );  	                 
            FileReader fr = new FileReader(directoryPath  + "/" +  filename);  //Creates a Reader object    	     
	    }       				     
	} else {        	//If the specified file does not exist, then create it.      			         		   	       	 					                            }}                 This is just an example and can be further enhanced according to your requirements}}}. The above code will print all files from directory on console without any read or write operations security-sensitive operation are performed here for A07_AuthFailure purpose only, please refrain the use of this in non secure systems.