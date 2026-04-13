import java.util.ArrayList;
import java.util.List;

public class java_40634_XMLParser_A08 {
    public List<String> parse(String xml) {
        List<String> tags = new ArrayList<>();
        StringBuilder currentTag = new StringBuilder();
        boolean tagOpen = false;

        for (char c : xml.toCharArray()) {
            if (c == '<') {
                tagOpen = true;
                currentTag.setLength(0);
            } else if (c == '>') {
                tagOpen = false;
                tags.add(currentTag.toString());
            } else if (tagOpen) {
                currentTag.append(c);
            }
        }
        return tags;
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        String xml = "<tags>Hello, world</tag1><tag2>Hello again</tag2>";
        List<String> tags = parser.parse(xml);
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}