import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_21466_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("A01_BrokenAccessControl.xml");

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            BrokenAccessControlHandler handler = new BrokenAccessControlHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            handler.getAccessControlList(); // This line will throw an exception if the XML file is not well-formed

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class BrokenAccessControlHandler extends org.xml.sax.helpers.DefaultHandler {
    private String accessControlList;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("access")) {
            accessControlList = attributes.getValue("mode");
        }
    }

    public String getAccessControlList() {
        return accessControlList;
    }
}