import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_16136_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "sample.xml";
        String newData = "<book><title>Great Expectations</title><author>Charles Dickens</author></book>";

        // Step 1: Parse the XML file
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Step 2: Modify the XML file
            NodeList nList = doc.getElementsByTagName("book");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;

            Node newDataNode = doc.createElement("book");
            eElement.appendChild(newDataNode);

            Node newTitleNode = doc.createElement("title");
            Node newAuthorNode = doc.createElement("author");

            newTitleNode.setTextContent("Great Expectations");
            newAuthorNode.setTextContent("Charles Dickens");

            newDataNode.appendChild(newTitleNode);
            newDataNode.appendChild(newAuthorNode);

            // Step 3: Write to the XML file
            FileWriter writer = new FileWriter(fileName);
            doc.write(writer);
            writer.close();

            System.out.println("Successfully updated XML file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}