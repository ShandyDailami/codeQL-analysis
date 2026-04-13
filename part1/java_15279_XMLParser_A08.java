import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_15279_XMLParser_A08 extends DefaultHandler {

    private List<String> dataList;
    private StringBuilder currentElementContent;
    private String currentElement;
    private String currentNamespace;
    private boolean isTag = false;
    private boolean isProcessingElement = false;

    public java_15279_XMLParser_A08() {
        dataList = new ArrayList<>();
        currentElementContent = new StringBuilder();
    }

    public List<String> getDataList() {
        return dataList;
    }

    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        isProcessingElement = true;
        currentElement = qualifiedName;
        currentNamespace = uri;
        isTag = true;
        currentElementContent.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        isProcessingElement = false;
        isTag = false;
        if (currentElement.equals("A08_IntegrityFailure")) {
            // Handle integrity failure related to A08_IntegrityFailure here
            System.out.println("Integrity Failure detected in " + currentElement);
        }
        dataList.add(currentElementContent.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isProcessingElement) {
            currentElementContent.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <A08_IntegrityFailure>12345</A08_IntegrityFailure>\n" +
                "    <A08_IntegrityFailure>67890</A08_IntegrityFailure>\n" +
                "</root>";
        XMLParser parser = new XMLParser();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
            for (String data : parser.getDataList()) {
                System.out.println(data);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}