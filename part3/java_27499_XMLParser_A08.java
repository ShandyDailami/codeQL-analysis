import java.util.Stack;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_27499_XMLParser_A08 {
    private File file;
    private XMLStreamReader xmlReader;

    public java_27499_XMLParser_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void parse() {
        try {
            xmlReader = XMLReaderFactory.createXMLStreamReader(new FileInputStream(file));
            Stack<String> stack = new Stack<>();

            xmlReader.setEventHandler(new DefaultHandler() {
                public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
                    stack.push(qName);
                }

                public void endElement(String namespaceURI, String localName, String qName) {
                    if (stack.peek().equals(qName)) {
                        stack.pop();
                    }
                }
            });

            while (xmlReader.hasNext()) {
                int type = xmlReader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String elementName = xmlReader.getLocalName();
                    System.out.println("Start Element: " + elementName);
                } else if (type == XMLStreamConstants.END_ELEMENT) {
                    String elementName = xmlReader.getLocalName();
                    System.out.println("End Element: " + elementName);
                }
            }

            xmlReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("example.xml");
        parser.parse();
    }
}