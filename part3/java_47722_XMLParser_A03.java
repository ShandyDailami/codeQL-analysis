import java.net.*;

import javax.xml.* ;

import org.xml.sax.*;    // For the API for parsing and generating documents (SAX) 

import org.xml.sax.helpers.* ;     // Helper classes needed by SAX  

public class java_47722_XMLParser_A03 implements ContentHandler {     

       private String thisElement = "";           

        public void startDocument() throws SAXException{ System . out . println ( "start document" ) } 

         @Override   

          public void endDocument(){System.out.println("End of Document");}  

           @Override    

             public void startElement(String uri, String localName ,     

              String qName ,Attributes atts) throws SAXException { thisElement =qName; } 

            // When we get a partical element name (localname), it will print the text within.  

               @Override     public void endElement(String uri, String localName,      

                String qName )throws SAXException{thisElement="";}   

                  @Override      // Printing content of an Element for testing 

                   public void characters(char ch[], int start ,int length) throws     SSAEXception { System.out . print ( thisElement + " : ");       char [] temp = new char [length+1] ;   

                    for (int i = 0;i <length;i++ )   temp [i]=ch[start+i];  temp [length]='\u0000';     System . out . print(new String (temp)); }      // End of ContentHandler methods}        public static void main (String [] args) throws ParserException, SAXException {      

         XMLReader xr =XMLReaderFactory.createNonThreadedReader();  xr.setContentHandler((ContentHandler ) new     XMLParserExample());    XMLEventReader evt_reader=      evemtsetup(new File("C:\\Users\Documents\_java_\samplefile2149360875XML")); 

            while (evt_reade .hasNext()){xr.nextEvent();}     } // Main method where it's all said and done!   try { XMLParserExample xp = new      XMLParserException("This is a test");             XMLEventFactory evemtsetup=XMLEventFactory; 

           docs setup(new File ("C:\\Users\Documents\_java_\samplefile2149360875XML")); } catch (IOException ex) { System.out . println("error setting up the XMLReader... ");       // Error handling here ...} }}` 

This is a very basic example and real world xml parsing tasks would require much more sophisticated solution such as using JAXP, DOM or StAX APIs etc for greater control over how to handle parsed data. Please note that you should replace "C:\\Users\Documents\_java_\samplefile2149360875XML" with the actual path of xml file which needs parsing and it also must be a secure location because this XMLParserExample program is reading from an untrusted source to prevent injection attacks.