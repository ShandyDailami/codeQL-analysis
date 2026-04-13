import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_14947_XMLParser_A03 extends DefaultHandler {
    private static final String ROOT = "root";
    private static final String NAME = "name";
    private static final String AGE = "age";

    private Stack<String> elementStack = new Stack<>();
    private String currentElement = ROOT;
    private String name = null;
    private int age = 0;

    public void startDocument() {
        System.out.println("Start document");
    }

    public void endDocument() {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);

        if (qName.equals(NAME)) {
            this.name = attributes.getValue(0);
        } else if (qName.equals(AGE)) {
            this.age = Integer.parseInt(attributes.getValue(0));
        } else {
            currentElement = qName;
            System.out.println("Start element " + currentElement);
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (elementStack.peek().equals(currentElement)) {
            elementStack.pop();
            if (qName.equals(NAME)) {
                System.out.println("End element " + currentElement + " Name: " + this.name);
            } else if (qName.equals(AGE)) {
                System.out.println("End element " + currentElement + " Age: " + this.age);
            }
        } else {
            System.out.println("End element " + currentElement);
        }
        currentElement = elementStack.peek();
    }

    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (elementStack.peek().equals(currentElement) && currentElement.equals(NAME)) {
            System.out.println("Character value " + value + " for element " + currentElement);
        }
    }
}