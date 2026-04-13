import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_35279_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                System.out.println("Initial SessionFactory creation failed.");
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        try {
            for (int i = 0; i < 10; i++) {
                String uniqueData = generateUniqueData();
                SecurityClass securityObject = new SecurityClass();
                securityObject.setUniqueData(uniqueData);
                session.save(securityObject);
            }

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    private static String generateUniqueData() {
        Random random = new Random();
        byte[] uniqueDataBytes = new byte[10];
        random.nextBytes(uniqueDataBytes);

        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        uniqueDataBytes = messageDigest.digest(uniqueDataBytes);
        return bytesToHex(uniqueDataBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return stringBuilder.toString();
    }
}

class SecurityClass {
    private String uniqueData;

    public void setUniqueData(String uniqueData) {
        this.uniqueData = hashData(uniqueData);
    }

    private String hashData(String data) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte[] dataBytes = data.getBytes();
        byte[] hashedBytes = messageDigest.digest(dataBytes);
        return bytesToHex(hashedBytes);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toHexString(0xFF & bytes[i]));
        }
        return stringBuilder.toString();
    }
}