import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_26740_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // your xml file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(new File(xmlFile));
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();

                try {
                    Document doc1 = dBuilder1.parse(new File(xmlFile));
                    doc1.getDocumentElement().normalize();

                    System.out.println("Student ID : " + doc1.getElementsByTagName("id").item(temp).getTextContent());
                    System.out.println("Student Name : " + doc1.getElementsByTagName("name").item(temp).getTextContent());

                    NodeList studentInfo = doc1.getElementsByTagName("info");

                    for (int j = 0; j < studentInfo.getLength(); j++) {
                        System.out.println("Info : " + studentInfo.item(j).getTextContent());
                    }
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                } catch (SAXException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}