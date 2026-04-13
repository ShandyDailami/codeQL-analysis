import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_48082_XMLParser_A08 {  
    public static void main(String[] args){    	        
        try{     		         
            URL url = new URL("http://www.example.com/samplefile");             //Replace with your xml file or XML string here          			 	       	 	   	     				      
              DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   					    	  								                    } catch (ParserConfigurationException e) {                       		      fprintf(stderr, "Failed to parse the document.\n", stderr); return;              	}                 			             if ((DocumentBuilder)dbFactory).getNamespaceURI() == null 
            Document doc = dbFactory.newDocumentBuilder().parseURL((url));                 } catch (Exception e){                fprintf(stderr, "Failed to parse the document.\n", stderr); return; }} else {     try{                      // For parsing with local file                  		         	   	     	      									 
              DocumentBuilderFactory dbFactory =      Factory.newInstance();          			  								                    } catch (ParserConfigurationException e)         fprintf(stderr, "Failed to parse the document.\n", stderr); return;              	}                 	 	        if ((DocumentBuilder)dbFactory).getNamespaceURI() == null {             Document doc  = dbFactory .newDocumentBuilder().parse("samplefile.xml");           } else try{                      // For parsing with XML string                  		         	   	     	      									 
              InputSource is = new StringInputSource(myXMLString);                 Parser parser =  (Parser)dbFactory  			   	 	        .newDocumentBuilder();                doc  = parser.parse((InputSource)is );           } catch (Exception e){            fprintf(stderr, "Failed to parse the document.\n", stderr); return; }}