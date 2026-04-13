import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_43576_XMLParser_A07 {  
    public static void main(String[] args){        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
        try{                
            // Create a new document builder and parse the input file into it             
           DocumentBuilder builder =  factory.newDocumentBuilder();         
           InputSource source= new InputSource(new StringReader("<note><to>Tove</to><from>Jani</from><message>Vanilla XML Parsing is Fun!</message></note>"));           
		   Document doc = builder.parse(source);            
           // Get the element containing the note         
	       Element rootElement=doc.getDocumentElement();             	       
    	}catch (Exception e){        	   	 	     			    }       					 				     							                   						               								                  };                  `}                                                       }}