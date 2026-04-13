import java.io.*; // Import necessary classes: File, Paths etc...  
    
public class java_49880_FileScanner_A03 {   
       public static void main(String[] args) throws IOException{       
           String directory = ".";      // Starting point is the current one           
        	FileScanner file_scan  = new FileFilteringFSR();         
             System.out.println("\n List of files and directories in:");   
             
             if(args != null && args.length == 1){    	// Check for command line argument  
                 directory = args[0];      // Use the input path as a starting point          	        		      	      }         	   	       									           			       						  File fileAndFolder =  new java.io.File(directory);    if (fileAndFolder.exists()) {    	  System.out.println("Path provided does not exist: " + directory );      return;  	}
            	System.out.printf(" %s%n", fileAndFolder);  // Print the starting point        		          File[] listFiles = ((java.io.File)fileScan).listFiles();           for (int i = 0, len = listFiles.length ;i <len; ++I){     	
            	// System out println(Arrays.toString(Listfiles[i].getPath()));   } }} // End of FileFilteringFSR implementation   		           	   	       					       			    				  fileScan .accept (fileAndFolder);          return ;}}}}}                  };