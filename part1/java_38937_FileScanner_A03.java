import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class java_38937_FileScanner_A03 {
    private static final Set<String> IGNORED_EXTENSIONS = new HashSet<>(Arrays.asList("class", "h", "hpp", "h++", "c", "cc", "cpp", "c++", "m", "mm", "hm", "java"));
    private static final Pattern INJECTION_PATTERN = Pattern.compile(".*(System\\.|java\\.|javas|javasemi|javax\\.|org\\.|com\\.).*");

    public static void main(String[] args) {
        File directory = new File(".");
        listFiles(directory, "");
    }

    private static void listFiles(File directory, String prefix) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return IGNORED_EXTENSIONS.contains(name.substring(name.lastIndexOf(".") + 1));
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, prefix + file.getName() + "/");
                } else {
                    if (file.getName().endsWith(".java") && INJECTION_PATTERN.matcher(file.getName()).matches()) {
                        System.out.println(prefix + file.getName());
                    }
                }
            }
        }
    }
}