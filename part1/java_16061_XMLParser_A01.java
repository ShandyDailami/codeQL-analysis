import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_16061_XMLParser_A01 {

    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        SAXReader reader = SAXReaderFactory.newInstance();
        reader.setContentHandler(handler);
        File inputFile = new File("brokenAccessControl.xml");
        try {
            XMLReader xmlReader = reader.buildReader(new FileInputStream(inputFile));
            xmlReader.parse(new InputSource(new StringReader(inputFile.toString())));
            xmlReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}