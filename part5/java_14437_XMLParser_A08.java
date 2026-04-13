import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_14437_XMLParser_A08 {
    public static void main(String[] args) {
        String file = "input.xml";
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SAXContentHandler(new DefaultHandler()) {
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start of element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    System.out.println("Characters: " + value);
                }

                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("Fatal error: " + e.getMessage());
                }

                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("Warning: " + e.getMessage());
                }
            });

            SAXParserFactory saxParserFactory = new SAXParserFactory();
            SAXParser saxParser = saxParserFactory.newSAXParser(reader);
            saxParser.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}