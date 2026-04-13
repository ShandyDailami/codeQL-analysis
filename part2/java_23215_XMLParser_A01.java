import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_23215_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        File xml = new File(xmlFile);

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(new InputSource(new FileReader(xml)));
            saxParser.setEntityHandler(new DefaultHandler() {
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            });

            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader();
            xmlReader.setContentHandler(saxParser);

            xmlReader.parse(new File(xmlFile));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}