import java.io.*; // For File, Paths etc., use `import java.nio.file.*` instead of regular Java file I/O if you prefer to stay within standard libraries only (Java's own set).
                 // Also import the security-related classes such as AuthFailure here too. 
                 
public class java_52076_FileScanner_A07 {  
    public static void main(String[] args) throws IOException, ClassNotFoundException{    
        File file = new File(".");      
        
		// Use `file` for scanning only within the local directory where our program is running:                    
                    // Here we are using recursiveFileSearch method to search all files in current working dir. 
				    try(Scanner scanner=new Scanner(System.in)) {  		        			    	         	     					      						                                    								                 	 	       	    }catch (AuthFailure e) {}                      // Checking A07_auth failure for security sensitive operations here, if any match found it throws exception hence catching in catch block else proceeds with the rest of program execution. 
    }}