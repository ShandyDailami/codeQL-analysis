import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_19534_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("input.xml"));

            document.getDocumentElement().normalize();

            System.out.println("Root element : " + document.getDocumentElement().getNodeName());

            ListElement(document);
            XPathFunction(document);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void ListElement(Document document) {
        NodeList nodeList = document.getElementsByTagName("listElement");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String value = element.getAttribute("id");

            System.out.println("listElement id : " + value);
        }
    }

    private static void XPathFunction(Document document) {
        String expression = "/bookstore/book[year>2005]";

        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();

            List results = xpath.evaluate(expression, document, XPathConstants.NODESET);

            NodeList nodeList = (NodeList) results;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Title : " + title);
                System.out.println("Price : " + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}