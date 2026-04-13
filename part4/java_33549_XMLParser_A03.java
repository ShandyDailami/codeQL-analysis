import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_33549_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {
        private List<String> dataList;
        private String currentElement;

        public java_33549_XMLParser_A03(List<String> dataList) {
            this.dataList = dataList;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            String elementContent = new String(ch, start, length);
            dataList.add(elementContent);
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        MyHandler handler = new MyHandler(new ArrayList<String>());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new FileInputStream(xmlFile)));
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new FileInputStream(xmlFile)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Print the parsed data
        for (String data : handler.dataList) {
            System.out.println(data);
        }
    }
}