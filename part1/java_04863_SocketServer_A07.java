import java.io.*;
import java.net.*;
import javax.security.auth.message.*;

public class java_04863_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected...");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start the authentication process
            BasicCredentialStore credentialStore = new BasicCredentialStore();
            String userName = "user";
            String password = "password";
            credentialStore.add(AuthType.BASIC, userName, password);

            MessageContext messageContext = new MessageContext(credentialStore);
            BasicAuthenticator authenticator = new BasicAuthenticator(messageContext);

            authenticator.setNext(new Authenticator() {
                @Override
                public boolean authenticate(String callingRealm, String username[], String password[]) {
                    // If the username and password match, return true
                    if (username[0].equals(userName) && password[0].equals(password)) {
                        return true;
                    }

                    // Otherwise, return false
                    return false;
                }
            });

            // Send a greeting message
            out.write("Hello, client!\r\n".getBytes());
        }
    }
}