import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.enters.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_38505_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParser saxParser = SAXParser.newInstance();

        try {
            SAXReader saxReader = saxParser.getSAXReader();
            XMLReader xmlReader = saxReader.getXMLReader();

            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String elementContent = new String(ch, start, length);
                    System.out.println("Element content: " + elementContent);
                }
            };

            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}