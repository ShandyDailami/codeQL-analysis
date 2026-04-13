import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_17735_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML document
            File inputFile = new File("employees.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract and print data
            NodeList nList = doc.getElementsByTagName("employee");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);

                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String salary = eElement.getElementsByTagName("salary").item(0).getTextContent();

                System.out.println("Employee Name : " + name + ", Salary : " + salary);
           
            }

            dBuilder = null;
            doc = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}