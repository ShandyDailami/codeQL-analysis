import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileNotFoundException;

public class java_31288_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printData(doc);
        } catch (Exception e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }

    private static void printData(Document doc) {
        NodeList nList = doc.getElementsByTagName("book");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("Book " + (temp + 1) + ":");
            Element e = (Element) node;
            System.out.println("Title: " + e.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Price: " + e.getElementsByTagName("price").item(0).getTextContent());
            System.out.println("Author: " + e.getElementsByTagName("author").item(0).getTextContent());
            System.out.println("======================================");
        }
    }
}