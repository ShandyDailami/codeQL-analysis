import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_27188_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String xmlFile = "security.xml";
            File inputFile = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("username");

            // Security sensitive operation: Accessing username and password
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                Element eElement = (Element) node;
                String username = eElement.getAttribute("username");
                String password = eElement.getAttribute("password");

                // BrokenAccessControl operation: Accessing password without proper authorization
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Security sensitive operation: Writing to file
            FileWriter fileWriter = new FileWriter("access.log");
            fileWriter.write("Access Log: All access records have been written to access.log");
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}