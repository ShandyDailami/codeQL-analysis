import java.util.Stack;

public class java_08609_XMLParser_A03 {

    private Stack<String> tags = new Stack<>();
    private StringBuilder content = new StringBuilder();
    private boolean insideTag = false;

    public String parse(String xml) {
        for (char c : xml.toCharArray()) {
            if (c == '<') {
                if (insideTag) {
                    tags.push(content.toString());
                    content.setLength(0);
                }
                insideTag = true;
                content.append(c);
            } else if (c == '>') {
                if (insideTag) {
                    tags.push(content.toString());
                    content.setLength(0);
                }
                insideTag = false;
                content.append(c);
            } else {
                if (insideTag) {
                    content.append(c);
                }
            }
        }
        if (content.length() > 0) {
            tags.push(content.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!tags.isEmpty()) {
            String tag = tags.pop();
            result.append("</").append(tag).append(">");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        String input = "<name><first>John</first><last>Doe</last></name>";
        String output = parser.parse(input);
        System.out.println(output);
    }
}