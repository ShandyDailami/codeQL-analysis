import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_02559_XMLParser_A03 {
    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    if ("person".equals(elementName)) {
                        System.out.println("Found start element: " + elementName);
                        if (reader.getAttributeValue(null, "id") != null) {
                            System.out.println("Found attribute: id");
                        }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    System.out.println("Found end element: " + elementName);
                    break;
                case XMLStreamConstants.CHARS:
                    String charData = reader.getText();
                    System.out.println("Found text: " + charData);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamConstants.createXMLEventReader(new StringReader("<people>\n" +
                "<person id=\"1\">\n" +
                "<name>John</name>\n" +
                "<age>30</age>\n" +
                "</person>\n" +
                "<person id=\"2\">\n" +
                "<name>Mary</name>\n" +
                "<age>28</age>\n" +
                "</person>\n" +
                "</people>"));

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Found start document");
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("Found end document");
                    break;
                default:
                    break;
            }
        }

        reader.close();
    }
}