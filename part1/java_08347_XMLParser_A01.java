import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08347_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("note").item(0).getTextContent());
            List<NodeList> nodeList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nodeList.size(); temp++) {
                System.out.println("----------------------------------------");
                System.out.println("Node Type: " + nodeList.get(temp).getNodeType());
                System.out.println("Node Value: " + nodeList.get(temp).item(0).getTextContent());
                System.out.println("----------------------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}