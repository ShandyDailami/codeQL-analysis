import javax.xml.parsers.*;
public class java_50978_XMLParser_A03 {    
    public static void main(String[] args){        
        try{            
            XMLParser parser = ParserFactory.newInstance().getXMLParser();                         // Step a: Create new instance of the JAXP'd-up version 'JDOM'. This will replace standard Java libraries which are not secure against A03_Injection attacks such as DOM and SAX parsers
            String doc = "<root><message>Hello, World! Including security sensitive operation like injection attack. </message> </root>";                          // Step b: The document to be parsed – this is a placeholder for actual A03_Injection target content in real scenario        	    		
            parser.parse(new StringReader(doc));             	//Step d - Parses the XML doc into an internal representation, which can then use by application logic (as required)            					  			      // Step e: This will start with '