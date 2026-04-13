import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_12461_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            saxParser.parse("src/main/resources/sample.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.ContentHandler {

    private boolean elementFlag;
    private StringBuffer buffer;

    public java_12461_XMLParser_A03() {
        buffer = new StringBuffer();
        elementFlag = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes)
            throws javax.xml.parsers.SAXException {
        elementFlag = true;
        buffer.setLength(0);
        buffer.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        elementFlag = false;
        buffer.append("/");
        buffer.append(qName);
        System.out.println(buffer.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        if(elementFlag){
            buffer.append(ch, start, length);
        }
    }
}