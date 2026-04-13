import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_35754_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(File inputFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try (InputStream input = new FileInputStream(inputFile)) {
            Document doc = dBuilder.parse(input);

            doc.getDocumentElement().normalize();

            printElements(doc.getElementsByTagName("*"));
        }
    }

    public static void printElements(org.w3c.dom.NodeList nodeList) {
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Element elem = (Element) nodeList.item(temp);
            printElement(elem);
        }
    }

    public static void printElement(Element elem) {
        System.out.println("Element name: " + elem.getTagName());
        System.out.println("Attributes:");
        for (int i = 0; i < elem.getAttributes().getLength(); i++) {
            System.out.println(" - " + elem.getAttributes().item(i).getNodeName() + ": " + elem.getAttributes().item(i).getTextContent());
        }
    }
}