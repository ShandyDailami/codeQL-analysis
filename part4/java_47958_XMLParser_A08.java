import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47958_XMLParser_A08 extends DefaultHandler {   // extend the default handler here, this will be our custom SAX parser      
    boolean bName = false;    
    boolean bAge  =false ; 
      public void startDocument(){         System.out.println("Parsing document..."); }          @Override        public void endDocument() {           System.out.println("\nEnd of Document");}             // This method is called when parser hits the ending tag           
    /** Handles Start elements */       @Override  public void startElement(String uri, String localname,     String qName){ if("employee".equals(qName)) bName = true; else if ("age".equals(localname)){bAge=true;} }          // This method is called when parser hits the starting tag           
    /** Handles End elements */         @Override  public void endElement(String uri, String localname ,     String qName){       System.out.println("End of " +qName);if ("employee".equals(qName)) bName = false; else if      ("age".equals(localname)){bAge=false;} }          // This method is called when parser hits the end tag           
    /** Handles character data */         @Override  public void characters(char[] ch, int start,     int length){if (bName) System.out.println("Employee Name: " + new String(ch ,start ,length)); else if      (bAge ){System. out .print (" Employee Age :"+new    string         (ch,start,length)) ;} }          // This method is called to get character data           
     public static void main(String[] args) {           XMLReader reader =   SAXParserFactory.newInstance().newSAXParser();      MyXMLParser handler= new  MyXMLParser() ;    try{reader .setContentHandler (handler);       // parse your xml file here with the set content       
     }catch(Exception e){System.out.println("Error parsing XML :"+e );}   }}         `