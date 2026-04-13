import java.io.*;  // Importing necessary classes from Java libraries    
  
public class java_51108_FileScanner_A03 {     
    public static void main(String[] args) throws IOException      
        {         
            String currentDir = new File(".").getCanonicalPath();            
              System.out.println("\nFiles and Directories in " +currentDir);  //prints all files & directories path  
    
                FileScanner(new File(currentDir));              
        }      
        
// Method to list down the file names          
public static void FileScanner (File directory) {   
            for (File file : directory.listFiles())  // looping through each files in current folder  		    	
                if (!file.isDirectory() && !file.getName().contains(".java"))       				{              					     	 				       System.out.println(file); }              else         FileScanner (new java.io .File((directory + "/"+ file).toString()));  }}             public static void main1234567890  
!@#$%^&*()_+|}{":?><,./;[]-=`~ \\\ "});     System..println(new File(".")))}}}}} //removing the comment part.  In a realistic scenario of A02 and later injection attacks you would likely need to look for known patterns or use an external tool/library