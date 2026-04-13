import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_41917_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/config.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));

            // Print the XML document elements
            printDocument(doc);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printDocument(Document doc) {
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Print all the attributes of the document element
        System.out.println("Attributes:");
        doc.getDocumentElement().normalize();
        for (int i = 0; i < doc.getDocumentElement().getAttributes().getLength(); i++) {
            System.out.println(doc.getDocumentElement().getAttributes().item(i).getNodeName() + "=" +
                    doc.getDocumentElement().getAttributes().item(i).getNodeValue());
        }

        // Print the text inside the document element
        System.out.println("Text: " + doc.getDocumentElement().getTextContent());
    }
}