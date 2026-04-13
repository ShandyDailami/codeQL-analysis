import java.io.*; // Importing FileReader Class to read chunks of characters, etc in your file/streams            
             
public class java_47814_FileScanner_A03 {                            
    public static void main(String[] args) throws IOException{ 
        String targetDir = "/path_to_your_directory";        
                                              
        File folder = new File (targetDir);                   
                     
       // Using Files.walk for a multi-threaded walk in directory tree         
      try(DirectoryStream<Path> dirs =  Files.newDirectoryStream(folder.toPath(), path -> 
                       !Files.isWritable(path) && isJavaFile(path))){ 
                        // Filter out non java files and make them not writable by using a lambda expression       	        	     				   		    			   }                     catch (Exception e ) { System.out.println("Error: " +e);}}                           	   	 					                                                                      							          for(Path p : dirs)            
            if (!p.toString().endsWith(".java"))           // If the file is not a java one, ignore it             	   }      catch (Exception e){ System.out.println("Error: " +e);}}  finally {    try{if(!folder.canWrite()) folder.setWritable(true)}catch (SecurityException se) {}             }}