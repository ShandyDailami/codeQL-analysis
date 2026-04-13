import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_41808_XMLParser_A03 extends DefaultHandler {
    private List<String> dataList;
    private StringBuilder content;
    private boolean bTag;
    private String currentElement;

    public java_41808_XMLParser_A03() {
        dataList = new ArrayList<>();
        content = new StringBuilder();
        bTag = false;
    }

    public List<String> getDataList() {
        return dataList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.setLength(0);
        bTag = false;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bTag) {
            if (currentElement.equalsIgnoreCase("element")) {
                dataList.add(content.toString());
            }
            content.setLength(0);
        }
        if (qName.equalsIgnoreCase("root"))
            bTag = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            content.append(ch, start, length);
        }
    }
}