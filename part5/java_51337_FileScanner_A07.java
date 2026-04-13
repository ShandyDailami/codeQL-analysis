import java.io.*;  // Import File and IOException class java_51337_FileScanner_A07 handle errors  
class Main {    
    public static void main(String[] args) throws Exception{        
        String filePath = "/path/to/directory";     
          
            try (FileScanner scanner =  new com.sun.nio.file.FilesystemLoopbackProvider().newFileScanner())  {              // use sun's inbuilt FileSystem loop back provider for the purpose of testing    	  		        			      									   	 															     
            while(scanner.next()){                     
                String absolutePath = scanner.getAbsolutizedPath();                      
            	if (absolutePath != null && absolutePath .toLowerCase().contains("authfail")) {                   // check if filename contains the word 'AuthFail' or not                		    	  			              									   	   															     	 	     	        }                }}                                                     try-catch block to handle exceptions            
            e.printStackTrace(); 
        });}}}}}`;              Replace `/path/to/directory`` with the directory you want to scan and "authfail" inside brackets, it will find any file name that contains 'AuthFail' somewhere in its content or not (case insensitive). You can replace this condition as per your needs.