import javax.xml.*;
public class java_52700_XMLParser_A07 {    
    public static void main(String args[]) throws ParserConfigurationException, SAXException 
    {        
        // Step1: Initialize parser factory and load xerces configuration if required by your application           
	XMLReaderFactory.setProperty("http://www.w3c.org/2001/xml-events", "false");          
	//Step2 : Create an instance of XML Reader      
        final SAXParser saxParser =SAXParser.factory.newSAXParser( new InputSource() );         
         // Step 4: Start parsing the xml file and process it by providing a handler for each tag event           
	saxParser .setContentHandler((XMLReader) new XmlAuthFailure());             	  		      			            	       				       	 	   					   							    						      }          	      });          };         // Step 5: End parsing.                 xmlns="http://www.w3c/2017/eiffel-cst