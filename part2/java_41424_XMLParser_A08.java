import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_41424_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your XML file path
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(file));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        printElement(doc.getDocumentElement(), 1);
    }

    private static void printElement(Element element, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        System.out.println("Element: " + element.getNodeName() + " (" + element.getNodeType() + ")");

        if (element.hasAttributes()) {
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                System.out.print("  Attribute: " + element.getAttributes().item(i).getNodeName() + "=" + element.getAttributes().item(i).getNodeValue());
            }
        }

        if (element.hasChildNodes()) {
            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                printElement((Element) element.getChildNodes().item(i), indentation + 1);
            }
        }
    }
}