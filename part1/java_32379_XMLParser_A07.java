import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32379_XMLParser_A07 extends DefaultHandler {
    private Stack<String> elements = new Stack<>();

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_file.xml";
        new XMLParser().parse(xmlFilePath);
    }

    public void parse(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(xmlFile, this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, String version) {
        elements.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        elements.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementContent = new String(ch, start, length).trim();
        if (!elementContent.isEmpty()) {
            System.out.println(elements.peek() + ": " + elementContent);
        }
    }
}