import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

public class java_21955_CredentialValidator_A07 {

    public static void main(String[] args) {
        // Get all provider classes in the current classpath
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Provider[] providers = Security.getProviders();

        System.out.println("Available providers:");

        for (int i = 0; i < providers.length; i++) {
            System.out.println(providers[i].toString());
        }

        // Get all credential provider classes in the current classpath
        Class<?> credentialClasses = Class.forName("java.security.Credential");
        Class<?> credentialClass = Class.forName("java.security.Credential$1");

        // Get all methods in Credential$1
        Method[] credentialMethods = credentialClass.getMethods();

        for (int i = 0; i < credentialMethods.length; i++) {
            Method method = credentialMethods[i];
            System.out.println("Method: " + method.getName());
        }
    }
}