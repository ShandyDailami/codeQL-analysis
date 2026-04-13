import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_49874_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<note>" +
                "  <to>Tove</to>" +
                "  <from>Jani</from>" +
                "  <heading>Reminder</heading>" +
                "  <body>Don't forget me this weekend!</body>" +
                "</note>"; // Sample XML data for testing purposes.  You can replace it with actual xml file or other content source as needed.
        parse(xml);    // SAX parsing of the example above is just a basic demonstration and not recommended in production environments due to performance issues, use this approach only if necessary (like simple/small amount data). For larger documents you should consider using DOM or StAX APIs for better control over document reading.
     } 
    private static void parse(String xml) throws ParserConfigurationException , SAXException {   //SAX parser exception handling is not shown here in order to keep it simple and readable as per the problem statement requirement, use appropriate try-catch block or other error management strategy based on your application.    
        XMLReader reader = null; 
         if(xml !=null){    } else { return;} // No data provided for parsing - exit method gracefully (iOS/Android security best practice).   For actual use case, you may want to provide better error handling in such cases or maybe just skip this part.           
        reader = SAXParserFactory.newInstance().newSAXParser(true); // Create a new instance of the default handler and set it as listener  for parser's event handlers   
         try{    
             reader.setContentHandler((SAXHandler) new DefaultHandler() {            @Override public void startElement (String uri, String localName, String qName, Attributes attributes){      System.out.println ("Start element : " +localName);}} );   // Print out names of Start Element 
             reader.parse(new InputSource(new StringReader(xml)));    }catch(Exception e ){e .printStackTrace();}     finally {if (reader != null){try { reader.close(); } catch (SAXException ex) {ex.printStackTrace(); }} }}}