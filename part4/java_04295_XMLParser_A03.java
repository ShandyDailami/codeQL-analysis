import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_04295_XMLParser_A03 extends DefaultHandler {
    private String lastElement;
    private List<String> dataList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equalsIgnoreCase("book")) {
            dataList.add(new String(ch, start, length));
        }
    }

    public List<String> getDataList() {
        return dataList;
    }
}

public class XMLParser {
    public static void main(String[] args) {
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<library>\n" +
                "   <book>\n" +
                "       <title>The Great Gatsby</title>\n" +
                "       <author>F. Scott Fitzgerald</author>\n" +
                "       <year>1925</year>\n" +
                "   </book>\n" +
                "   <book>\n" +
                "       <title>Moby Dick</title>\n" +
                "       <author>Herman Melville</author>\n" +
                "       <year>1851</year>\n" +
                "   </book>\n" +
                "</library>";

        MyXMLHandler handler = new MyXMLHandler();
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xmlData)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String data : handler.getDataList()) {
            System.out.println(data);
        }
    }
}