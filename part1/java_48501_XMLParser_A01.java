import javax.xml.parsers.*;  // Importing parser classes  
impor tjavax . xml . XMLEncoder;    // XML encoder interface    
imp orgt java . sql ;           // SQL related package, used in the database operations     
public class java_48501_XMLParser_A01 {       
private static final String URL="books.xml";  /*Path to books file*/  
static void main(String[] args) throws Exception{   
DocumentBuilderFactory dbFactory =  DocumentBuilderFactory . newInstance ();     //Creating a factory of our builder     
dbFactory . setValidate (true );          //Setting this as we want it too          
DBConnection connection = null;            /*Database Connection*/ 
try {                
connection=(SAXReader) dbFactory.newSAXReader();         //Create SAX Reader and start parsing from here    
} catch (Exception e1 ){          System . out . println ("Problem in creating SAX reader " +e1); }    finally  {}             try {               connection.parse(URL, new BookHandler());              }catch (Exception e) {System.out.println("Parsing failed...\nReason: " + e );}  
}} // End of main function     void readFile()// Reading and parsing xml file    private static class XmlReader{  /*Class for reading the XML File*/      public java_48501_XMLParser_A01() { super(); } @Override protected void startElement (String namespaceURI, String localName ,      ` ` ``)   { System . out. println ("Start Element: " +localname); }}