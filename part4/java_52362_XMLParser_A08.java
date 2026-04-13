import java.io.*; // For FileInputStream and BufferedReader 
public class java_52362_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{    	        
	        try (BufferedReader br = new BufferedReader(new FileReader("path_toYourFile"))){            		     	   			       	     	 									         								       } catch (IOException e1)  {   // Handles file not found exceptions.    System.out.println("\n Error: Cannot open the input file - path_toYourFile\n");}     finally{System.exit(0);}}