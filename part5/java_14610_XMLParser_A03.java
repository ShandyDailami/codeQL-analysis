import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_14610_XMLParser_A03 extends DefaultHandler {

    private String base;
    private Set<String> nodes = new HashSet<>();

    public java_14610_XMLParser_A03(String base) {
        this.base = base;
    }

    public void parse(String file) throws Exception {
        SAXHelper helper = new SAXHelper();
        helper.setDefaultHandler(this);
        helper.parse(new FileInputStream(file));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String node = localName;
        if (!"".equals(node.trim())) {
            nodes.add(node);
        }
    }

    public static void main(String[] args) {
        try {
            new XmlParser("http://example.com/base/").parse("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}