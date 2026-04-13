import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_34829_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get all the 'item' nodes
            NodeList itemList = doc.getElementsByTagName("item");

            // Iterate over each 'item' node
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);

                // Get the value of the 'item' node
                String itemValue = itemNode.getTextContent();

                // Print out the value of the 'item' node
                System.out.println("Item " + (i + 1) + ": " + itemValue);
           
                // Generate a new file for each item
                FileWriter itemFile = new FileWriter("item" + (i + 1) + ".txt");
                itemFile.write("Item " + (i + 1) + ": " + itemValue);
                itemFile.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}