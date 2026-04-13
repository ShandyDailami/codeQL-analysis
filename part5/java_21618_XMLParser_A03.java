import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_21618_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        String injectionAttempt = "<script>alert('Injection Attempt!')</script>";
        writeToXml(fileName, injectionAttempt);
    }

    public static void writeToXml(String fileName, String injectionAttempt) {
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            doc.setXmlStandalone(true);
            doc.getSettings().setXmlStandalone(true);

            doc.getDocumentElement().appendChild(doc.newTextNode(injectionAttempt));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter(fileName));
            transformer.transform(source, result);

            System.out.println("Xml file has been saved with XML Injection!");

        } catch (ParsingException e) {
            e.printStackTrace();
       
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}