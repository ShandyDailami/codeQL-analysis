import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14527_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse("input.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;
    private String currentTag;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
        if(qName.equalsIgnoreCase("person")){
            bName = true;
            bAge = true;
        }
        else if(bName && qName.equalsIgnoreCase("name")){
            bName = false;
        }
        else if(bName && qName.equalsIgnoreCase("age")){
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName){
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;
        }
        else if(bAge){
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}