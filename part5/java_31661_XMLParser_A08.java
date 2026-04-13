import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_31661_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            File inputFile = new File("input.xml");
            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(inputFile, xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    private boolean isStartElement = true;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        isStartElement = true;
        sb.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isStartElement = false;
        if ("item".equals(qName)) {
            System.out.println(sb.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isStartElement) {
            sb.append(ch, start, length);
        }
    }
}