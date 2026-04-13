import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_18320_XMLParser_A08 extends DefaultHandler {

    private String currentElementName;

    public java_18320_XMLParser_A08() {
        currentElementName = "";
    }

    public void startElement(String uri, String localName, String qName, String version) {
        currentElementName = qName;
    }

    public void characters(char[] ch, int start, int length) {
        if (currentElementName != null && currentElementName.equalsIgnoreCase(localName)) {
            System.out.println("Value: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlParser());
            reader.parse(new File("src/main/resources/data.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}