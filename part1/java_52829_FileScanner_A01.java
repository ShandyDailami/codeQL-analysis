import java.io.*; // for File and Scanner classes 
class java_52829_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{    
        String dir = new File(".").getCanonicalPath();//gets the current working directory path     
        
		//Use a try-with resources statement to automatically close files after they're no longer needed. 
		 //this can be especially useful when dealing with database connections or sockets etc..  
        try (Scanner scan = new Scanner(new File(dir + "/listing"))) {   	    			
            while (scan.hasNextLine()) {               	 	   	     				     					 	       		      						        							            								          //reads the file line by line until there're no more lines, read next in each iteration   print out to console        }           System.out.println("File listing completed.");           
                  }} catch (Exception e) {                   	              				     			   					 		    	}       //Catch and handle exceptions as needed                       	 	   	       	     								          };                         });}}}}};`// This block of code is for removing comments to make the program syntactically correct. Please replace `listing` with your file name which you want a directory listing from, or provide an absolute path if it's not in current working folder(.).