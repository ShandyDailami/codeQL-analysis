import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35515_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXml("src/test.xml");
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }

    public static void parseXml(String fileName) throws AccessControlException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream inputStream = new FileInputStream(fileName)) {

            Document document = builder.parse(inputStream);

            document.getDocumentElement().normalize();

            System.out.println("Root element : " + document.getDocumentElement().getNodeName());

            Iterator<Element> iterator = document.iterateElements();

            while (iterator.hasNext()) {
                Element element = iterator.nextElement();
                System.out.println("Element : " + element.getNodeName());
                System.out.println("Element value : " + element.getFirstChild().getNodeValue());
            }

            try {
                // This will throw an exception if the document is broken
                document.getElementsByTagName("this_tag_does_not_exist").item(0).getFirstChild().getNodeValue();
            } catch (SAXException e) {
                System.out.println("XML was broken");
            }

            // Access is blocked here because the XML Document is not loaded in memory
            // It can be accessed only after the parse is done

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}