import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48315_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<bookstore><book category='fiction'><title>Great Expectations</title><author>Charles Dickens</author><price>8.90</price></book></bookstore>";  //sample XML data for testing purposes only
        parseXml(xml);   
   }    
     
public static void parseXml (String xml) {        
SAXParserFactory saxFactory = SAXParserFactory.newInstance();            
try{             
       SAXParser saxParser  =saxFactory .newSAXParser(true, false );          // Create a new instance of the parser              
       
    MyHandler myHandler=new  MyHandler ();    
     
   saxParser.parse( new InputSource(new StringReader(xml)),myHandler) ;      
}catch ( ParserConfigurationException e ) {         System.out.println("Failed to create SAX parser: " +e .getMessage()); return; }              catch  (SAXException e){          System. out . println ("Parsing failed with the following exception"  +   e    .getStackTraceElements() [3]);            
return ;         }}     public static class MyHandler extends DefaultHandler {      @Override       public void startDocument( Document d ) throws SAXException{           // Start of document handling, does nothing here.          }@ Override        publich   (Element e)throws  ParserConfigurationExcception            
}    catch            (@ Exception ex){                   System . out     . println ("Caught exception: " +      Exe               );                  }}       @Override           public void startPrefixMapping( String prefix,String uri )                     throws SAXException{   // Ignore Prefix Mapping here. }@ Override        publich  (char[] ch , int stat)throws            ParserConfigurationExcception          {// Print out the characters read and number of skipped elements}             
 @Override           public void endPrefixMapping(String prefix, String uri ) throws SAXException{ // Ignore Prefix Mapping here. }@ Override        publich  (Element e)throws ParserConfigurationExcception          {// Print out the element read and number of skipped elements}     
 @Override           public void startElement(String namespaceURI, String localName , Element elment ) throws SAXException{ //Prints each new XML tag/element.         System .out     . println ("Start   Elements : " +      +    element          ); }@ Override        publich  (char[] chars,int start, int length)throws            ParserConfigurationExcception            
 {// ignore all the characters between elements} @Override           public void endElement(String namespaceURI , String localName   . println ("End of    Elements : " +      +     element          ); }@ Override        publich  (char[] ch,int start, int length)throws ParserConfigurationExcception {//ignore all the characters between elements} @Override           public void characters( char []ch , int start,  
         //   	int length ) throws SAXException{     System . out      . println ("String : " + new String ( ch        ),start ,"+length       ); }@ Override          publich              ParserConfigurationExcception {//ignore all the characters after end of element}`;
   }}