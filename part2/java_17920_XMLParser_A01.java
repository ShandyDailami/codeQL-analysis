import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_17920_XMLParser_A01 {

    public static void main(String[] args) {
        String inputFile = "input.xml";
        String outputFile = "output.xml";

        try {
            // Read the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(inputFile));

            // Create a new XML file to write the modified data to
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(org.xml.sax.impl.stream.StreamResult.class.getName(),"yes");

            // Modify the XML file
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("tag");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    element.setAttribute("new-attribute", "new-value");
                }
            }

            // Write the modified XML file
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(outputFile));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}