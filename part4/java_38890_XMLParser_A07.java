import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38890_XMLParser_A07 extends DefaultHandler {

    private boolean bName = false;
    private boolean bValue = false;
    private String currentValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            bName = true;
        } else if(qName.equalsIgnoreCase("value")){
            bValue = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName){
            String s = new String(ch, start, length);
            System.out.println("Name: " + s);
            bName = false;
        } else if(bValue){
            String s = new String(ch, start, length);
            System.out.println("Value: " + s);
            bValue = false;
            currentValue = s;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.setProperty("http://xml.apache.org/xsl/properties/Security/authFailure", "false");
        try {
            parser.parse(new File("path_to_your_xml_file"), new MyXMLHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}