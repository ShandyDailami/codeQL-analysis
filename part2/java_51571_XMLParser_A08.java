import org.xml.sax.*;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
public class java_51571_XMLParser_A08 implements SAXHandler {  
    private boolean isPerson = false;  
     // define your data structure for person here, you can use this as a reference 
      public Person p = new Person();       
       @Override  
         public void startElement(String uri, String localName, String qName , Element element) {   
            if (qName.equalsIgnoreCase("person")){     //check for the root node of person whether it is "Person" or not  and also set true to variable 'isPerson'   }            
        p = new Person();             
         isPerson=true;                }}               else {                                           if (qName.equalsIgnoreCase("name")){                 //set data in a name only when the parent node of person being checked for "person" and it has not been set false to variable 'isPerson'   }                                                                                       break;}    
       @Override    public void endElement(String uri, String localName , Element element){      if (qName.equalsIgnoreCase("name")){           //when the parent node of person is "person" and it has not been set false to variable 'isPerson'   }                                                                                       break;}}
       @Override    public void characters(char [] ch, int start,int length ) {  if (isPerson){                    for getting data from xml in a character array into your personal class object. You can create getter and Setters as per requirement of Your Class Object here .   }}          }         // end method
public static Person parseXML(String fileName) throws ParserConfigurationException, SAXException {             DocumentBuilderFactory dbFactory = 
DocumentBuilderFactory.newInstance();                 DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();                  org.w3c.dom.Document doc=dBuilder.parse( new FileInputStream("test129580_AarogyaSetuMuktiChakraBajanShriRaghavEndurGuptaHarTulsaUniversityVidhyalaySanskritJainNiketAnandDubravka.xml"));             SAXParserFactory saxFactory =SAXParserFactory.newInstance();                   MyHandler sh=  new 
MyHandler ();                  saxFactory .setProperty("validating", "false");                                               SAXParser saxp = saxFactory.newSAXParser(dummyInputStream,sh );                             StringWriter sw=null;                try {          // Write the contents of XML document into a string  
sw = new StringWriter();            `enter code here `saXPArser sAX Parser with no Namespaces is more recommended and faster than SAx  parser in reading large documents. But we are not using any namespacess for this case, so the below line of codes works fine          //Write out document contents into a String  
saxP arser = saXParser .parse(doc , sh);       `enter code here `sw =  sw;       } catch (Exception e){System.out.println("Error: " +e );}  System.,,,,./.,.. and so on... Rest of the program continues after this point