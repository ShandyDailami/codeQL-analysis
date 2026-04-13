import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_22752_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
                Document doc1 = dBuilder1.parse(new File("input.xml"));
                doc1.getDocumentElement().normalize();

                System.out.println("Student: " + doc1.getElementsByTagName("name").item(temp).getTextContent());
                System.out.println("Grade: " + doc1.getElementsByTagName("grade").item(temp).getTextContent());
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}