import java.io.File;
import java.util.regex.Pattern;

public class java_21053_FileScanner_A01 {
    private static final Pattern BLOCKED_NAMES = Pattern.compile("(?i)^(backup|delete|download|edit|logs|movies|music|settings|update|video)$");
    private static final Pattern BLOCKED_EXTENSIONS = Pattern.compile("(?i)^(jpg|jpeg|png|gif|pdf|docx|xlsx|pptx|txt)$");

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        String extensionToBlock = "jpg";

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equalsIgnoreCase(extensionToBlock)) {
                    if (!BLOCKED_NAMES.matcher(file.getName()).matches() &&
                        !BLOCKED_EXTENSIONS.matcher(file.getName().substring(file.getName().lastIndexOf(".") + 1)).matches()) {
                        System.out.println("Blocked file: " + file.getPath());
                    }
                }
            }
        }
    }
}