import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_23238_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            printElements(doc);

        } catch (ParsingException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        doc.getElementsByTagName("*").item(0).getFirstChild().normalize();
        Element element = (Element) doc.getElementsByTagName("*").item(0);
        while (element != null) {
            System.out.println("Tag : " + element.getTagName());
            System.out.println("Attributes : " + element.getAttributes());
            System.out.println("Child Nodes : ");
            printElements(element);
            element = element.getNextSibling();
        }
    }
}