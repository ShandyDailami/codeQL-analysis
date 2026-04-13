import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_30205_XMLParser_A01 extends DefaultHandler {

    private static final String ROOT = "root";
    private static final String NAME = "name";
    private static final String AGE = "age";

    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        stack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(ROOT)) {
            String[] values = buffer.toString().trim().split("\\s+");
            // security sensitive operation: checking if age is valid
            if (values.length == 2 && Integer.parseInt(values[1]) > 18) {
                System.out.println("Access granted for user: " + values[0]);
            } else {
                System.out.println("Access denied for user: " + values[0]);
            }
        } else if (stack.peek().equals(NAME)) {
            String[] values = buffer.toString().trim().split("\\s+");
            // security sensitive operation: checking if name is valid
            if (values.length == 1) {
                System.out.println("User's name is: " + values[0]);
            } else {
                System.out.println("Invalid user's name: " + values[0]);
            }
        } else if (stack.peek().equals(AGE)) {
            String[] values = buffer.toString().trim().split("\\s+");
            // security sensitive operation: checking if age is valid
            if (values.length == 1 && Integer.parseInt(values[0]) > 0 && Integer.parseInt(values[0]) < 120) {
                System.out.println("User's age is: " + values[0]);
            } else {
                System.out.println("Invalid user's age: " + values[0]);
            }
        }
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
}