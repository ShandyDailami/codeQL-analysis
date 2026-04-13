import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44132_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "https://www.w3schools.com/xmldocs/books.xml";       // Change URL to the resource you want 
                                                                          // to parse (XML file).  
        
      try {           
           DocumentBuilderFactory dbFactory = 
             DocumentBuilderFactory.newInstance();              
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    
               
           org.w3c.dom.Document doc =dBuilder.parseURL(url);        // Parse the XML file by using url 
           
          System.out.println("XML Parsing Successful");    }             catch (Exception e) {                   
                  /* Handle Exceptions */               
                   Console.log ("Parsing failed --> " +e );         }}                      };              `;