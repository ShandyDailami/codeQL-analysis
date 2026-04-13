import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

public class java_20258_XMLParser_A03 {

    public static void main(String[] args) {
        String inputFile = "employees.xml";
        String outputFile = "employees_new.xml";

        try {
            // Step 1: Parse the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(inputFile));

            // Step 2: Extract and save the information
            NodeList nodeList = document.getElementsByTagName("employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String age = element.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Name: " + name + ", Age: " + age);

                // Step 3: Save the modified XML document
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(Transformer.OutputProperty.INDENT, "yes");
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(outputFile));
                transformer.transform(source, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}