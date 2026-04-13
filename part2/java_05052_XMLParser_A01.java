import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05052_XMLParser_A01 {

    public static void main(String[] args) {

        String filePath = "./resources/example.xml"; // file path

        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Stack<Element> stack = new Stack<Element>();
            printElements(doc, stack);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc, Stack<Element> stack) {
        NodeList nl = doc.getElementsByTagName("*");

        for (int i = 0; i < nl.getLength(); i++) {
            Element el = (Element) nl.item(i);
            stack.push(el);

            printElement(el);

            stack.pop();
       
        }
    }

    private static void printElement(Element el) {
        System.out.println("Element Name: " + el.getTagName());
        System.out.println("Element Text: " + el.getTextContent());

        NodeList nl = el.getElementsByTagName("*");
        for (int i = 0; i < nl.getLength(); i++) {
            Element childEl = (Element) nl.item(i);
            stack.push(childEl);

            printElement(childEl);

            stack.pop();
        }
    }
}