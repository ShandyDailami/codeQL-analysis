import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_31093_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("src/input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream(inputFile));
            document.getDocumentElement().normalize();

            printElements(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("element");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            String value = element.getAttribute("attribute");
            if ("value".equals(value)) {
                System.out.println("Attribute value: " + element.getAttribute("attribute"));
            }

            printElements(element);
        }
    }
}