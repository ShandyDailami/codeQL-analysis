import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_17293_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                DocumentBuilderFactory studentDBFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder studentDB = studentDBFactory.newDocumentBuilder();
                Document studentDoc = studentDB.parseString(nList.item(temp).getTextContent());
                studentDoc.getDocumentElement().normalize();
                System.out.println("Student ID: " + studentDoc.getElementsByTagName("id").item(0).getTextContent());
                System.out.println("Student Name: " + studentDoc.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Student Grade: " + studentDoc.getElementsByTagName("grade").item(0).getTextContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}