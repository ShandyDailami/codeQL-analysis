import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;
import java.io.File;
import java.io.IOException;

public class java_10497_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        SAXDriver driver = null;
        XMLReader reader = null;

        try {
            driver = new SAXDriver(xmlFile, true);
            reader = XMLReaderFactory.createXMLReader();
            driver.setContentHandler(reader);

            System.out.println("Element names:");
            reader.setContentHandler(new ElementHandler());
            reader.parse(new File(xmlFile.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (SAXException e) {
                e.printStackTrace();
            }
            try {
                if (driver != null) {
                    driver.close();
                }
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}

class ElementHandler implements ContentHandler {
    private boolean isInElement = false;
    private String currentElement = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }
}