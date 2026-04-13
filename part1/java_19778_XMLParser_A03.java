import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_19778_XMLParser_A03 extends DefaultHandler {
    private String thisElement;
    private List<String> list;

    public java_19778_XMLParser_A03() {
        list = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (thisElement.equals("tagName")) {
            // Check for command injection attacks here
            if (content.contains("<script>")) {
                System.out.println("Detected command injection attack!");
            } else {
                list.add(content);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    public List<String> getList() {
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLParser.parse("src/main/resources/input.xml", new MyXMLHandler());
        List<String> list = new MyXMLHandler().getList();
        for (String s : list) {
            System.out.println(s);
        }
    }
}