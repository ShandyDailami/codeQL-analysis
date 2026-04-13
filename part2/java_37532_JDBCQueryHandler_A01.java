import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class java_37532_JDBCQueryHandler_A01 {

    private BasicDataSource dataSource;
    private QueryRunner queryRunner;

    public java_37532_JDBCQueryHandler_A01() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        queryRunner = new QueryRunner(dataSource);
    }

    public void executeQuery(String query, BeanHandler<?> handler, Object param) {
        try {
            Object result = queryRunner.query(query, handler, param);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        handler.executeQuery("SELECT * FROM users WHERE username = ?", new BeanHandler<>(User.class), "user");
    }
}

class User {
    private String username;
    private String password;

    // getters and setters
}