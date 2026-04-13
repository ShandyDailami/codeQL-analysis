import java.io.*;
import java.net.*;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

public class java_41505_SocketServer_A01 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start SASL conversation
            SaslClient saslClient = SaslClient.getInstance("MyClient");
            Subject subject = new Subject("MyRealm", "MyQop", null, null, null);
            saslClient.login(subject, USERNAME, PASSWORD, new CallbackHandler() {
                @Override
                public void handle(Callback[] callbacks) throws UnsupportedCallbackException, SaslException {
                    // No callbacks needed
                }
            });

            // Send welcome message
            out.write("Welcome to the server\n".getBytes());

            // Send message to client
            out.write("Message to client\n".getBytes());

            // Close connection
            out.write("Connection closed\n".getBytes());
            socket.close();
        }
    }
}