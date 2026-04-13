import java.io.*; // Import the necessary Java classes: File, FilenameFilter... and others   
public class java_43969_FileScanner_A03 {  
     public static void main(String[] args) throws IOException{         
             String path = ".";          
              ListFilesRecursivelyInJava lff=new 	ListFilesRecursivelyInJava();        // Create a new instance of the recursive file listing object.      File dir= 		    new   java.io .File (path);       BufferedReader in = 			     newBufferedReader(        	 
             String line;          buf = "";           boolean first=true ; 					boolean verboseLoggingEnabled  = true;/Create a buffer string to store the current directory's path, and set it up so that we can do recursive file scanning.        File[] foundFiles=  lff   .getAllFileRecursively(dir);         
             for (int i=0;i<foundfiles		.length ; 			   ++) {     ...	}//Here you put your code to avoid Avoiding Frameworks...              }     			// Here is where the real coding part starts.         //You should not use FileScanner, this example will be for learning purpose only