import java.net.*;
import java.io.*;
import java.util.*;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.MessageState;
import javax.security.auth.mechanism.*;
import javax.security.auth.mechanism.callback.CallbackHandler;
import javax.security.auth.mechanism.callback.UnavailableCallbackException;

public class java_29522_SocketServer_A07 {
    private static final String USER_PROMPT = "Username:";
    private static final String PASSWORD_PROMPT = "Password:";

    private final String USER = "admin";
    private final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        // Create and configure a new server socket
        ServerSocketFactory ssf = (ServerSocketFactory) Class.forName("javax.net.ssl.SSLServlet")
                .getMethod("getServerSocketFactory", null).invoke(null);
        SSLServerSocket sss = (SSLServerSocket) ssf.createServerSocket(8080, 100, false, false);
        sss.setNeedClientAuth(true);

        // Create a callback handler for handling the client's authentication
        CallbackHandler callbackHandler = new CallbackHandler() {
            public MessageInfo callback(MessageState msgState,
                    Object requestor, CallbackHandler callbackHandler,
                    MessageInfo request) throws AuthException, UnavailableCallbackException {
                if (request instanceof UsernamePasswordCallback) {
                    return (MessageInfo) new MessageState();
                } else {
                    return (MessageInfo) new AuthException("Unsupported callback");
                }
            }
        };

        sss.setClientAuth(callbackHandler);

        // Main server loop
        while (true) {
            Socket socket = sss.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            // Start a thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_29522_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Error setting up I/O for connection from " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                out.println("Username: admin, Password: password");
                out.flush();

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (IOException e) {
                System.err.println("Error handling client " + socket.getRemoteSocketAddress());
                e.printStackTrace();
           
            } finally {
                try { socket.close(); } catch (IOException e) { /* nothing */ }
            }
        }
    }
}