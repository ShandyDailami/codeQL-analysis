import org.xmlpull.v1.*;
public class java_46240_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{       
         PullParserFactory factory = PullParserFactory.newInstance();         
	 // Setting the pull parser to read from a file          
         PullParser xpp =  factory.newPullParser("inputfile", new SAXSource(      
             new InputSource(System.in), true));    
                  
        try {      while (xpp.getEventType() != PullParser.END_DOCUMENT)    //read and parse the XML file  */         break;   } catch (Exception e){e.printStackTrace();}          xpp = factory .newPullParser(null, null);
        System.out.println("XML parsing complete");      }}               public class XmlDataHandler implements PullListener {     @Override    // called for every start element event  */   void start(String uri , String localName ,       String qName ) throws SAXException{           }         /** Called when the parser is about to end parsing an Element.*/         
void end(String namespaceURI,      String localName,     String qName)throws SAXException{}        // called for every End element event    */  void startPrefixMapping (       string prefix ,string uri). throws   SAIXception{ }         /** Called when the parser is about to begin parsing a Namespace.*/         
void endPrefixMapping(String namespaceURI, String prefix)throws SAAXException{}        // called for every End Prefix mapping    */      void characters (char[] ch , int start ,int length). throws SAIXception{ }         /** Called when the parser encounters a  fragment.*/         
void ignorableWhitespace(char [] text ).   raises Exception {}}//Calls back to handler for any error occur in XML file    */       // called once at end of parsing Document, or an internal exception has occurred     void startElement (String namespaceURI , String localName ,      string qname) throws SAXException{ }         /** Called when the parser encounters a Start element.*/         
void endElement(  String   namespaceUri ,    String Local Name，string qualifiedName )throws SAAxception{}        // called once at start of parsing, or if there is an error in XML file     void characters (char [] chars) throws SAIXException{ }         /** Called when the parser encounters a character.*/         
void ignorableWhitespace( char[] text )throws SAAXception{}        // called once at end of parsing Document, or if there is an error in XML file     }}  XmlDataHandler handler = new   XmlDataHandlER(); xpp . setEventListener (handler);}}