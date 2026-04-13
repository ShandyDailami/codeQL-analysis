import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_33859_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml"; // Update with your file path
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        try {
            Document document = documentBuilder.parse(new File(xmlFilePath));

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(document.getDocumentElement());
            MyHandler myHandler = new MyHandler();

            saxParser.setContentHandler(myHandler);
            saxParser.parse(document.getDocumentElement(), myHandler);

            // Transform the document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean contentFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            } else if (qName.equalsIgnoreCase("content")) {
                contentFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
                nameFound = false;
            } else if (contentFound) {
                System.out.println("Content: " + new String(ch, start, length));
                contentFound = false;
            }
        }
    }
}