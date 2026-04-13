import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_34666_XMLParser_A03 {
    public void parseXML(String filePath) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();

            XMLReader xr = saxParser.getXMLReader();

            // Create a new instance of MyHandler
            MyHandler mh = new MyHandler();
            xr.setContentHandler(mh);

            // Parse the XML file
            xr.parse(new InputSource(new File(filePath)));

            // Print out the results
            for (String s : mh.getResults()) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer sbf;
    private List<String> results;

    public java_34666_XMLParser_A03() {
        sbf = new StringBuffer();
        results = new ArrayList<>();
    }

    @Override
    public void startDocument() {
        sbf.setLength(0);
    }

    @Override
    public void endDocument() {
        // Do nothing
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        sbf.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Here we're only interested in the root element
        if (qName.equals("root")) {
            results.add(sbf.toString());
        } else {
            sbf.append(qName);
        }
    }

    public List<String> getResults() {
        return results;
    }
}