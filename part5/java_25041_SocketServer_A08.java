import java.io.*;
import java.net.*;
import javax.security.auth.message.callback.*;
import javax.security.auth.*;

public class java_25041_SocketServer_A08 {
    public static void main(String[] args) throws IOException, AuthenticationException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected...");

            // Create callback handler
            CallbackHandler callbackHandler = new CallbackHandler() {
                public AuthCallback[] getCallbacks() {
                    return new AuthCallback[]{
                            new SocketCalligraphicPrincipalCallback()
                    };
                }
            };

            // Perform authentication
            AuthPermission perm = new AuthPermission(AuthPermission.useSubject(true), "");
            callbackHandler.handle(new AuthInfoCallback(new Authenticator() {
                public Object getPassword(String arg0) throws UnknownHostException, AuthenticationException {
                    return "secure password";
                }

                public Object getID(String arg0, String arg1, CallbackHandler arg2) throws UnknownHostException, AuthenticationException {
                    return new SocketCalligraphicPrincipal();
                }
            }));

            System.out.println("Authentication succeeded");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Send response
            dos.writeUTF("Welcome to the server!");
            dos.flush();

            // Close the connection
            client.close();
        }
    }
}