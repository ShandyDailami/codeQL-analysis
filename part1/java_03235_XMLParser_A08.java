import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03235_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // Replace with your XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
                Document doc2 = dBuilder2.parse(xmlFile);
                doc2.getDocumentElement().normalize();
                NodeList nodeList2 = doc2.getElementsByTagName("grade");

                for (int i = 0; i < nodeList2.getLength(); i++) {
                    System.out.println("Grade: " + nodeList2.item(i).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}