import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_24015_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XMLStreamReader parser = XMLStreamReaderFactory.createXMLStreamReader(xml.getBytes());

        while (parser.hasNext()) {
            XMLStreamToken nextToken = parser.nextToken();
            switch (nextToken.getTokenType()) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Start of element: " + parser.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.print(parser.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + parser.getLocalName());
                    break;
            }
        }
    }
}