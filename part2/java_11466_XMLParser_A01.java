import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_11466_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);

            // Print the name and age of the person
            NodeList personList = document.getElementsByTagName("person");
            for (int i = 0; i < personList.getLength(); i++) {
                Node personNode = personList.item(i);
                Node nameNode = personNode.getElementsByTagName("name").item(0);
                Node ageNode = personNode.getElementsByTagName("age").item(0);
                System.out.println("Name: " + nameNode.getTextContent());
                System.out.println("Age: " + ageNode.getTextContent());
            }

            // Delete the first person
            document.getElementsByTagName("person").item(0).getParentNode().removeChild(document.getElementsByTagName("person").item(0));

            // Save the modified XML document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("output.xml"));
            transformer.transform(source, result);

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}