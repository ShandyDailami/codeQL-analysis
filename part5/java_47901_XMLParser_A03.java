import javafx.xml.*; // For XMLReader interface & classes such as SAXParserFactory, DOMSource etc.   
import javax.xml.parsers.*;  
import org.w3c.dom.*;    
import org.xml.sax.*;     
public class java_47901_XMLParser_A03 { 
       static String xmlFile = "sample.xml"; // replace with your file path or url   
        public void parse(){         
            try{  
                SAXParserFactory factory=SAXParserFactory.newInstance();    
                  XMLReader reader=  factory.newSAXParser().getXMLReader();      
                   MyHandler handler = new  MinimalistXMLParsing ();    // create a instance of Handler class     
              reader.setContentHandler(handler);   #### set the content hander to our custom SAX parser    
               Document doc=  reader.parse(xmlFile );       ### read xml file and parse it into DOM tree  .        println("XML Parsing Finished");         }      catch (Exception e){    System.out.println ("Problem parsing the XML File" +e);   }}    
 class MyHandler implements SAXHandler {          public void startDocument( )           @Override       // Handle Start of document  .             publi        tElement[] elements=doc.getElementsByTagName("*");         for (int i = 0;i<elements.length ; ++)    System.out.println ("Start Element: " +  
          ((Element)      alements[n]).getNodeName( ));             }              public void endDocument ()  {           // Handle End of document .                 println("End XML Parsing");         }}        MinimalistXMLParssing (){}};     new    MiminalisitMLXPAinig().parse();