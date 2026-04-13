import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_27678_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // input file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("").item(0).getNodeName());
            NodeList nodeList = doc.getElementsByTagName("country");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("-------------------------------------------");
                Node node = nodeList.item(temp);
                System.out.println("Country Name: " + node.getChildNodes().item(1).getNodeValue());
                System.out.println("Population: " + node.getChildNodes().item(3).getNodeValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}