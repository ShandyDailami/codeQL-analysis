import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_00981_XMLParser_A08 extends DefaultHandler {

    private List<String> dataList = new ArrayList<>();
    private StringBuilder currentValue;
    private String currentElementName;
    private boolean isInElement = false;
    private boolean isInCDATA = false;

    public List<String> getDataList() {
        return dataList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            isInElement = true;
            currentElementName = localName;
            currentValue = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            isInElement = false;
            dataList.add(currentElementName + " : " + currentValue.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentValue.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "  <element>Element 1</element>\n" +
                "  <element>Element 2</element>\n" +
                "  <element>Element 3</element>\n" +
                "</root>";

        MyXMLParser parser = new MyXMLParser();
        org.xml.sax.XMLReader reader = org.xml.sax.XMLReader.newInstance();
        reader.setContentHandler(parser);

        try {
            reader.parse(new StringReader(xml));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        List<String> dataList = parser.getDataList();
        for (String s : dataList) {
            System.out.println(s);
        }
    }
}