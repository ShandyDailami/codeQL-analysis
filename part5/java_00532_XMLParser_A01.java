import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.utils.DocumentHelper;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_00532_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("employees.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // normalize the document to make the output easier to read
            document.getDoctype();
            document.normalize();

            // print all employee names
            NodeList employeeList = document.getElementsByTagName("employee");
            for (int i = 0; i < employeeList.getLength(); i++) {
                System.out.println("Employee name: " + employeeList.item(i).getTextContent());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}