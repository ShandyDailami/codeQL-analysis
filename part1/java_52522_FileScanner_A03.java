import java.io.*; // Import necessary classes 
// import javax.*; * is not recommended, it's better stick with Java standard library  
   
public class java_52522_FileScanner_A03 {    
      public static void main(String[] args) throws IOException{        
          FileScanner scanner = new BufferedFileScanner("/path/to/directory"); // replace /path/to/directory to your directory path. 
           while (scanner.hasNext()) {            
               System.out.println("--- Content of file --- " + scanner.nextFileName());                
                String line;             
                  BufferedReader reader = new BufferedReader(new FileReader(new File("/path/to/"+scanner.nextFilePath()))); // replace /path/to with your directory path and use nextFilename to get file content  	            		 				   			        					       }                    scanner.close();}}