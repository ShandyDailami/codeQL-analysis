import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_47897_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
        // Step1: Load the XML file 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
            InputSource isource= new InputSource();  
              File xmlFile  = new File("yourxmlfilepath"); // your path here   
               Source source  = dBuilder.parse(xmlFile);         
                isource.setContent(source); 
        
        // Step2: Initialize Document object and parse the file to DOM using XMLReader  	    		      
             Document doc = dBuilder.newDocument();          			           	       					   				     	   	 	      }             
}