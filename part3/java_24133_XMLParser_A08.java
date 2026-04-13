import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_24133_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // replace with your file path
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true); // enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Security-Sensitive Operations related to A08_IntegrityFailure
        // 1. Validating the XML Document:
        validateDocument(doc);

        // 2. Scanning the XML Document for potential threats:
        scanDocument(doc);

        // 3. Validating the XML Element:
        validateElement(doc.getDocumentElement());
    }

    private static void validateDocument(Document doc) {
        try {
            List<Element> elements = doc.getElementsByTagName("*");
            Iterator<Element> it = elements.iterator();
            while (it.hasNext()) {
                Element element = it.next();
                if (!element.hasAttribute("id") || !element.hasAttribute("name")
                        || element.getAttribute("id").isEmpty() || element.getAttribute("name").isEmpty()) {
                    System.out.println("Security alert: Missing attribute in element: " + element.getTagName());
                }
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    private static void scanDocument(Document doc) {
        try {
            List<Element> elements = doc.getElementsByTagName("*");
            Iterator<Element> it = elements.iterator();
            while (it.hasNext()) {
                Element element = it.next();
                if (!element.hasAttribute("src") || element.getAttribute("src").isEmpty()) {
                    System.out.println("Security alert: Missing attribute in element: " + element.getTagName());
                }
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    private static void validateElement(Element element) {
        if (!element.hasAttribute("id") || !element.hasAttribute("name")
                || element.getAttribute("id").isEmpty() || element.getAttribute("name").isEmpty()) {
            System.out.println("Security alert: Missing attribute in element: " + element.getTagName());
        }
    }
}