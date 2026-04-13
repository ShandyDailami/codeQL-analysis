import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06256_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(xmlFile, MyHandler.myContext);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        public static StringBuilder xmlData = new StringBuilder();
        public static MyContext myContext = new MyContext();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            xmlData.append("Start element : ").append(qName).append("\n");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            xmlData.append("End element : ").append(qName).append("\n");
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            xmlData.append("Character data : ").append(new String(ch, start, length)).append("\n");
        }
    }

    static class MyContext extends SAXContext {
        @Override
        public Object getCurrentNode() {
            return MyHandler.xmlData;
        }
    }
}