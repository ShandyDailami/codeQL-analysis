import java.io.File;
import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiMarshaller;

public class java_11363_XMLParser_A07 {

    public static void main(String[] args) {
        SAXHelper saxHelper = new SAXHelper();
        DefaultHandler defaultHandler = new DefaultHandler();

        // Parse the XML file
        try {
            saxHelper.setContentHandler(defaultHandler);
            saxHelper.parse(new File("your_xml_file.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Extract the value of the tag "tag_name"
        List<String> tagValues = defaultHandler.getStringList();
        if (tagValues != null && tagValues.size() > 0) {
            System.out.println("Tag Values: " + tagValues.toString());
        }
    }
}