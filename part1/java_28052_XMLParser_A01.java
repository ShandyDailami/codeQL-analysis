import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_28052_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "secure.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        printDocument(document);

        modifyDocument(document);
    }

    private static void printDocument(Document document) {
        System.out.println("Document:");
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());
    }

    private static void modifyDocument(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        try {
            System.out.println("Writing results to the file 'modified.xml'");
            StreamResult result = new StreamResult(new File("modified.xml"));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}