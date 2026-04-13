// import necessary libraries
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_08506_XMLParser_A01 {

    public static void main(String[] args) {
        // create a new instance of XMLReader
        XMLReader reader = XMLReader.newInstance();

        // create a new instance of DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // handle start element
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                // handle end element
                System.out.println("End element: " + qName);
           
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                // handle characters
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            // parse the XML file
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader("<a><b>content</b></a>")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}