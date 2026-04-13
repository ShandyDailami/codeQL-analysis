import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequiresSecurity {}

public class java_02045_SessionManager_A08 {
    public void startSession(String user) {
        System.out.println("Starting session for user: " + user);
    }

    public void endSession(String user) {
        System.out.println("Ending session for user: " + user);
    }
}

public class SecurityManager {
    private static final int MINIMUM_PRIVILEGES = 8;

    public void checkMethodExecution(Object target, String method) {
        Class<?> declaringClass = target.getClass();

        try {
            Method declaredMethod = declaringClass.getDeclaredMethod(method, null);

            if (declaredMethod.getDeclaredAnnotation(RequiresSecurity.class) != null) {
                Object[] params = declaredMethod.getParameterAnnotations();

                if (params != null && params.length > 0) {
                    throw new SecurityException("Method requires security privileges");
                } else {
                    int privileges = declaringClass.getMethod(method, null).getDeclaredAnnotation(RequiresSecurity.class).value();

                    if (privileges < MINIMUM_PRIVILEGES) {
                        throw new SecurityException("Insufficient privileges to execute method");
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println("No such method: " + method + " in class: " + declaringClass.getName());
        }
    }
}