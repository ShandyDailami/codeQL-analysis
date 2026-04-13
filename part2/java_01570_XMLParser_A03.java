import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_01570_XMLParser_A03 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, NoSuchAlgorithmException {
        String xmlFile = "sample.xml";
        String xpathExpression = "/bookstore/book[price>20]";

        parseXmlWithXpath(xmlFile, xpathExpression);
    }

    private static void parseXmlWithXpath(String xmlFile, String xpathExpression) throws ParserConfigurationException, SAXException, NoSuchAlgorithmException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(getResourceAsBytes(xmlFile));

        String xmlFileHash = Base64.getEncoder().encodeToString(md.digest());

        Document document = builder.parse(new File(xmlFile));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

        Iterator iterator = nodes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTextContent());
        }
    }

    private static byte[] getResourceAsBytes(String resourceName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resourceName);

        if (inputStream != null) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            return buffer;
        } else {
            throw new Exception("Resource not found: " + resourceName);
        }
    }
}