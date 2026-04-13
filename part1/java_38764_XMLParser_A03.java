import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38764_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            File inputFile = new File("input.xml");
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            SAXParser saxParser = saxParserFactory.newSAXParser(document.getDocumentElement());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(document, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler implements javax.xml.parsers.ContentHandler {

        boolean bTag = false;
        String str = "";

        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bTag = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bTag = false;
            }

            if (bTag) {
                str += qName + ": " + str + "\n";
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                str += new String(ch, start, length);
            }
        }
    }
}