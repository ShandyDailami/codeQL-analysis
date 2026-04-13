import java.io.File;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_04967_XMLParser_A03 {

    public static void parse(String xmlFilePath) throws Exception {
        File xmlFile = new File(xmlFilePath);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Remove the following line and add your own logic for handling XML data
        // saxParser.parse(xmlFile, new MyHandler());

        // This is a placeholder for MyHandler, you should replace it with your own logic
        class MyHandler implements javax.xml.parsers.ContentHandler {
            @Override
            public void startDocument() {
                System.out.println("Start document");
            }

            @Override
            public void endDocument() {
                System.out.println("End document");
            }

            @Override
            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Characters: " + content);
            }
        }

        saxParser.parse(xmlFile, MyHandler.class.newInstance());
    }

    public static void main(String[] args) {
        try {
            parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}