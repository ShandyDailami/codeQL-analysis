import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiMarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_15823_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file";
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Setting up a handler
            MyHandler myHandler = new MyHandler();

            // Parsing
            InputStream inputStream = new FileInputStream(xmlFile);
            saxParser.parse(inputStream, myHandler);
            inputStream.close();

            // Print out the result
            System.out.println("Successfully parsed the XML file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler to handle the XML document
    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        boolean bId = false;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of XML Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of XML Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("<person> found");
                bName = true;
                bAge = true;
                bId = true;
                return;
            }

            if (bName) {
                System.out.print("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.print(", Age: " + localName);
                bAge = false;
            } else if (bId) {
                System.out.print(", ID: " + localName);
                bId = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("</person> found");
                return;
            }
        }
    }
}