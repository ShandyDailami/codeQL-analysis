import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class java_27623_XMLParser_A01 {

    public static void main(String[] args) {
        // Parse XML using SAX Parser
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            saxParser.parse("input.xml", new MyHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Parse XML using DocumentBuilder
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Student name: " + eElement.getAttribute("name"));
                    System.out.println("Student id: " + eElement.getAttribute("id"));
                    System.out.println("Student age: " + eElement.getAttribute("age"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements SAXHandler {

        boolean bName = false;
        boolean bId = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equals("student")) {
                bName = true;
                bId = true;
                bAge = true;

                System.out.println("Start Element: " + qName);
                return;
            }

            if (bName && qName.equals("name")) {
                bName = false;
                System.out.println("Name: " + attributes.getValue(0));
            } else if (bId && qName.equals("id")) {
                bId = false;
                System.out.println("Id: " + attributes.getValue(0));
            } else if (bAge && qName.equals("age")) {
                bAge = false;
                System.out.println("Age: " + attributes.getValue(0));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do nothing
        }
    }
}