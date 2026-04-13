import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04255_XMLParser_A07 {

    private static final String URL = "http://example.com/books.xml";
    private static final String XPATH = "/books/book";

    public static void main(String[] args) {
        parseXML();
    }

    private static void parseXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new URL(URL).openStream());
            document.getDocumentElement().normalize();

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            XPathExpression expression = xpath.compile(XPATH);
            List<String> books = (List<String>) expression.evaluate(document, XPathConstants.NODESET);

            for (String book : books) {
                System.out.println("Book: " + book);
            }

        } catch (ParserConfigurationException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}