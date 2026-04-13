import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_04906_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("employee");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element e = (Element) nList.item(temp);
                String name = e.getElementsByTagName("name").item(0).getTextContent();
                String position = e.getElementsByTagName("position").item(0).getTextContent();
                String salary = e.getElementsByTagName("salary").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: " + salary);
            }

            System.out.println("XML Parsing completed successfully!");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}