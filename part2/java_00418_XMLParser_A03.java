import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00418_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml"); // replace with your file path

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            SaxHandler saxHandler = new SaxHandler();

            saxParserFactory.setValidating(false);
            saxParserFactory.setNamespaceAware(false);
            saxParserFactory.setXIncludeSchemaResolver(null);
            saxParserFactory.setXSD(null);

            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new java.io.FileReader(xmlFile)));
            saxParser.setProperty("class", "org.xml.sax.parser.SAXParser");

            saxParser.parse(new org.xml.sax.InputSource(new java.io.FileReader(xmlFile)), saxHandler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SaxHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean nameFound = false;
    private boolean ageFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            this.nameFound = true;
        } else if (qName.equalsIgnoreCase("age")) {
            this.ageFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.nameFound) {
            System.out.println("Name: " + new String(ch, start, length));
            this.nameFound = false;
        } else if (this.ageFound) {
            System.out.println("Age: " + new String(ch, start, length));
            this.ageFound = false;
        }
    }
}