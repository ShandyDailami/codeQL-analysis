import java.util.List;

public class java_23824_XMLParser_A07 {
    public List<String> parse(String xml) {
        // The responsibility of parsing is not only security sensitive
        // but also about processing the XML data.

        // Let's imagine we have the following XML:
        // <people>
        //     <person>John Doe</person>
        //     <person>Jane Smith</person>
        // </people>

        // Now, let's parse the XML and extract the names
        List<String> names = new java.util.ArrayList<>();
        int start = xml.indexOf("<person>") + 8;
        int end = xml.indexOf("</person>") - 8;

        while (start != -1 && end != -1) {
            names.add(xml.substring(start, end));
            start = xml.indexOf("<person>", end) + 11;
            end = xml.indexOf("</person>", end) - 8;
        }

        return names;
    }
}