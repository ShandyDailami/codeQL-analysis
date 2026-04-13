import java.io.File;

public class java_37104_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        scanDirectory(directory, 0);
    }

    private static void scanDirectory(File directory, int level) {
        if (level == 0) {
            System.out.println("---------------------");
        }
        System.out.println(getSpaces(level) + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, level + 1);
                } else {
                    System.out.println(getSpaces(level) + "- " + file.getName());
                }
            }
        }
    }

    private static String getSpaces(int level) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < level; i++) {
            spaces.append("  ");
        }
        return spaces.toString();
    }
}