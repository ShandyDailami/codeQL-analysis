import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_06356_XMLParser_A03 {

    private List<String> dataList = new ArrayList<>();
    private StringBuffer buffer = new StringBuffer();

    class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                buffer.setLength(0);
            } else if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                bAge = false;
            } else if (bAge && qName.equalsIgnoreCase("name")) {
                buffer.append("Name: ").append(attributes.getValue("name")).append(", ");
                bAge = false;
            } else if (bAge && qName.equalsIgnoreCase("age")) {
                buffer.append("Age: ").append(attributes.getValue("age")).append(" ");
                dataList.add(buffer.toString());
            }
        }
    }

    public List<String> parse(String fileName) throws Exception {
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();
        saxParser.parse(fileName, myHandler);
        return dataList;
    }

    public static void main(String[] args) {
        try {
            SAXParserExample parser = new SAXParserExample();
            List<String> data = parser.parse("people.xml");
            for (String person : data) {
                System.out.println(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}