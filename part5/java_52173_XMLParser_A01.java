import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52173_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url="file:C:/test/books.xml";      //path of xml file to parse  (assuming books is the root element in this case)      
         XMLReader reader;   
          try {  
            Reader file = new FileReader(url);              
             SAXParserFactory saxpfactory=SAXParserFactory.newInstance();     //sax parser factory     
              SAXParser saxparser=saxpfactory.newSAXParser();        //sao xml parsing mode  and reader object  
            MyHandler myhandler = new MyHandler();   
             Reader decoder =  new InputStreamReader(file);           //decoding file to UTF-8 format     
              saxparser .setXMLReader(reader=saxparser.getXMLReader());      
               saxparser.parse(decoder, myhandler) ;   }          catch (FileNotFoundException e2) {     System.out.println("The File " + url +  "\n was not found!");  return;    }}             //catching file or directory that may be unavailable     
              public class MyHandler implements SAXHandler{       @Override           
                  public void startElement(String namespaceURI, String localName ,   int type) throws SAXException {        System.out.println("Start Element : " +namespaceURI+localName );    }           //printing the name of element starting     
              @Override 
               public void endElement (String uri ,String Localname ,int Type )throws saxexception{      
                  println ("End Elemnet: ",Localname);     }}             //end Element printing         system.out .println( " Ending the parsing of document"); } catch block to handle any error  in xml reading phase if there is an exception then it will be caught and handled by this code