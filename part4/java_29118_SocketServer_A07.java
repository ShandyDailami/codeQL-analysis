import java.net.*;
import java.io.*;
import java.security.*;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;

public class java_29118_SocketServer_A07 {

    public static class MyAuthHandler implements CallbackHandler {

        public Subject doCallback(Subject subject) {
            // Do something here
            return subject;
        }

        public String getCallerPrincipal() {
            return "user";
        }

        public String getPassword() {
            return "password";
        }

        public boolean commits() {
            return true;
        }

        public boolean aborts() {
            return true;
        }
    }

    public static class MyCallbackHandler implements CallbackHandler {

        public Subject doCallback(Subject subject) {
            return subject;
        }

        public String getCallerPrincipal() {
            return "user";
        }

        public String getPassword() {
            return "password";
        }

        public boolean commits() {
            return true;
        }

        public boolean aborts() {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {

        SocketServerExample server = new SocketServerExample();
        server.startServer(8080);
    }

    public void startServer(int port) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new SocketServerExample.MyCallbackHandler().doCallback(new Subject(true, false, false));
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}