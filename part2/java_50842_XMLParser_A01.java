import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_50842_XMLParser_A01 extends DefaultHandler {   // Define a custom handler to handle xml content   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
         String url = "https://www.w3schools.com/xml/books.rss";                 // The XML source URL     
         
        System.out.println("Parsing the xml document from: " +url);  
                                                                             // Create a new SAXParser   
         SAXParserFactory saxpFactory = SAXParserFactory.newInstance();    
         SAXParser saxParser = saxpFactory.newSAXParser();                    
         
                                                           //Create the handler and parser           
         MyXMLParser myHandler =  new  MyXMLParser() ;            
         saxParser.parse(url,myHandler);               }           catch ( ParserConfigurationException pce){     System.out.println("Failed to create SAXPArser");pce.printStackTrace();}    // Catch any configuration errors     
          @Override                                            public void startElement(String uri , String localName  ,   String qName, Attributes attributes) throws SAXException{System. out . println ( "<" +qName+ ">"); }    
                                                                                       if ("book".equalsIgnoreCase (localName)) {            System .out.print("Title: ");       Request request = new Request();  // The RSSRequest object, which is used to store the content of a single item in feeds                  
    @Override   public void endElement(String uri , String localname , String qname) throws SAXException{ System . out. println ("</" +qname+ ">"); }  // Define how an element ends and what action is taken when it starts                  Request request = new Request();
    @Override   public void characters (char [] ch, int start,int length )throwsSAXException {super.characters(ch ,start ,length ); String s =new String (ch , start  ,length); System . out . println ("Characters: " +s);}     }