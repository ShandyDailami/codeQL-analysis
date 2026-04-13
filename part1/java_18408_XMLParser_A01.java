import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_18408_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI().toURL())) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            // Parse the XML file
            saxParser.parse(xmlFile.toURI().toURL(), xmlReader);

            // Display the parsed data
            for (String data : myHandler.getData()) {
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private static final String ROOT = "root";
    private static final String PASSWORD = "password";

    private String currentElement;
    private List<String> data;

    public java_18408_XMLParser_A01() {
        this.data = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        this.currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (ROOT.equals(currentElement)) {
            data.add(attributes.getValue(PASSWORD));
        }
        this.currentElement = null;
    }

    public List<String> getData() {
        return data;
    }
}