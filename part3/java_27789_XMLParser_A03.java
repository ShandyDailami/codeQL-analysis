import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_27789_XMLParser_A03 extends DefaultHandler {
    private List<String> dataList;
    private StringBuilder currentValue;
    private String currentElement;

    public java_27789_XMLParser_A03() {
        dataList = new ArrayList<>();
        currentValue = new StringBuilder();
    }

    public List<String> getDataList() {
        return dataList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = new StringBuilder();
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals("Name")) {
            dataList.add(currentValue.toString());
        } else {
            System.out.println("Unexpected element : " + currentElement);
        }
        currentElement = null;
    }
}

import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);
            MyXMLHandler myXMLHandler = new MyXMLHandler();
            saxParser.parse("src/main/resources/example.xml", myXMLHandler);

            List<String> dataList = myXMLHandler.getDataList();
            for (String data : dataList) {
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}