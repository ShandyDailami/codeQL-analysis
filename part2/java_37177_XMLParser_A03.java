import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.parser.SAXParser;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_37177_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(Class.forName("org.xml.sax.SAXParser"));
            SAXHandler handler = new SAXHandler();
            parser.parse(new File("path_to_your_xml_file"), handler);

            List<String> data = handler.getData();
            for (String str : data) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private List<String> data;

    public java_37177_XMLParser_A03() {
        data = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        data.add(qName);
    }

    public List<String> getData() {
        return data;
    }
}