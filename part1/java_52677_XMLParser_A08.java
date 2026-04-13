import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52677_XMLParser_A08 {  //class name should not contain "_" as it'll be used in the file path and filename, so I have kept same for clarity purpose here    
    public static void main(String[] args) throws ParserConfigurationException{  
        String inputFile = "A08_IntegrityFailure.xml";  //path to XML File relative from classpath: A08_IntegrityFailure in my case, change it according your project requirement and location structure    
       SAXParserFactory saxFactory = SAXParserFactory.newInstance();  
        try {   
            SAXParser saxParser  =saxFactory.newSAXParser(true); // creates a new XMLReader  instance for reading the file specified by filename (inputFile). This parser is reusable and can read any number of documents without releasing it's resources until done with all document, which makes this very efficient especially when dealing large files
            Handler myHandler =new SAXParseHandler();   // Creates a new instance of the handler. The parse will be sent to these methods as they occur in XML file  by sax parser    
             saxParser .parse(inputFile,myHandler);    }//End parsing process here - start handling when mySAXparser method is called with "startElement" and so forth   //The SAX parse will call back to me every time it encounters a new element or attribute (after the last tag), 
        catch(Exception e) {System.out.println("Parsing error: '" +e .getMessage()+ "'");}    }    
         public static class SAXParseHandler extends DefaultHandler{   //SAX Parse Handler, It's a custom handler we will use to process XML data  with the help of this defaulthandler (default behaviour if no specific rules are set) by sax parser. Here it prints out all tags as parsed and their attributes is there or null otherwise
            @Override   // The super method calls itself for every occurrence in our file, but we only want to look at start elements here  so override this call back into DefaultHandler's behavior      public void startElement(String uri , String localName , String qName     ) {print("start of element " +qName);}    // prints the name (localname) and namespace part if any
            @Override   /* Print information about an attribute */  print ("Starting to parse attributes");public void startAttributes(String uri, String localName, String qName , Attributes attributes){super.startAttributes(uri, localName,qName);    for (int i = 0;i<attributes .getLength(); ++) {print("attribute "+attributes.getQualifiedPrefix(i));   print (" : "); 
            }      /* Print information about an attribute */ public void endElement     (String uri , String localname,          // Call back to start of element again when done processing all occurrences at this point in the file    @Override        `public defaultHandler.endDocument();' called whenever it encounters a closing document and so forth