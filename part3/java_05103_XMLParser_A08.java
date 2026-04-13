import java.util.Stack;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_05103_XMLParser_A08 {

    public static void parse(XMLStreamReader reader) throws XMLStreamException {
        Stack<String> stack = new Stack<>();
        String elementName = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    elementName = reader.getLocalName();
                    stack.push(elementName);
                    System.out.print(elementName);
                    break;

                case XMLStreamReader.CHARACTERS:
                    System.out.print(": " + reader.getText());
                    break;

                case XMLStreamReader.END_ELEMENT:
                    elementName = stack.pop();
                    System.out.println("</" + elementName + ">");
                    break;
            }
        }
    }

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader reader = XMLStreamConstants.createXMLStreamReader(args[0]);
        parse(reader);
    }
}