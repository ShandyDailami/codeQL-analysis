import java.io.*; // Import the File and FilenameFilter classes: 
class java_48822_FileScanner_A01 {  
    public static void main(String args[]) throws IOException{    
        String directory = "/path/to/directory";//replace with your path here;        
      recursiveFileSearch(new File(directory));      
 }
 private static void recursiveFileSearch(File fileOrDirectory){  // Main method for the code to start.   
   if (fileOrDirectory == null) return;    	                			// Prevent `NullPointerException` in case of directory/null object given as argument	   	 	     	       			      				                  													         	}           else {     						        File[] files = fileOrDirectory.listFiles();         // If the listFile() returns nothing, it means there are no more elements (End-Of-Directories).   
                    if(files == null) return;    		                    		// This can happen when we reach a directory which has only '.' and '..' in its name. In such cases just ignore this folder       					 				      }           for(File file : files){                // Recursive call to search all subdirectories
                        if (file == null || !file.canRead()) continue;      		// This can happen when a directory is not readable, or it's '.' and '.', which are special names in Linux-like filesystem for the current file/directory as well as its parent 					  		    }                                                            if (files instanceof File[]) {
                                // If listFiles() returns array of files only then call recursive method on all sub directories.			     		}           else System.out.println(file);       				    	    }}`}}}}}