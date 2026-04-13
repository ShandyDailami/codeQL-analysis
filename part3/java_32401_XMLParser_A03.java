import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_32401_XMLParser_A03 {
    
    public static void main(String[] args) {
        File xmlFile = new File("data.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Student");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element eElement = (Element) nList.item(temp);
            
            System.out.println("Student " + (temp + 1));
            System.out.println("ID : " + eElement.getAttribute("id"));
            System.out.println("Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
            System.out.println("Age : " + eElement.getElementsByTagName("Age").item(0).getTextContent());
        }
    }
}