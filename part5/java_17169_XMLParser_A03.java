import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_17169_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("input.xml"));
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("tag");

            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                System.out.println("Content of tag: " + node.getTextContent());
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}