import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_24036_XMLParser_A08 extends DefaultHandler {

    private List<String> namespaces = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private List<String> attributes = new ArrayList<>();
    private List<String> text = new ArrayList<>();

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        System.out.println("Start of element: " + qualifiedName);
        this.namespaces.add(uri);
        this.tags.add(localName);
        for(int i=0; i<attributes.getLength(); i++){
            this.attributes.add(attributes.getQualifiedPrefix(i) + ":" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End of element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
        this.text.add(new String(ch, start, length));
    }

    @Override
    public void warning(SAXException warning) {
        System.out.println("Warning: " + warning.getMessage());
    }

    @Override
    public void error(SAXException error) {
        System.out.println("Error: " + error.getMessage());
    }

    @Override
    public void fatalError(SAXException fatalError) {
        System.out.println("Fatal Error: " + fatalError.getMessage());
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();

        // Load your xml file
        // XMLReader reader = DocumentBuilderFactory.newInstance().newDocumentReader(new File("yourfile.xml"));

        // Parse your xml file
        // parser.parse(reader);
    }
}