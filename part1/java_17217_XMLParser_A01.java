import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_17217_XMLParser_A01 {
    
    public static void main(String[] args) {
        try {
            String fileName = "sample.xml";  // replace with your XML file
            parseFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void parseFile(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            InputStream inputStream = new FileInputStream(fileName);
            Document document = builder.parse(inputStream);
            
            document.getDocumentElement().normalize();
            
            List<Node> nodes = document.getChildNodes();
            for (int i = 0; i < nodes.size(); i++) {
                printNode(nodes.get(i));
            }
            
            inputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printNode(Node node) {
        if (node.hasChildNodes()) {
            List<Node> childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.size(); i++) {
                printNode(childNodes.get(i));
            }
        }
        System.out.println(node.getNodeName() + " : " + node.getTextContent());
    }
}