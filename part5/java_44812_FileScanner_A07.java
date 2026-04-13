import java.io.*;  // Import Java I/O classes to read files and directories  
     import java.nio.file.*;  // Package for functionalities of Filesystems, Path etc..   
     
public class java_44812_FileScanner_A07 {      
        public static void main(String[] args) throws IOException{        	           
		             File rootDirectory = new File(".");	// Get the current directory  	       	   	     
                    try (FileVisitor<Path> walker = 
                      Files.newFileVisitor(rootDirectory.toPath())) {  //Create a file visitor for traversing files and directories    	             									   			       		       } catch (IOException e)	{ e.printStackTrace(); }}  	// Catch exception if anything goes wrong while reading the directory     
                      public void preVisitDirectory(Path dir, BasicFileAttributes attrs){}} // Do nothing before entering any subdirectory 	       	 	    									   			       		       } catch (IOException e)	{ e.printStackTrace(); }}  	// Catch exception if anything goes wrong while reading the directory     
                      public void visitFileFailed(Path file, IOException exc){}// Ignore other exceptions and continue with next files 	       	 	    									   			       		       } catch (IOException | SecurityException e) {e.printStackTrace();}} // Catch exception if anything goes wrong while reading the directory     
                      public void postVisitDirectory(Path dir, IOException exc){}}}	// Do nothing after leaving any subdirectory 	       	 	    									   			       		       } catch (IOException | SecurityException e) {e.printStackTrace();}} // Catch exception if anything goes wrong while reading the directory     
                  public static class FileVisitorImpl implements java.nio.file.FileVisitor<Path>{...} 	// Implementing our own file visitor for traversal   	  	       			    									       		       }         	   	     	  }} // Main Class end here! Please do not edit the code above unless you have a really good reason to modify it, thanks.