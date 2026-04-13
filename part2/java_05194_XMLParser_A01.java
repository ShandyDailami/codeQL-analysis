import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_05194_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            printElement(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Attributes: " + element.getAttributes().getLength());
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println(element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
        }
        System.out.println("Children: " + element.getChildNodes().getLength());
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE && ((Text) element.getChildNodes().item(i)).getNodeValue().trim().length() > 0) {
                System.out.println("Text: " + ((Text) element.getChildNodes().item(i)).getNodeValue().trim());
            } else {
                printElement((Element) element.getChildNodes().item(i));
            }
        }
    }
}