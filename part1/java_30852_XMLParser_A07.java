import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class java_30852_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file";  // Replace with your xml file path
        String elementXPath = "/your/xml/path";  // Replace with your xpath

        try {
            File xmlFile1 = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile1);
            doc.getDocumentElement().normalize();

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            XPathExpression expr = xpath.compile(elementXPath);
            NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nl.getLength(); i++) {
                Element element = (Element) nl.item(i);
                System.out.println("Element Value: " + element.getFirstChild().getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}