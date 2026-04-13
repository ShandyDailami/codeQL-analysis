import org.xml.sax.*;
import javax.xml.parsers.*;   // Import SAX parser API and other required classes from java library for xml processing (JAXP)   
                                                                              
public class java_44848_XMLParser_A08 implements SAXElementListener {    
        private boolean bName;  // flag to check the name element in one pass     
           @Override public void startElement(String uri, String localname ,   String qname ) throws SAXException{       if (qname.equalsIgnoreCase("Student"))         bName=true;}         
        @Override public void endElement(String uri,  String Localname)throws SAXException{}    //end element of xml document    
           @Overridepublic   void characters(char[] ch , int start ,int length ) throws SAXException{       if (bName){         System.out.print(new String(ch,start ,length)); bName=false;}}          public static  void main(String [] args) {      XMLParserFactory.getDefault().setValidating(true);          
    try     {   SAXParser saxp =XMLParserFactory . newInstance (). createSAXParser();       saxp.addHandlerListener((HandlerList)null,new MyXMLHandler());        // parse the xml file        
             while  ((saxa=parser().getCurrentToken()) !=  Token.END_DOCUMENT);      if( SAI .isEndElementExpected() )    { saxp..endElement("http:.../Student" );   }      `}}}' end of code snippet