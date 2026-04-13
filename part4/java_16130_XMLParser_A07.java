import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16130_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new DefaultHandler());
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            saxParser.setContentHandler(new BasicHandler() {
                public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                        throws SAXException {
                    if (qName.equals("username") || qName.equals("password")) {
                        // Here, we are checking for the 'username' or 'password' element.
                        // You can add more conditions as per your requirement.
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equals("username") || qName.equals("password")) {
                        // You can do further operations with these values
                        System.out.println("Username: " + localName);
                        System.out.println("Password: " + localName);
                    }
                }
            });
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(new File(xmlFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}