import java.net.URL;
import java.net.URLClassLoader;
import java.security.Permission;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class java_16861_XMLParser_A03 {

    private URLClassLoader classLoader;

    public java_16861_XMLParser_A03(String jarFilePath) throws IOException {
        // Create an array of URLs for the jar file.
        URL[] urls = new URL[]{new File(jarFilePath).toURI().toURL()};

        // Create a URLClassLoader that uses the given URLs.
        classLoader = new URLClassLoader(urls);
    }

    public void parse(String xmlFilePath) throws Exception {
        try (ZipFile zipFile = new ZipFile(xmlFilePath);
             ZipInputStream zipInputStream = zipFile.getInputStream(new ZipEntry("path_to_xml_file"))) {
            // Create a new class loader for the zip file and add the zip file to it.
            ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();
            classLoader = new URLClassLoader(parentClassLoader.getURLs()) {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException, IOException {
                    try (InputStream is = zipInputStream) {
                        return super.findClass(name);
                    }
                }

                @Override
                public Enumeration<URL> getResources(String name) throws IOException {
                    return zipFile.getEntries().stream()
                            .filter(entry -> entry.getName().equals(name))
                            .map(zipFile::getEntry)
                            .map(this::toURL)
                            .iterator();
                }

                private URL toURL(ZipEntry entry) throws IOException {
                    return entry.getInputStream();
                }
            };

            Thread.currentThread().setContextClassLoader(classLoader);

            // Now you can load classes using classLoader.loadClass().
            Class<?> clazz = classLoader.loadClass("com.example.MyXMLParser");
            Method method = clazz.getDeclaredMethod("parse", String.class);
            method.invoke(clazz, "file:///path_to_xml_file");
        }
    }
}