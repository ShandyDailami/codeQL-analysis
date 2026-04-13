import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11278_XMLParser_A07 extends DefaultHandler {
    private List<String> elements;

    public List<String> getElements() {
        return elements;
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);
        MyXMLParser myXMLParser = new MyXMLParser();
        saxParser.parse(new File("src/main/resources/example.xml"), myXMLParser);

        // Printing the elements from the XML file
        for (String element : myXMLParser.getElements()) {
            System.out.println(element);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        elements.add(qName);
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("SAXParseException: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}