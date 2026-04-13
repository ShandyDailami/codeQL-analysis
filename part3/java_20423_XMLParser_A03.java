import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.StringTableHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class java_20423_XMLParser_A03 {
    private Set<String> uniqueNames = new HashSet<>();

    public Set<String> getUniqueNames() {
        return uniqueNames;
    }

    public void parse(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            StringTableHandler handler = new StringTableHandler(xmlFile.getName());
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
            uniqueNames = handler.getStringTable().entrySet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("src/main/resources/example.xml");
        Set<String> uniqueNames = parser.getUniqueNames();
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}