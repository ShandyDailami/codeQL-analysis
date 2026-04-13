import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Iterator;

public class java_41666_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("*");
            Iterator<?> iterator = nodeList.iterator();
            while(iterator.hasNext()) {
                Element element = (Element) iterator.next();
                System.out.println("Element Name: " + element.getNodeName());
                System.out.println("Element Value: " + element.getFirstChild().getNodeValue());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}