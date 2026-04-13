import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLTokener;
import javax.xml.stream.StAXStreamReader;
import java.io.StringReader;
import java.io.FileReader;

public class java_17395_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xmlData = "<notes>\n" +
                    "    <note>\n" +
                    "        <to>Tove</to>\n" +
                    "        <from>Jani</from>\n" +
                    "        <heading>Reminder</heading>\n" +
                    "        <body>Don't forget me this weekend!</body>\n" +
                    "    </note>\n" +
                    "</notes>";
            parse(xmlData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(String xmlData) throws XMLStreamException {
        XMLTokener xmlTokener = new XMLTokener(new StringReader(xmlData));
        XMLStreamReader streamReader = new StAXStreamReader(xmlTokener);

        int event;
        while (streamReader.hasNext()) {
            event = streamReader.next();
            switch (event) {
                case XMLStreamReader.START_ELEMENT:
                    String element = streamReader.getLocalName();
                    if ("note".equals(element)) {
                        System.out.println("New note");
                    }
                    break;
                case XMLStreamReader.CHARS:
                    String text = streamReader.getText();
                    if ("note".equals(text)) {
                        System.out.println("Note text: " + text);
                    }
                    break;
            }
        }
    }
}