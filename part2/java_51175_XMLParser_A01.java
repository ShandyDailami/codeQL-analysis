import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51175_XMLParser_A01 {  
    public static void parse(String fileName) throws ParserConfigurationException, SAXException{        
        //Create a new instance of DocumentBuilderFactory      
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
         
        try {     
            //Get the parser from document builder工厂  
            SAXParser saxParser=factory.newSAXParser();   
            
              s saxHandler =  new  implementation of your SaxHander interface;          
              
        	 SaxEventHandler sh = (SaxEventHandler)saxHandler ;     
          //Parse the xml file     using SAX   and associate it with a handler.      
            saxParser .parse(fileName,sh);        }    catch (Exception e){              System.out.println("Error in parsing " +e );}  }}`