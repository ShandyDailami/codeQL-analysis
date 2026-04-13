import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_23137_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("country");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder2 = dbFactory2.newDocumentBuilder();
                Document doc2 = dBuilder2.parse(new File("input.xml"));
                doc2.getDocumentElement().normalize();
                System.out.println("Country: "
                        + doc2.getElementsByTagName("name").item(temp).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}