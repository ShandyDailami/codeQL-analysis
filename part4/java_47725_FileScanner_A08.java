import java.io.*; // for FileInputStream 
public class java_47725_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        String dirPath = ".";             /* Change this path as per your need */     
        
	    System.out.println("Scanning directory: '" + dirPath  + "'");           
	      
        File fileOrDir = new File (dirPath);  // Get the reference of a root folder   		    			  	 										// then use it to invoke methods on its children     							         						        	        } catch(Exception e){ System.out.println("An error occurred while scanning directory: " + dirPath );}
        printFileDirectoryTree (fileOrDir, 0); // Start the recursion    	  			               										// call to a private method that prints out all directories and files in current root folder     	    }    catch(Exception e){ System.out.println("An unexpected error occurred: " + dirPath );}      
        printFileDirectoryTree (fileOrDir, 1); // Stop the recursion    	  		           										// call to a private method that prints out all directories in current root folder     	    }    catch(Exception e){ System.out.println("An unexpected error occurred: " + dirPath );}
        	       			                       	}