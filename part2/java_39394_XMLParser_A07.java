import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class java_39394_XMLParser_A07 {

    private static final String AUTH_FAILURE_EXCEPTION = "A07_AuthFailure";
    private static final Map<String, String> tagMap = new HashMap<>();
    private static final Stack<String> tagStack = new Stack<>();

    public java_39394_XMLParser_A07() {
        tagMap.put("<a>", "</a>");
        tagMap.put("<b>", "</b>");
        tagMap.put("<i>", "</i>");
        tagMap.put("<u>", "</u>");
        tagMap.put("<font>", "</font>");
        tagMap.put("<br>", "</br>");
    }

    public String parse(String xml) throws SecurityException {
        StringBuilder text = new StringBuilder();
        StringBuilder tag = new StringBuilder();
        boolean inside = false;

        for (char c : xml.toCharArray()) {
            if (c == '<') {
                if (inside) {
                    text.append(tag.toString());
                    tag.setLength(0);
                }
                tag.append('<');
                inside = true;
            } else if (c == '>') {
                if (inside) {
                    tag.append('>');
                    text.append(tagMap.get(tag.toString()));
                    tag.setLength(0);
                    inside = false;
                }
            } else if (inside) {
                tag.append(c);
            }
        }

        if (inside) {
            throw new SecurityException(AUTH_FAILURE_EXCEPTION);
        }

        return text.toString();
    }

    public static void main(String[] args) {
        try {
            String xml = "<a><b>Test</b><i>Testing</i><u>Tested</u><font>Testing Font</font><br/>Test Line Break</a>";
            XmlParser parser = new XmlParser();
            System.out.println(parser.parse(xml));
        } catch (SecurityException e) {
            System.out.println("Security exception caught: " + e.getMessage());
        }
    }
}