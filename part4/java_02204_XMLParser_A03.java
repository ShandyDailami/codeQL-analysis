import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class java_02204_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            List<Element> listOfElements = new ArrayList<>();
            listOfElements = parseElements(doc.getElementsByTagName("*"));
            Iterator<Element> iterator = listOfElements.iterator();

            while (iterator.hasNext()) {
                Element element = iterator.next();
                System.out.println("\nElement: " + element.getNodeName());
                System.out.println("Attributes: ");
                NodeList attributes = element.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(attributes.item(i).getNodeName() + " = " + attributes.item(i).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Element> parseElements(NodeList nodeList) {
        List<Element> listOfElements = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                listOfElements.add((Element) nodeList.item(i));
                listOfElements.addAll(parseElements(nodeList.item(i).getChildNodes()));
            }
        }
        return listOfElements;
    }
}