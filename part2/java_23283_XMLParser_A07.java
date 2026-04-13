import java.awt.List;
import java.io.File;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_23283_XMLParser_A07 {

    public static void main(String[] args) {
        String fileName = "sample.xml"; // Replace with your file name
        parseXMLFile(fileName);
    }

    private static void parseXMLFile(String fileName) {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        List<Element> elements = new List[1];

        // Loop through all the elements
        Iterator<Element> elementIterator = doc.getElementsByTagName("element").iterator();
        while (elementIterator.hasNext()) {
            Element element = elementIterator.next();
            elements.add(element);
        }

        // Print out each element
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            System.out.println("Element : " + element.getNodeName());
        }
    }
}