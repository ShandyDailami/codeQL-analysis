import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_21590_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_xml_file.xml"); // replace with your xml file
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(xmlFile));

            saxParser.setProperty( "http://xml.org/sax/properties/external-generalized-element", "true" );
            DefaultHandler defaultHandler = new DefaultHandler(){
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) {
                    System.out.println("Characters: " + new String(ch, start, length));
                }

                public void fatalError(SAXException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }

                public void warning(SAXException e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            };
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(new org.xml.sax.InputSource(xmlFile));
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}