import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_02659_XMLParser_A01 {
    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() {
                System.out.println("Start of Document");
            }

            @Override
            public void endDocument() {
                System.out.println("End of Document");
            }

            @Override
            public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
                System.out.println("Start of Element: " + qualifiedName);
            }

            @Override
            public void endElement(String uri, String localName, String qualifiedName) {
                System.out.println("End of Element: " + qualifiedName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            @Override
            public void ignorableWhitespace(char[] ch, int start, int length) {
                System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
            }

            @Override
            public void warning(SAXException e) {
                System.out.println("Warning: " + e.getMessage());
            }

            @Override
            public void error(SAXException e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/main/resources/example.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}