import java.security.*;
import java.xml.parsers.*;
import java.io.*;

public class java_09866_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        try {
            // Enable security providers for XML parser
            Security.addProvider(new org.w3c.dom.ls.Security());
            XMLReader xmlReader = XMLReader.create();

            // Parse XML document
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-dtd", false);
            xmlReader.setFeature("http://xml.org/sax/features/validation", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.setFeature("http://xml.org/sax/features/nonvalidating/load-dtd", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces/prefix-resolution", false);

            // Parse XML document
            xmlReader.parse("src/main/resources/authfailure.xml");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}