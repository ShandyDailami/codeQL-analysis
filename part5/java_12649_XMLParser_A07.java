import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_12649_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/authfailure.xml";
        File xmlFilePath = new File(xmlFile);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFilePath);

            XMLReader reader = doc.getXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new org.xml.sax.InputSource(new StringReader(doc.getElementsByTagName("user").item(0).getTextContent())));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
            // Add your security sensitive operations here
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
            // Add your security sensitive operations here
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
            // Add your security sensitive operations here
        }
    }
}