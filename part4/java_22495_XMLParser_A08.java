import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.util.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_22495_XMLParser_A08 {

    private List<String> dataList = new ArrayList<>();

    public static void main(String[] args) {
        XMLParserExample parserExample = new XMLParserExample();
        parserExample.parseXML("sample.xml");
        parserExample.printData();
    }

    public void parseXML(String fileName) {
        File file = new File(fileName);
        try {
            XMLParser parser = XMLReaderFactory.createXMLParser(
                    file, // source
                    0, // buffered I/O
                    true, // keep external entity references
                    false, // keep comments
                    false, // keep CDATA sections
                    false, // keep processing instructions
                    true, // keep declarations
                    false, // load external DTD
                    true, // load DTD after external DTD
                    false, // load external RNG
                    false, // load RNG after external RNG
                    false // load DTD namespace
            );
            DefaultHandler handler = new DefaultHandler() {
                boolean isName = false;
                boolean isValue = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals("name")) {
                        isName = true;
                    } else if (qName.equals("value")) {
                        isValue = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (isName) {
                        dataList.add("Name: " + new String(ch, start, length));
                        isName = false;
                    } else if (isValue) {
                        dataList.add("Value: " + new String(ch, start, length));
                        isValue = false;
                    }
                }
            };
            parser.setContentHandler(handler);
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        for (String data : dataList) {
            System.out.println(data);
        }
    }
}