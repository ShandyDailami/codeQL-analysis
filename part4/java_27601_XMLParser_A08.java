import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27601_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if(qName.equals("person")){
            bName = true;
            bAge = true;
        }
        else if(currentElement.equals("name") && qName.equals("name")){
            bName = true;
        }
        else if(currentElement.equals("age") && qName.equals("age")){
            bAge = true;
        }
        else {
            //do nothing
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";

        if(qName.equals("name")){
            bName = false;
        }
        else if(qName.equals("age")){
            bAge = false;
        }
        else {
            //do nothing
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName){
            //handle name
        }
        else if (bAge){
            //handle age
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MySAXHandler());
            parser.parse(new File("people.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}