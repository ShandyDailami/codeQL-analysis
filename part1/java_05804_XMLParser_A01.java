import java.awt.List;
import java.awt.print.Book;
import java.io.File;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;

public class java_05804_XMLParser_A01 {

    public void parseXML(String xmlFilePath) {
        try {
            File inputFile = new File(xmlFilePath);
            Source xmlFile = new StreamSource(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getElementsByTagName("root").item(0).getTextContent());
            System.out.println("Child element: " + doc.getElementsByTagName("child").item(0).getTextContent());

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = "/root/child";
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Child node: " + nodeList.item(i).getTextContent());
            }

            // Security-sensitive operation: Modifying the XML file
            File xmlOutputFile = new File("output.xml");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            ResultSet rs = new StreamResult(xmlOutputFile);
            Source xmlSource = new DOMSource(doc);
            transformer.transform(xmlSource, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parseXML("broken_access_control.xml");
    }
}