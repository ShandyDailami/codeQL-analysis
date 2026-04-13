import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.XMLParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_18543_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // replace this with your xml file path
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new org.xml.sax.InputSource(new FileReader(xmlFile)));

            DefaultHandler dh = new DefaultHandler(){
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            sp.setContentHandler(dh);
            sp.parse(new FileReader(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}