import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

public class java_24349_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        InputStream inputStream = new FileInputStream("input.xml");
        Document doc = builder.parse(inputStream);

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        String expression = "/Bookstore/Book";

        XPathExpression expr = xpath.compile(expression);
        List<String> bookTitles = new ArrayList<>();

        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            bookTitles.add(nodes.item(i).getTextContent());
        }

        System.out.println("Book Titles: " + bookTitles);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(doc.getDocumentElement().getFirstChild().getNodeValue().getBytes());

        // Remove Comment: Here we are printing the SHA-256 hash of the XML document,
        // which is security-sensitive and we are not sure how to use it.
        // System.out.println(hexFormat(digest));
    }

    private static String hexFormat(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
        }
        return sb.toString();
    }
}