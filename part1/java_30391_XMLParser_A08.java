import java.util.Stack;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_30391_XMLParser_A08 {
    private Stack<String> tags = new Stack<>();

    public void parse(String file) throws Exception {
        // Load the XML file
        InputStream input = new FileInputStream(new File(file));

        // Create a SAX parser
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Listen for errors
        reader.setErrorHandler(new ErrorHandler() {
            public void error(SAXException e) {
                System.err.println("Error: " + e);
            }

            public void fatalError(SAXException e) {
                System.err.println("Fatal error: " + e);
            }

            public void warning(SAXWarning e) {
                System.err.println("Warning: " + e);
            }
        });

        // Parse the XML file
        reader.setContentHandler(new ContentHandler() {
            public void startDocument() {}

            public void endDocument() {}

            public void startElement(String uri, String localName, String qName) {
                tags.push(qName);
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                if (qName.equals(tags.peek())) {
                    tags.pop();
                    System.out.println("End element: " + qName);
                }
            }

            public void characters(char[] ch, int start, int length) {}
        });

        // Parse the XML file
        while (reader.read()) {}

        input.close();
    }

    public static void main(String[] args) {
        try {
            new XmlParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}