import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_36244_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    private static void parseFile(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        List<Element> elements = document.getElementsByTagName("element");

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            System.out.println("Element " + (i + 1) + ": " + element.getTextContent());
        }
    }
}