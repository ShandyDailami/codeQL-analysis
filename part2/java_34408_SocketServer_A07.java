import java.io.*;
import java.net.*;
import java.util.*;

public class java_34408_SocketServer_A07 {
    private static final int PORT = 1234;
    private static final String AUTH_FAILURE_MSG = "Auth Failure";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals(AUTH_FAILURE_MSG)) {
                        out.println("Auth Failure");
                    } else {
                        out.println("Server received: " + message);
                    }
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}