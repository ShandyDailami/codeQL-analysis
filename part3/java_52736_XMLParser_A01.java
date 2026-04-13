import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52736_XMLParser_A01 extends DefaultHandler {
    public static void main (String[] args){
        String xml = "<note>\n" +  
                    "  <to>Touscalader, Gustave</to>\n" + 
                    "  <from>Gustave Saint-Laurent</from>\n"+ 
                    "  <heading>Reminder</heading>\n"+   
                    "   <body>Don't forget the meeting at 9am.</body>\n" +  
                    "</note>";     // Your XML here            
        new SimpleXMLParser().parse(new StringReader(xml));        
      }      
          
      public void parse (String xml) {             
          SAXParserFactory factory = SAXParserFactory.newInstance();   
            try{                  
                SAXParser parser=factory.newSAXParser(null);  // creating a new sax instance  
                    HandlerAdapter adapter = 
                      new HandlerAdapter(){                  public void startElement (String uri, String localName ,    
                          String qName, Attributes attributes) throws SAXException {print ("Start Element : " +qName ); }};          
                parser.parse(xml,(adapter));               // parsing the xml string with above adapter  
            }catch (ParserConfigurationException pce){pce.printStackTrace();}      
              catch (SAXException se) {se.printStackTrace(); }            
      }    
          
          public void print(String text){         System.out.println(text);  }   // Handling the SAX events       
    }