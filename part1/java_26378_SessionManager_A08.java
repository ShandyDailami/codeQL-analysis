import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionContext;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class java_26378_SessionManager_A08 implements javax.servlet.http.HttpSessionContext, HttpSessionBindingListener {
    private HttpSession session;
    private static final String KEY = "A08_IntegrityFailure";

    public java_26378_SessionManager_A08(HttpSession session) {
        this.session = session;
        session.setAttribute("sessionManager", this);
    }

    @Override
    public void valueBound(HttpSessionEvent event) {
        if (session != event.getSession()) {
            return;
        }
        try {
            Key key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            String encryptedData = Base64.getEncoder().encodeToString(cipher.doFinal(session.getId().getBytes()));
            session.setAttribute("encryptedData", encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void valueUnbound(HttpSessionEvent event) {
        if (session != event.getSession()) {
            return;
        }
        try {
            String encryptedData = (String) session.getAttribute("encryptedData");
            Key key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            session.setId(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return this;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // Not implemented
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Not implemented
    }
}