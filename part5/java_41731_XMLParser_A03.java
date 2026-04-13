import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_41731_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a document builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load XML file
            Document doc = builder.parse(getResourceAsStream("sample.xml"));

            // Create an XPath factory
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            // XPath expression to select nodes
            String expression = "/books/book";

            // Select all book nodes
            NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            // Security-sensitive operations related to Injection
            // This is a simple example where we print out the title of all books.
            // In a real-world application, you would likely want to replace this with more complex logic.
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(nodes.item(i).getChildNodes().item(0).getNodeValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getResourceAsStream(String resource) {
        ClassLoader classLoader = SecureXMLParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IllegalArgumentException("Could not find resource '" + resource + "'");
        }
        return inputStream;
    }
}