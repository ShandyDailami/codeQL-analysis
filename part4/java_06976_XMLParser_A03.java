import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06976_XMLParser_A03 extends DefaultHandler {

    private String fileName;
    private Document doc;
    private boolean isInsideElement;

    public java_06976_XMLParser_A03(String fileName) {
        this.fileName = fileName;
    }

    public void parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            doc = builder.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();
        isInsideElement = true;
        this.startElement("", "", doc.getDocumentElement().getQName(), null);
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName,
                              javax.xml.namespace.QName qNamePrefix) {
        if (isInsideElement) {
            System.out.println("Start of " + qName);
        }
        isInsideElement = true;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (isInsideElement) {
            System.out.println("End of " + qName);
        }
        isInsideElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInsideElement) {
            System.out.println("Text : " + new String(ch, start, length));
        }
    }
}