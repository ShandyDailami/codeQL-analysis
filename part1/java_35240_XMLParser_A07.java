import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_35240_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Extract data from the XML document
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            // Security-sensitive operations
            String expression = "/A07_AuthFailure/@failure";
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Failure: " + node.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}