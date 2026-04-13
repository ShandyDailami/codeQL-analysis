import java.io.StringReader;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamTokenizer;

public class java_20613_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        parse(xml);
    }

    private static void parse(String xml) {
        try {
            XMLEventReader reader = createXMLStreamReader(xml);
            String namespace = reader.getNamespaceURI(0);
            QName eventType = new QName(namespace, "note");
            int depth = 0;

            System.out.println("Parsing XML document");
            while (reader.hasNext()) {
                XMLStreamTokenizer tokenizer = reader.nextToken();

                if (tokenizer.getEventType() == XMLStreamTokenizer.START_ELEMENT) {
                    depth++;
                    String elementName = tokenizer.getName().getLocalPart();
                    System.out.printf("%s/%s (depth: %d)\n", getIndentation(depth), elementName, depth);
                } else if (tokenizer.getEventType() == XMLStreamTokenizer.END_ELEMENT) {
                    depth--;
                    String elementName = tokenizer.getName().getLocalPart();
                    System.out.printf("%s<%s> (depth: %d)\n", getIndentation(depth), elementName, depth);
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static XMLEventReader createXMLStreamReader(String xml) {
        return new XMLEventReader(new StringReader(xml));
    }

    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }
        return indentation.toString();
    }
}