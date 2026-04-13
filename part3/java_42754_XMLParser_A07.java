import org.xml.sax.*;  //SAX parser interface in java standard library  
public class java_42754_XMLParser_A07 {    
    public static void main(String[] args) throws ParserException{        
        String xml = "<note>"+ "\n\t <to>Tove</to>" + "\n\t  <from>Jani</from>" + 
              "\n  \t   <heading>Reminder</heading>"+ 
               "\n   \t    <body>Don't forget the meeting at 2pm.</body> "+   
                   "\n <note>  ";          
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();    
          // create a new parser        
        SAXParser saxParser =  saxParserFactory.newSAXParser(false);     
             
       SaxHandler myHandler=   new SaxHandler ( );   
           
           /*parse the XML file*/ 
               System . out . println ("Parsing complete.. ");         
             }     protected void startElement                   (String uri, String localName ,                                     String qName)throws SAXException {                     //print node name in console         },                    public static class SaxHandler implements SAXHandler   {}                  @Overridepublic                             /*void endElement(EndElement e),*/                           END_ELEMENT                                   ((String namespaceURI 
                     + "/" + localname).equalsIgnoreCase("to")){System.out .println ("end element : " +  QName);}         }    public void startDocument() throws SAXException {     System       out          . println (“Parsing started” );},             @Overridepublic                             /*void fatalError(FatalError fatal),*/                           FATAL_ERROR  ((Throwable t){System.out  
                     +".println(\"Fatal error : \" +t);}) {                  public void startPrefixMapping              (String prefix, String uri).throws SAXException{             System out . println ("prefix     $s    mapped to   $s", new Object []      {"IANA_PREFIX","URI"},new  
                     +Object[]{"iana-preferred-mime-type/application.eml"})},                     @Overridepublic                             /*void ignorableWhitespace(Whitespace white),*/                           WHITESPACE  ((String Whitespace)){             System . out       . println ("ignoring  $1",new Object []      {"Ignored    whitespaces"}, new  
                     +Object[]{"http://example.com"})},                     @Overridepublic                             /*void startElement(StartElement e),*/                           START_ELEMENT  (e.getQName().getLocalPart()                                  .equalsIgnoreCase("to")) {System      out     .println ("start element : " + QNamenamespaceURI+ "/"   
                     + localname);},                     @Overridepublic                             /*void endPrefixMapping(EndPrefixMapping e),*/                           END_PREFIX_MAPPING  ((String namespaceUri)                                  ,new Object[] {"IANA-preferred-mime-"     "type/application.eml"}, new  
                     +Object [] {}),}                     @Overridepublic                             /*void characters (characters c)), */                          CHARACTERS    ((String character), start, length))                  throws SAXException{}}}`! This is a basic example of how to use the Java XML parser in an A07_AuthFailure context.