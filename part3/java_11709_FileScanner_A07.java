import java.nio.file.*;

public class java_11709_FileScanner_A07 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        FileScanner fileScanner = new FileScanner() {
            @Override
            public void init(Path rootPath, String includes, String excludes) {
                // Not implemented in this snippet
            }

            @Override
            public boolean visitFile(Path file) {
                System.out.println("File: " + file.toString());
                return true;
            }

            @Override
            public boolean visitLink(Path link) {
                // Not implemented in this snippet
                return true;
            }

            @Override
            public boolean visitQualified() {
                // Not implemented in this snippet
                return true;
            }

            @Override
            public boolean visitFileSet(Path fileSet) {
                // Not implemented in this snippet
                return true;
            }

            @Override
            public boolean visitFileAndDirectoryHeaders(String headers) {
                // Not implemented in this snippet
                return true;
            }

            @Override
            public boolean visitFileAttributeViews(String... views) {
                // Not implemented in this snippet
                return true;
            }

            @Override
            public void end() {
                // Not implemented in this snippet
            }
        };

        fileScanner.scan(start);
    }
}