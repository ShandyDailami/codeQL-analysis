import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_17863_XMLParser_A03 {
    private DefaultHandler handler;
    private XMLParser parser;
    private Stack<String> elementStack;

    public java_17863_XMLParser_A03(File xmlFile) {
        handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                elementStack.push(qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (!elementStack.isEmpty()) {
                    elementStack.pop();
                }
            }
        };

        try {
            parser = new XMLLoader(xmlFile);
            parser.setContentHandler(handler);
            parser.parse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stack<String> getElementStack() {
        return elementStack;
    }
}