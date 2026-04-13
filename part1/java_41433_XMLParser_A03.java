import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;
import org.xml.sax.interfaces.XMLReaderHandler;

public class java_41433_XMLParser_A03 {

    private SAXDriver saxDriver;
    private XMLReaderHandler xmlReaderHandler;

    public java_41433_XMLParser_A03() {
        saxDriver = new SAXDriver();
        xmlReaderHandler = (XMLReaderHandler) XMLReaderFactory.createXMLReaderHandler();
    }

    public void parseXML(String xmlFile) {
        try {
            saxDriver.setDocumentHandler(xmlReaderHandler, 5000);
            saxDriver.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}