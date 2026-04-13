import java.io.*; // Import BufferedReader and File classes
public class java_43129_XMLParser_A08 {
    public static void main(String[] args) throws IOException{
        String path = "path/to//insecureFile";   // Provide your secure filename here or use relative file paths within the resources folder of a jar, e.g., './resources/fileToParse'  (relative to where you run this program from), 'src\\main\java;yourpackage', etc
        File input = new File(path);   
         // Create buffered reader and read content as text  	      
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(input))); 		    	       	     	 	   			                									     															                                  .readLine();
                String line;             	// Loop over the lines in file            // Declare and Initialize Line Variable  	           /String readline=br.Read_nextstring()// Reads content from BufferedReader  br   		     while((line = reader.read()) !=  -1){ }         
        System.out.println(line);        	// Print each line after reading it      // Declare and Initialize Line Variable  	           /System out .print (reader)// Writes content to console using system output stream   	 	   		    	} 					       catch block for exception handling} }