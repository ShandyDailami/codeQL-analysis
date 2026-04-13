import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_26760_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Initialize DocumentBuilderFactory and Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Step 2: Retrieve and print the document elements/nodes
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nStudent Node " + (temp + 1));

                Element eElement = (Element) nNode;

                // Retrieve and print the name and score attributes
                System.out.println("Name: " + eElement.getAttribute("name"));
                System.out.println("Score: " + eElement.getAttribute("score"));
            }

            // Step 3: Close the Document
            doc.close();

            // Step 4: Shows the successful execution of the program
            System.out.println("\nSuccessful execution of the program");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}