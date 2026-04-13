import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_07596_XMLParser_A01 extends DefaultHandler {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        File xmlFile = new File("path_to_your_xml_file.xml");

        try {
            XMLReader xmlReader = reader.getXMLReader();
            xmlReader.setContentHandler(new XMLParser());
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Element content: " + new String(ch, start, length));
    }
}