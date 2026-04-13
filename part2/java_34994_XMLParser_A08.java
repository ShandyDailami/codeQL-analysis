import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;

public class java_34994_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setNamespaceAware(false);
            documentBuilderFactory.setXincludeAware(false);

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            SAXParser saxParser = saxParserFactory.newSAXParser(documentBuilderFactory);

            saxParser.setXmlResolver(new XMLResolver());

            saxParser.parse(new File("sample.xml"), new SAXHandler());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

}

class XMLResolver implements javax.xml.parsers.XMLResolver {

    @Override
    public Object getElementById(String elementId) {
        System.out.println("XMLResolver.getElementById: " + elementId);
        return null;
    }

    @Override
    public void putElement(String elementId, Object element) {
        System.out.println("XMLResolver.putElement: " + elementId);
    }

}