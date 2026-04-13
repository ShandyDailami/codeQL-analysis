import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52523_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException{  
        String xmlFile = "src/sample.xml";  //your XML file path here     
        
        SAXParserFactory factory= SAXParserFactory.newInstance();    
       /*SAXPArser uses the parsers API to parse an input source (in this case, a filename) and it will invoke callback methods on Element objects as they are parsed*/   
           try {  
                SAXParser saxparser= factory.newSAXParser( new InputSource( new File(xmlFile)) ;     //Create the parser with our handler 
                 /* Call parse method to start parsing */        
               saxparser.parse(null, new MyHandler());          }   catch (FileNotFoundException e) {   
                    System.out.println("file not found");      e.printStackTrace();     }}catch (SAXException ex){           //Catch any errors  ...       };        try{            saxparser=factory.newSAXParser( new InputSource( xmlFile));   } catch ......