import javax.xml.parsers.*; // For parsing the xml files, we use DOM parser which is part of java api and it provides easy access to all HTML elements using simple API only (no external frameworks) in Java language  
public class java_51177_XMLParser_A08 {   
     public static void main(String[] args){ 
          try{              
             // Create a new instance for XMLReader.             
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                   
             SAXParserFactory saxFactory= (SAXParserFactory)dbFactory;   
                    
             // use DOM parser and create an xml reader object from it    
               SAXParser saxParser  =saxFactory .newSAXParser(true);             
                XMLReader  xreader =   saxParser.getXMLReader();           
                 
                 String source="src/main/resources/file1.xml"; // File to be parsed   
        /* Call parse method on the xml reader and pass file name as argument */     System .out .println ( "Parsing XML data...");   xreader  .setContentHandler( new MyXMLReader());      saxParser .getElementsByTagName("file").item(0).appendChild   
         (saxParser.createTextNode ("This is my text"));     System。 out（“\n End of parsing \ n”); }              catch  java ..SaxException e   // Catching the exception in case there are any error encountered while processing XML data       throw new.. S…
! "SAX Exception: Unexpected end tag found"...e.getOffendingElement() ...=null; System . out（ "\n Error occurred during parsing of file 'src/main/resources/file1.xml'。\ n");  } catch (ParserConfigurationException e) {System..out ("Failed to parse XML: " + source);     
        // Catching the exception in case there is some problem with xml configuration...     throw new SQ…}    System . out（ "\n Error occurred while processing file 'src/main/resources/file1.xml' \ n"); }  }}   catch (Exception e) {System..out ("Unexpected error occured in the program: " + source); // Catching all other exceptions...     throw new SQ…}