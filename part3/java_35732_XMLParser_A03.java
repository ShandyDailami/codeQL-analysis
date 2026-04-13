import java.io.StringReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamToken;

public class java_35732_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget me this weekend!</body>" +
                "</note>";

        XMLStreamReader parser = createParser(xml);

        int event;
        try {
            while ((event = parser.next()) != XMLStreamReader.END_DOCUMENT) {
                if (event == XMLStreamReader.START_ELEMENT) {
                    System.out.println("Start Element: " + parser.getLocalName());
                } else if (event == XMLStreamReader.END_ELEMENT) {
                    System.out.println("End Element: " + parser.getLocalName());
                } else if (event == XMLStreamReader.CHARACTERS) {
                    System.out.println("Characters: " + parser.getText());
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLStreamReader createParser(String xml) {
        return new XMLStreamReader(new StringReader(xml));
    }
}