import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35122_XMLParser_A07 {

    private static final String XPATH_EXPR = "/root/data/item[@id='authFailure']/failure";

    public static void main(String[] args) {
        parseXML("/path/to/your/xml/file.xml");
    }

    public static void parseXML(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFilePath);
            doc.getDocumentElement().normalize();

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(XPATH_EXPR);

            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            List<String> authFailures = new ArrayList<>();
            for (int i = 0; i < nodes.getLength(); i++) {
                authFailures.add(nodes.item(i).getTextContent());
            }

            // Perform security sensitive operations with the authFailures list here
            // For example, print all the failures
            for (String failure : authFailures) {
                System.out.println("Failure: " + failure);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}