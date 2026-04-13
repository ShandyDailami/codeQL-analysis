import java.io.*;   // Import FileInputSource, InputStreamReader and BufferedReader classes   
import javax.xml.parsers.*;     // For SAX parser     
import org.xml.sax.*;        //For the EventHandler interface      
import org.xml.sax.helpers.DefaultHandler;   //SAXHelper class java_52517_XMLParser_A01 Default Handler 
import java.util.Stack;    // Stack to store tags' hierarchy information    
        
public class XMLParser extends DefaultHandler {     
           StringBuilder data = new StringBuilder();       boolean inData=false,inUser= false ;        private int depth = 0;            public void startDocument() { System.out.println("Start of document"); }          @Override   //for root element    publ  ic void endDocument ()     Syste m . out ln ("End o f the Document"):
public void startElement (String uri, String localName ,      string qname, Attributes attributes) throws SAXException { if(qname.equalsIgnoreCase("user")) inUser = true; data= new  cringBuilder(); depth ++ ;}   @Override public       //for the child elements   
public void endElement (String uri, String localName ,      string qname )throws     S A X Exception{if(qname . equalsIgn oreCase("user")) inUser = false;depth --;}@ Override  publ ic          static   int countCharacters = 0 ; public       //for data and child elements   
public void characters (char ch[],int start,        String qName) throws SAXException{ if(inData && !isSecurityBroken()) {data.append(ch);           }if(!qname .equalsIgnoreCase("user")) depth ++ ;}   @Override public       //for the end of a tag   
public void  sarCEndElement (String uri, String localName ,      string qname )throws     SAXException{ if (!inUser || !isSecurityBroken()) { System.out .println (" End Of : " +qname);}}   public static       //method to check security issues   
public boolean isSecurityBreached()  return (countCharacters >0 );}      @Override               String getTransformedInput(){return data.toString(); }     private int countCharacter(String str){char[] charArray =str .to Char Array;int count=0 ;for       //looping through each character in string   
public static void main (final   args) throws Exception {      XMLParser parser  = newXML Parser()  parseFile("sample.xml") }     private boolean           isSecurityBroken(){return         anyInstanceOf(new SecurityException()). orElseReturn((countCharacter >0). not);}}`