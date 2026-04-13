import java.io.File;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_33927_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);

            List<String> elements = handler.getElements();
            for (String element : elements) {
                System.out.println(element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.SAXHandler {
    private List<String> elements;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        elements.add(qName);
    }

    public List<String> getElements() {
        return this.elements;
    }
}