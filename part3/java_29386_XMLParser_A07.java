import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_29386_XMLParser_A07 {

    public void parseXML(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
       
            }
        doc.getDocumentElement().normalize();
        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("authFailure");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\n Authentication Failure Details : ");
            System.out.println("Failing User : " + nNode.getChildNodes().item(1).getTextContent());
            System.out.println("Failing Time : " + nNode.getChildNodes().item(3).getTextContent());
            System.out.println("Failing Reason : " + nNode.getChildNodes().item(5).getTextContent());
        }

    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXML("/path/to/your/xml/file");
    }

}