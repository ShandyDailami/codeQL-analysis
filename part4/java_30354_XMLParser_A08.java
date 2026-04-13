import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_30354_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<person>" +
                "  <name>John</name>" +
                "  <age>25</age>" +
                "  <city>New York</city>" +
                "</person>";

        XMLStreamReader reader = XMLStreamReader.newReader(new StringReader(xml));

        try {
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamReader.START_ELEMENT) {
                    String elementName = reader.getLocalName();
                    if (elementName.equals("person")) {
                        System.out.println("Found person element");
                    } else if (elementName.equals("name")) {
                        System.out.println("Found name element");
                    } else if (elementName.equals("age")) {
                        System.out.println("Found age element");
                    } else if (elementName.equals("city")) {
                        System.out.println("Found city element");
                    }
                }
            }
        } finally {
            reader.close();
        }
    }
}