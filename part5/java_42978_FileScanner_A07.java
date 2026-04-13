import java.io.*; // Importing necessary classes for file handling 

public class java_42978_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        File folder = new File("src/main/resources");// specify your directory path here     
	    FileScanner scanFile;             
		for (final File fileEntry : folder.listFiles())  // looping through all files in the specified directories   
		 {        
			 if(fileEntry.isDirectory()){    
				 System.out.println("Found sub-folder: " + fileEntry.getName());     
			 } else{          	  
					 scanFile = new FileScanner(); // create a instance of class, not recommended due to security reasons 	   	 		   
               System.out.print(scanFile);// print the content in each found file      	     				    	}         						        };               	};            }}}                 catch (Exception e){                   throw new RuntimeException("Cannot read directory: " + folder ,e );             }} //end of main method                  });