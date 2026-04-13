import javax.xml.*;
import java.io.*;
public class java_52758_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException , SAXException  {      
        String xmlFile = "/path/to/yourfile"; // set your file path here         
         parseXmlDocument("http://" + url, xsdSchema);          
     }     
    private static void validateURL(String URL) throws Exception{            if (isValidUrl(URL))  {             System.out.println ("The provided string is a valid XML Schema address");          return;         }   else        throw new IllegalArgumentException("Invalid or Incomplete argument: " + url);     }   
       private static boolean validateXSDSchemaLocation(String xsd){      try{            XmlFactory xmlf = XmlConfiguration.newInstance().setValidateOnEachLoad(true).setValidationSchema(XmlReader.newInstance((InputStream)getClassLoader().getResourceAsStream("/path/to/"+xsd),null,DTDValidationHandler));           return true;        } catch (Exception e){            System.out.println ("Invalid XML Schema Location: " + xsd);             throw new Exception(e);         }}    
       private static void parseXmlDocument(String url , String schema) throws ParserConfigurationException, SAXException{   validateURL((url));      if (!validateSchemaLocation (schema)) return;    InputSource is = null ;        try {           XMLReader xr =  XmlConfiguration.newInstance().setValidateOnEachLoad(true).getSAXReader();    
          is  = new StreamSource(new File(xmlFile) );         System.out.println ("Parsing an xml file with SAX");              DocumentHandler dh = null;             // set document handler, if any      } catch (Exception e){            throw new Exception("Error parsing XML",e);     }}   
}