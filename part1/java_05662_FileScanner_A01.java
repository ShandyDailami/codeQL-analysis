import java.io.*;
import java.util.*;

public class java_05662_FileScanner_A01 {

    private static final String DELIMITER = File.separator;

    private static final String[] WHITE_LIST = {"images", "documents", "audio", "video"};
    private static final Set<String> WHITE_LIST_SET = new HashSet<>(Arrays.asList(WHITE_LIST));

    private static final String[] PROTECTED_PATHS = {"protected" + DELIMITER};
    private static final Set<String> PROTECTED_PATHS_SET = new HashSet<>(Arrays.asList(PROTECTED_PATHS));

    private static final String[] RESERVED_NAMES = {".", ".."};
    private static final Set<String> RESERVED_NAMES_SET = new HashSet<>(Arrays.asList(RESERVED_NAMES));

    public static void main(String[] args) {
        File rootDir = new File(".");
        scanDirectory(rootDir);
    }

    private static void scanDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file);
            } else {
                if (isFileSafe(file)) {
                    System.out.println("Safe file: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        if (file.isHidden() || isProtected(file.getPath()) || isReserved(file.getName())) {
            return false;
        }
        String lowerCaseName = file.getName().toLowerCase();
        if (lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg")) {
            return true;
        }
        return false;
    }

    private static boolean isProtected(String path) {
        String[] paths = path.split(DELIMITER);
        for (String p : paths) {
            if (PROTECTED_PATHS_SET.contains(p)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isReserved(String name) {
        for (String reservedName : RESERVED_NAMES_SET) {
            if (reservedName.equals(name)) {
                return true;
            }
        }
        return false;
    }
}