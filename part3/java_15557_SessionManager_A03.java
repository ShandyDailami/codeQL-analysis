import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class java_15557_SessionManager_A03 {
    private static final Map<String, Method> sessionMethods = new HashMap<>();
    private static final Map<String, Method> securityManagerMethods = new HashMap<>();

    static {
        try {
            Class<?> securityManagerClass = Class.forName("java.lang.SecurityManager");
            Method getOperationsMethod = securityManagerClass.getMethod("getOperations");
            Method invokeMethod = securityManagerClass.getMethod("invoke", Method.class);

            Method[] methods = securityManagerClass.getMethods();
            for (Method method : methods) {
                if (method.getName().equals("getOperations")) {
                    securityManagerMethods.put(method.getName(), method);
                } else if (method.getName().startsWith("invoke")) {
                    sessionMethods.put(method.getName().substring("invoke".length()), method);
                }
            }

            Method[] sessionClassMethods = Class.forName("java.util.concurrent.ConcurrentHashMap").getMethods();
            for (Method method : sessionClassMethods) {
                sessionMethods.put(method.getName(), method);
            }

            Method[] sessionManagerClassMethods = Class.forName("java.util.concurrent.ConcurrentHashMap").getMethods();
            for (Method method : sessionManagerClassMethods) {
                sessionMethods.put(method.getName(), method);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void openSession() {
        invokeMethod("openSession");
    }

    public void closeSession() {
        invokeMethod("closeSession");
    }

    private void invokeMethod(String methodName) {
        try {
            Method method = sessionMethods.get(methodName);
            if (method != null) {
                method.invoke(null);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession();
        sessionManager.closeSession();
    }
}