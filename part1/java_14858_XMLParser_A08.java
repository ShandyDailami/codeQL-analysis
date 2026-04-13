import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.security.InvalidKeyException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_14858_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseXmlFile("input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fis);

        XPath xpath = XPathFactory.newInstance().newXPath();

        String expression = "/books/book";
        Object result = xpath.evaluate(expression, doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Book " + (i + 1) + ":");
            System.out.println("Title: " + node.getFirstChild().getNodeValue());
            System.out.println("Price: " + node.getNextSibling().getNodeValue());
            System.out.println("--------------------");
        }

        fis.close();
    }

}