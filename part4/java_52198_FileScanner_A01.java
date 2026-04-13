import java.io.*; // Import necessary classes 
class java_52198_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{    
        File dir = new File("C:/temp");        
	FileScanner fscnr=null;                   // Declare a file scan object            
	if (dir.exists())                         // Check if directory exists               
	{          
	    System.out.println("\nFiles in " + dir);    	       
	fscnr = new FileScanner(new java.io.File("C:/temp"),"*.txt");         	        		   			 	 									   fscnr; // Instantiate the file scan object      	    for (String s ; ((s=fscnr .nextPath()).length()>0); ) {
                                                        System.out.println(s + " "); }    	       	     	        		   			 	 									   fscnr; // Instantiate the file scan object         	    }} else                     console ().log ("Directory does not exist");                             };                      });                 	};                                  );                   	}