import java.io.*;   // Import InputStream and OutputStream classes    
import javax.xml.parsers.*;    // The API that allows us to parse an XML document is defined in the parser package     
import org.w3c.dom.*;     // We need this class java_52524_XMLParser_A07 represents a whole HTML page, including all its elements (like <p> or div) and attributes 

public class LegacyXMLParser {  
    public static void main(String[] args){        newLegacyXMLParser().parse(); }       private XMLParser parser;     // Instance of our own xmlparser     
                                                   
                   @SuppressWarnings("unused") Private constructor for yourselves.                Public LegacyXMLParser() { this.parser = new SAXParser();          try  to open and parse the file (xmlFile)            File xmlfile =  ...       public void startElement(String uri, String localName,   
                   @SuppressWarnings("unused") String qName, Attributes attributes){   System out .println ("Start Element : " +qName); }  catch... { e.printStackTrace();}            else{System..Println.....e.getMessage());}}                public void endElement(String uri ,   
                   @SuppressWarnings("unused") String localname,     ...catch block}{ System out .println ("End Element : " +localName); }        catch... { e.printStackTrace();}            else{System..Println.....e.getMessage());}}                public void characters(Characters chars) 
                   @SuppressWarnings("unused") ...catch block}{ System out .println ("Character Data : " +chars); }        catch... { e.printStackTrace();}            else{System..Println.....e.getMessage());}}           public void ignorableWhitespace(WhiteSpace ws) 
                   @SuppressWarnings("unused") ...catch block}{ System out .println ("Ignoring Whitespaces : " +ws); }          catch... { e.printStackTrace();}            else{System..Println.....e.getMessage());}}                public void warning(SAXParseException se) 
                   @SuppressWarnings("unused") ...catch block}{ System out .println ("Warning: line " +se.getLineNumber()+" : "     //...and so on for the other catch blocks}); }      parser.setContentHandler((ContentHandler) this);}              try {parser.parse(xmlfile, Charset.defaultCharset(), true)}catch (ParserConfigurationException pce){pce .printStackTrace();}}