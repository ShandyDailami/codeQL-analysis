import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamException;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_30839_XMLParser_A01 {

    public static void main(String[] args) throws IOException, XMLStreamException {

        String xmlFilePath = "/path/to/your/xml/file.xml";
        File xmlFile = new File(xmlFilePath);

        SAXParser saxParser = SAXParser.newInstance();
        XMLReader xmlReader = saxParser.getXMLReader();

        SAXEventHandler saxEventHandler = new DefaultHandler() {

            Stack<String> elementStack = new Stack<>();

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                elementStack.push(qName);
                printIndentation();
                System.out.println(qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                elementStack.pop();
                printIndentation();
                System.out.println(qName);
            }

            private void printIndentation() {
                for (int i = 0; i < elementStack.size(); i++) {
                    System.out.print("--");
                }
                System.out.println();
            }
        };

        xmlReader.setContentHandler(saxEventHandler);

        xmlReader.parse(xmlFile);
    }
}