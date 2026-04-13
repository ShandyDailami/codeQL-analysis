import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;
import java.io.IOException;

public class java_22668_XMLParser_A07 {
    
    public static void main(String[] args) {
        try {
            URL url = new File("example.xml").toURI().toURL();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Note: " + temp + " "
                        + nNode.getNodeName());
                Element e = (Element) nNode;
                String noteContent = e.getElementsByTagName("to").item(0).getTextContent();
                String subjectContent = e.getElementsByTagName("from").item(0).getTextContent();
                System.out.println("Note Content: " + noteContent);
                System.out.println("Subject Content: " + subjectContent);
           
            }
            System.out.println("Parsing completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}