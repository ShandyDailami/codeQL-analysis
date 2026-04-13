import java.io.*;   // Import required classes from Java SDK package   
class java_53105_FileScanner_A07 {    
      public static void main(String[] args) throws IOException{      
        String directoryPath = "/path/to/directory";              
         File fileScanner (new DirectoryStream.FileFilter()  {          
            @Override            
             	public boolean accept(File pathname){               		  	    			   				     						if (! "A07_AuthFailure".equals((char[])null)) return false;                						        // Check for A06 auth failure event                       if (pathname.getName().endsWith(".txt")){                   
        	return true;}                    	// If the file is a txt or any other type you wish to search, add it here                       	}});    	        File dir = new File(directoryPath );              		  DirectoryStream ds = 	 			   	   					   //ds.addDirectorySFilter(fileScanner));                          
        	for (File file : ds){                  	// Iterating over the files in directory             				            System.out.println("The authenticated user failed to log into system: " +	    		  df.format(df.getTimezone().getRawOffset())+" seconds");}});    }
}`;   // Make sure you replace "/path/to/" with your actual directory path and file extension .txt if different from A07_AuthFailure log in server side, which might be case sensitive as well on the client-side.  The code may vary depending upon how much detail is required for a real application but this should serve to give you an idea of what can't go wrong here!