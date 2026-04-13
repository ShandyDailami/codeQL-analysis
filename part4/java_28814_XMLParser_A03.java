import java.util.Stack;
import java.util.HashMap;

public class java_28814_XMLParser_A03 {
    private Stack<String> tags = new Stack<>();
    private HashMap<String, String> attributes = new HashMap<>();

    public void parse(String xml) {
        int start = 0;
        int end = 0;

        while (end < xml.length()) {
            if (xml.charAt(end) == '<') {
                start = end;
                while (end < xml.length() && xml.charAt(end) != '>') {
                    end++;
                }
                String tag = xml.substring(start + 1, end);
                tags.push(tag);
            } else if (xml.charAt(end) == '\'') {
                while (end < xml.length() && xml.charAt(end) != '\'') {
                    end++;
                }
            } else if (xml.charAt(end) == '"') {
                while (end < xml.length() && xml.charAt(end) != '"') {
                    end++;
                }
            }

            if (end < xml.length() && xml.charAt(end) == ' ') {
                String attrName = xml.substring(start + 1, end);
                while (end < xml.length() && xml.charAt(end) != '>') {
                    end++;
                }
                String attrValue = xml.substring(end + 1, end + 1);
                attributes.put(attrName, attrValue);
            }

            end++;
        }

        while (!tags.isEmpty()) {
            String tag = tags.pop();
            // handle tag and attributes
        }
    }
}