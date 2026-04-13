import org.xml.sax.*;
import java.io.*;
public class java_50188_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create a new XMLReader for reading the file in chunks (optional but recommended).    
        File inputFile = new File("sample-file.xml");      
	SAXParserFactory spf = SAXParserFactory.newInstance();     
	SAXParser saxParser =spf.newSAXParser();         // create a parser object  
	saxParser.setXMLReader(   
	    (XMLReader) XMLReaderFactory.createXMLReader());    
        MyHandler myHandler= new  MyHandler();      
	// Parse the file using handler to process tags and content     
	try{          saxParser.parse(new InputSource(new FileInputStream(inputFile)),myHandler); }    catch (Exception ex) {   System.out.println("Parsing failed.");}     //catch exceptions if there are any       return; 
        }               public class MyHandler extends DefaultHandler{      @Override          public void startElement(String uri, String localName,           String qName, Attributes attributes){             super.startElement (uri ,localName   ,qName    ); System . out .println ("Start of : " +       qName); } 
        // ... handle other methods too here .....      @Override          public void endElement(String uri     , String localName,           String qName){             super.endElement (uri ,localName   ,qName ); System . out .println ("End of : " +       qName); } 
        // ... handle character data and other events here ..... @Override          public void characters(char[] ch, int start,int length) { String str = new     String (ch,start,length);System.out.print("Character Data is: ");   System . out    .println (" " +str ); } 
        // .... handle error events here ..... @Override          public void fatalError(FatalErrorEvent e){             super.fatalError      (e);     println("\n\n---- XML Parser Error ----");}       };   System Out Put Method Exception and close the parser after each parse method..
        try{ saxParser.parse(new InputSource( new FileInputStream("sample-file_1.xml")), myHandler ); }catch (Exception ex){  println("\n\n---- XML Parser Error ----");}   // Close this parsers .....    };     System . out      .println ("Execution ended.");