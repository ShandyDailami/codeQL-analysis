import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLLoader.BadLocationException;
import java.io.File;
import java.io.IOException;

public class java_21887_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // replace with your xml file path
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        try {
            XMLParser parser = new SAXParserImpl();
            XMLLoader loader = new XMLLoaderImpl(parser);
            loader.setValidationSchema(new ValidationSchemaImpl());
            loader.setContentHandler(new DefaultHandler() {
                @Override
                public void startDocument() throws SAXException {
                    System.out.println("Starting document");
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("Ending document");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Starting element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Ending element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Reading characters: " + new String(ch, start, length));
                }
            });
            loader.parse(new File(xmlFile));
        } catch (BadLocationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}