import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_03064_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = dBuilder.parse(new StreamSource(new File(xmlFile)));
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element eElement = (Element) nList.item(temp);

            System.out.println("Element : " + eElement.getTagName());
            System.out.println("Attribute : " + eElement.getAttribute("id"));
            System.out.println("Value : " + eElement.getFirstChild().getNodeValue());
        }

        validateXML(doc);
    }

    private static void validateXML(Document doc) {
        ValidatorFactory factory = ValidatorFactory.newInstance();
        Validator validator = factory.newValidator();
        StreamSource xmlSource = new StreamSource(new File("sample.xsd")); // replace with your xml schema file

        try {
            validator.validate(xmlSource);
            System.out.println("Validation Successful!");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("output.xml")); // replace with your output file

        try {
            transformer.transform(source, result);
            System.out.println("XML transformed successfully.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}