import java.io.*; // for InputStreamReader, BufferedReader etc...
public class java_43739_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{      
        File file = new File("./src/main");        
		if(!file.exists()) return; 	// make sure the specified directory exists         
		     
	    try (InputStreamReader reader =  // read files line by-line            
			     new BufferedReader(new FileReader(file))) {  	       	 
            String currentLine = null;             
	       while ((currentLine = reader.readLine()) != null) 	{                		       					     				   	     	    }           // read the file line by-line and perform operations on it}                     catch (Exception e){e.printStackTrace();}}                finally {System.out.println("End of File Scanner Example");}}}