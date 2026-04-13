import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_20326_XMLParser_A07 {
    
    public static class MyHandler extends BasicHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            if(qName.equals("AuthFailure")) {
                System.out.println("Security breach detected. Please contact support.");
            }
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}