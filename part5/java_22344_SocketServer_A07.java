import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class java_22344_SocketServer_A07 {

    private static final String KEY = "12345678abcdefgh"; // This should be a secure random string

    public static class AuthCallback implements CallbackHandler {
        public Subject authenticate(Subject subject) throws IOException {
            return subject;
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8181);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            Handshake handshake = new Handshake(socket);
            handshake.startHandshake();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Decrypt the input stream and output stream
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY, "AES"));
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

            // Start the secure communication
            SecureServerHandler serverHandler = new SecureServerHandler(cipherOutputStream);
            new Thread(serverHandler).start();
        }
    }
}