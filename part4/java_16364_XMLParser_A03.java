import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_16364_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            File inputFile = new File("input.xml");

            saxParser.parse(inputFile, new XMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    private StringBuilder stringBuilder;

    public java_16364_XMLParser_A03() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        stringBuilder.append("<").append(qName);

        if (attributes.getLength() > 0) {
            stringBuilder.append(" ");
            attributes.asList().stream().forEach(attr -> {
                stringBuilder.append(attr.getName());
                stringBuilder.append("=\"");
                stringBuilder.append(attr.getValue());
                stringBuilder.append("\" ");
            });
        }

        stringBuilder.append("/>");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        stringBuilder.append(new String(ch, start, length));
    }
}