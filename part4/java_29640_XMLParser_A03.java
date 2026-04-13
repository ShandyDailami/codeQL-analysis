import java.io.StringReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_29640_XMLParser_A03 {
    public static void main(String[] args) throws XMLStreamException {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XMLStreamReader parser = new XMLStreamReader(new StringReader(xml));

        while (parser.hasNext()) {
            int event = parser.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String element = parser.getLocalName();
                    System.out.println("Start of element: " + element);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String character = parser.getText();
                    System.out.print(character);
                    break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("Comment: " + parser.getComments());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End of element: " + parser.getLocalName());
                    break;
            }
        }

        parser.close();
    }
}