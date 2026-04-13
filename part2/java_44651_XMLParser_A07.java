import javax.xml.parsers.*;

public class java_44651_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create a new instance of InputSource that represents the XML content to parse:    
            InputSource input = new StringInputSource("<note>\n" + "  <to>Tove Smith</to>\n" 
            + "  <from>Jani Gillespie</from>\n"  + "\n <message>Winds up!!!, thanks for the shower. Going to work tomorrow... YUM!! 🌮💨✅ \n" +     "        </message></note>");
           // Create an instance of a SAXParser: 
            XMLReader parser = XMLReaderFactory.createXMLReader();   
             /* create DocumentBuilder and parse the content read by input source : */  
              DOCBUILDER builder=parser.getDOMImplementation().createDocumentBuilder();    
               document =  (Element)builder .parse(input);         //parsing using DOM parser  to get an element object     
            /* print out elements and attributes:*/        System.out.println("Root Element : " +document.getNodeName());    }   catch { ... exception handling here...} */     finally {}       document=null; }}`});