import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_12920_XMLParser_A08 {
    private Stack<String> elementStack = new Stack<String>();

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse("src/test.xml");
    }

    public void parse(String file) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler() {
                public void startDocument() throws SAXParseException {
                    System.out.println("Start Document");
                }

                public void endDocument() throws SAXParseException {
                    System.out.println("End Document");
                }

                public void startElement(String namespaceURI, String localName,
                        String qualifiedName, Attributes attributes) throws SAXException {
                    System.out.print("Start Element: ");
                    elementStack.push(qualifiedName);
                    printIndent();
                    System.out.println(qualifiedName);
                }

                public void endElement(String namespaceURI, String localName,
                        String qualifiedName) throws SAXException {
                    elementStack.pop();
                    printIndent();
                    System.out.println("End Element: " + qualifiedName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    printIndent();
                    System.out.println("Characters: " + new String(ch, start, length));
                }

                private void printIndent() {
                    for (int i = 0; i < elementStack.size(); i++) {
                        System.out.print("--");
                    }
                    System.out.println();
                }
            });
            reader.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}