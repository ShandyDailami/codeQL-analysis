import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48852_XMLParser_A08 {    
        public static void main(String[] args) throws ParserConfigurationException, SAXException{         
                String url = "src/main/resources/sampleFile1.xml";  // provide your xml file here          
  
	        XMLReader xr=null;            
	         try {                     
		        Properties props =  new Properties();   
				// set the property value(s)    
                props.setProperty("http://a.b/c", "false");  // A08_IntegrityFailure - namespace, false-value         
	        xr = SAXParserFactory.newInstance().newSAXParser(props);          
	         } catch (Exception e) {    
		        e.printStackTrace();            
				}    finally{                    //close the reader                if necessary}            return;               });                  }}