import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;

public class java_34148_XMLParser_A07 {

    public static void main(String[] args) {

        // XML content
        String xmlContent = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        // Create XMLStreamReader
        XMLStreamReader streamReader = null;

        try {
            streamReader = XMLStreamConstants.createXMLStreamReader(xmlContent);
        } catch (XMLStreamException e1) {
            e1.printStackTrace();
        }

        // Parsing XML
        try {
            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + streamReader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(streamReader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element: " + streamReader.getLocalName());
                        break;
                    default:
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}