import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_37301_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            InputStream input = new FileInputStream(inputFile);
            SAXHandler handler = new SAXHandler();

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            // parse XML file
            Document document = reader.getDocument();
            Element root = document.getDocumentElement();
            printElement(root);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element name: " + element.getNodeName());
        Iterator iterator = element.getAttributes().iterator();
        while (iterator.hasNext()) {
            Element attr = (Element) iterator.next();
            System.out.println("Attribute name: " + attr.getNodeName() + ", value: " + attr.getNodeValue());
        }

        Iterator childIter = element.getChildNodes().iterator();
        while (childIter.hasNext()) {
            Element child = (Element) childIter.next();
            printElement(child);
        }
    }
}

class SAXHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
        Iterator iterator = attributes.iterator();
        while (iterator.hasNext()) {
            org.xml.sax.Attribute attr = (org.xml.sax.Attribute) iterator.next();
            System.out.println("Attribute name: " + attr.getName() + ", value: " + attr.getValue());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }
}