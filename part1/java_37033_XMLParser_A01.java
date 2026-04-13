import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_37033_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Extract the data
            XmlRootElement rootElement = doc.getDocumentElement();
            XmlNodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                XmlNode node = nodeList.getNode(i);
                System.out.println("Node " + (i + 1) + ": " + node.getNodeName());
            }

            // Print the data
            System.out.println("Root Node: " + rootElement.getNodeName());

            // Parse the data
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            String expression = "/bookstore/book[title='Book1']";
            XPathExpression xpex = xPath.compile(expression);
            NodeList nodeList2 = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList2.getLength(); i++) {
                Node node = nodeList2.getNode(i);
                System.out.println("Book title: " + node.getFirstChild().getNodeValue());
            }

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}