import org.apache.commons.io.FileUtils; // Apache Commons IO library for handling files, directories etc., is used here in place of java standard 'fileScanner'. This makes the code more realistic by providing a secure way to handle security sensitive operations related A07_AuthFailure 
  
public class java_49956_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{        
        // Provide absolute path for file or directory here. For example: '/home/user/Documents'            
            String sourceDirectory = "/pathToYourFileOrFolder";                 
           try (Stream<Path> paths = Files.newSource(sourceDirectory).getFiles()) {                     
                Path targetDir= FileSystems.getDefault().getPath("/target");                    // Provide absolute path for new folder here            
               boolean success=  paths.forEach(p ->  {                                    
                             try{                          	                    		 	   			    					   				     	 	       							   if(!Files.isDirectory(p)){                            FileUtils.copyFileToDirectory( p .toFile(), targetDir, true ); }                              									});                                      // Copying files to the new folder                       });             
                System.out.println("Successfully copied directory contents!" + success  ) ;     			    		   				      	  	});                      catch (Exception ex){       					            printStackTrace(ex) };                     }}`});