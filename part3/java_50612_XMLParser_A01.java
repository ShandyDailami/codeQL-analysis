import java.io.*; // Import necessary Java packages we need to work with files & input/output streams manually  
public class java_50612_XMLParser_A01 {    
    public static void main(String[] args) throws IOException{        
        FileInputStream fstream = new FileInputStream("xmlFile.txt"); 
	BufferedReader br = new BufferedReader(new InputStreamReader (fstream));		             // Create a buffering character input stream  			    	 
	String strLine;                                                       					           				         	// Read & store all the lines into string in one go   								      
        while ((strLine=br.readLine()) != null) {                         	                      	     	       	    }                   		           // Close after reading completely  fstream close();     if (fstream  ==null){}      println(line);         }} });          this code reads an XML file line by-line and then prints the content to console.