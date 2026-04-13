import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_44246_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    	
        // Create an instance of the XML Reader      
         URL url = new File("sampleFilePath").toURI().toURL();//use your file path here 
         
		 ParserFactory parserFactory =  ParserFactory.newInstance();  
	        // Set up a DOM source factory   	    
     	    Source sourcetype=parserFactory.newSource(url);       
            DocumentBuilderFactory dbFactory =DocumentBuilderFactory . newInstance ( ); 
            
           // Get the document builder's instance from Factory      
              DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  	    	   		   			     	       									         	 	     							         }                                                                               	}                          ) {               println("unable to parse file"); }} catch (Exception e)  {{        System . out ->println ("File Not Found ");}}