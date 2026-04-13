import java.io.*;
import java.net.*;
import javax.security.auth.*;

public class java_33405_SocketServer_A07 {

    private static final String AUTH_PROVIDER = "MyApp";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        while (true) {
            Socket socket = server.accept();
            new HandleSocket(socket);
        }
    }

    private static class HandleSocket extends Thread {
        private Socket socket;
        public java_33405_SocketServer_A07(Socket s) {
            socket = s;
            start();
        }
        public void run() {
            try {
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                AuthRequest authRequest = (AuthRequest) new AuthRequest();
                AuthResult authResult = authRequest.authenticate(socket, AUTH_PROVIDER, USER_NAME, PASSWORD);
                if (authResult.authenticated) {
                    out.write("Welcome to my secure server!\n".getBytes());
                } else {
                    out.write("Auth failed\n".getBytes());
                    socket.close();
               
                }
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}