import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class java_40506_SessionManager_A03 {
    private Map<String, Connection> connectionPool = new HashMap<>();
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";

    public java_40506_SessionManager_A03() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(String key) {
        Connection conn = connectionPool.get(key);
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                connectionPool.put(key, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public <T> T proxy(final T target, final String methodName) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces()
        , new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals(methodName)) {
                    return method.invoke(target, args);
                } else {
                    return method.invoke(target);
                }
            }
        });
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        Database db = sm.proxy(new Database(), "insert");
        db.insert();
        db.select();
    }
}