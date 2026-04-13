import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_39229_XMLParser_A08 extends DefaultHandler {

    private boolean isInElement = false;
    private String currentElement = "";

    public java_39229_XMLParser_A08() {
        super();
    }

    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) {
        isInElement = true;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            String elementContent = new String(ch, start, length).trim();
            if (!elementContent.isEmpty()) {
                System.out.println(currentElement + ": " + elementContent);
            }
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLParser());
            reader.parse(new File("src/main/resources/sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}