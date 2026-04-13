import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_42113_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Element : " + nNode.getNodeName());
            }
            dBuilder.detachDocument();
            dbFactory.setXIncludeSchemaResolver(null);
        } catch (Exception e) {
            System.out.println("Parsing failed, Reason : " + e.getMessage());
       
        }
    }
}