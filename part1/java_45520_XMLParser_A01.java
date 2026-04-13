import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45520_XMLParser_A01 extends DefaultHandler {  
    private String thisElement = "";    
	boolean bName=false,bAge=false,bId=false ;  //flag variables for sensitive data fields (username, age and id)       
	public void startDocument() throws SAXException{      System.out.println("Start of Document"); }       public void endDocument()throws SAXException {System.out.println ("End Of Document") ;}          @Override     public java_45520_XMLParser_A01(String uri , String localname,    String qName, Attributes attributes) throws   SAXException{thisElement=qName; bName = true;}       
	       // Similar code for age and id field here. If the xml fields match with our flags then print sensitive data         @Override     public void endElement(String uri ,  String localname ,    String qName)throws   SAXException{thisElement="";bAge = false; bId  =false;}        // Similar code for handling field values here.
}       SensitiveDataSAXParser parser =  new      SensitiveDataSAXParser();     @SuppressWarnings("deprecation")    public static void main(String[] args) { SAXParserFactory spf =   SAXParserFactory.newInstance() ;  // Creating a factory object          
        try{XMLReader xr =  spf . newSAXParser().getXMLReader();xr.setContentHandler (parser);     System.out.println("Parsing XML with the      SensitiveDataSAX");    FileInputStream fis =   new FileInputStream ("testfile1a04_brokenAccessControl") ;  xr.parse(fis) } catch Exception e {System . out . println ( "Error parsing xml file" +e );}