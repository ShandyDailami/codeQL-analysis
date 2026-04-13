import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import java.io.File;

public class java_31855_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            XMLParser parser = XMLReader.newInstance();
            DefaultHandler handler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };
            parser.setContentHandler(handler);
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}