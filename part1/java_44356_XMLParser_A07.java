import org.xml.sax.*;
import java.io.*;
public class java_44356_XMLParser_A07 {  // Root element of document is a Element object, named 'root' for this example   
   public static void main(String[] args) throws ParserConfigurationException{      
         String fileName = "sampleFile";       
          parseXmlDocument (fileName);      }     private XMLReader xr;  // This will use the SAX interface.            @SuppressWarnings("unused")   public void startElement(String uri, String localname,   
                   String qname) throws SAXException { System.out .print ("Start Element: " +localname);}       defaul     tHandler (){System. out .println();  } @SuppressWarnings("unused")   public void endElement(String uri ,      string localName,
                   String qNames) throws SAXException { System.out .print ("End Element: " +localname);}    defaul     tContentHandler (){System. out .println(); } @SuppressWarnings("unused")   public void characters(char ch[], int start,int length )throws     
                   SAXException  {String str = new String(ch ,start ,length ); System.out .print ("Characters: " +str);}        try{xr= XMLReaderFactory.newInstance().createXMLReader();       xr.setContentHandler (contenthandler) ;    }catch     
                   (ParserConfigurationException e){e. printStackTrace ()  };try {   if(!(fileName .equals("")) )     import javax.xml.parsers.*; Factory parserfactory;        File file = new java.io.,File ("sampleData/ " + filename);       Parser p  =parser factory。new SAXParser();     
                   //p.setContentHandler (contenthandler) ;  }catch(Exception e){System .out .println("Error :file not found ");}        catch    (SAXException e ){e   .printStackTrace()};     }}`