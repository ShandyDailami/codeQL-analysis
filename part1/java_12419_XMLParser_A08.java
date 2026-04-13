import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import com.sun.org.apache.xerces.internal.parsers.SAXParserFactory;

public class java_12419_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        String xmlFile = "books.xml";
        File file = new File(xmlFile);

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        InputStream inputStream = new FileInputStream(file);
        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        saxParser.parse(inputStream, defaultHandler);
    }
}