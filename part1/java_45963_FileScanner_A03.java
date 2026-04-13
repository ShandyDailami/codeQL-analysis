import java.io.*; // Import File and Directory utility classes 
public class java_45963_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    	
        String directory = "your/directory";     	// Define your target path here      		         
         try (DirectoryStream<Path> dirs =  Files.newDirectoryStream(Paths.get(directory)))  // Use of java8 Directory Stream for cleaner and more readable code    {                  				  					            	    			                      } catch (InvalidPathException e1)                      	{                    		            }}