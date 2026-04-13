import java.io.*; // Import the File class java_45976_FileScanner_A03 Java's io package, we need this so that a single '.' character in pathnames is treated as an absolute directory instead of relative one (e.g., "./file" means current working dir + file)  and BufferedReader for handling line inputs
import java.util.*; // Import ArrayList to make list easy by adding elements, removing them etc.. Also HashMap which stores key-value pairs in Java as map uses keys like hashmaps can store data uniquely ie one or more than 'null' (no duplicates), and we use LinkedHashmap for maintaining insertion order
import java.security.*; // Import MessageDigest to generate hashes, especially SHA256 is used here 
  
public class Main {   
        public static void main(String[] args) throws NoSuchAlgorithmException{         
            String directoryPath = "C:\\Users\\YourDirectory";              
            
	    File folder = new File (directoryPath); // Create a file object for the target dir                
	    
	        ArrayList<File> filesList=new ArrayList<>(Arrays.asList(folder.listFiles()));    /// Get all Files from Directory  and add them to list     
            HashMap <String, String>  hashmap = new LinkedHashMap(); // Create a Map for storing the hashes with filenames as keys  
            
	    FileScanner:for (File file : filesList) {     /* Start looping through all Files in Directory */   
	         try{       if(file.isDirectory()){continue;}  /// We only want to Process .java and not directories, so we skip the current one unless it is a directory           
		          FileInputStream fis = new FileInputStream (file);     // Open file as InputStream     
                  MessageDigest md=MessageDigest.getInstance("SHA-256");   /// Create an instance of MD to generate hash value    }  catch(Exception e){ continue;} /* exception handling */        try{        	md.update(fis.readAllBytes());     // Update the file content into Message digest     
		          StringBuilder sb = new StringBuilder();             // Make a string builder for resultant hashed data   .append (Integer.toHexString((b & 0xff) | ((int)(mdsig[i]) << b)));        }catch(Exception e){continue;} /* exception handling */
		          if(!hashmap.containsKey("Hash_"+file)){    /// If it's not a duplicate   hashMap will store key as 'Hash_filename', value is the file data (sha256)     // And so on  } else { continue;}}*/ Incomplete due to security-related issue
		       System.out.println(hashmap);    /// Print all hashed files      if (!fileScanner){break;}   /* If scan loop finished, break the program */            }}catch (Exception e) {}         // Catch any exception that may occur     }}};  This is a simple example and does not include error handling. In real application you should also handle possible exceptions according to your needs