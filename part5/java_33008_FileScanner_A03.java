import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_33008_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        Arrays.sort(list);
        for (String name : list) {
            File file = new File(name);
            try {
                String content = FileUtils.readFileToString(file, "UTF-8");
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}