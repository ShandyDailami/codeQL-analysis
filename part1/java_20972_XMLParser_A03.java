import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Policy;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_20972_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.println("Element : " + element.getNodeName());
                System.out.println("Attributes : " + element.getAttributes().getLength());
                for (int i = 0; i < element.getAttributes().getLength(); i++) {
                    System.out.println("Attribute " + (i + 1) + " : " + element.getAttributes().item(i).getNodeName() + " = '" + element.getAttributes().item(i).getNodeValue() + "'");
                }
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}