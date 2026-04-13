import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_34753_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Creating a new DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Creating a new DocumentBuilder from the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsing the XML file into a Document object
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Getting the document elements
            NodeList nList = doc.getElementsByTagName("student");

            // Creating a new XML file for the new XML Document
            File newFile = new File("new_sample.xml");

            // Creating a new XMLWriter from the new file
            dBuilder.setOutput(newFile);
            Document newDoc = dBuilder.newDocument();

            // Writing the XML into the new document
            newDoc.write(doc);

            // Printing out the XML document
            System.out.println(newDoc.getDom().getFirstChild().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}