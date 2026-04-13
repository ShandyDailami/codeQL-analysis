import java.io.*;
import java.net.*;
import java.util.*;

public class java_31120_SocketServer_A07 {
    private static final String AUTH_USER = "admin";
    private static final String AUTH_PWD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readLine();
            System.out.println("Received from client: " + clientMsg);

            String[] clientInfo = clientMsg.split(" ");
            String user = clientInfo[0];
            String password = clientInfo[1];

            if (user.equals(AUTH_USER) && password.equals(AUTH_PWD)) {
                out.writeBytes("Connection Successful\n");
            } else {
                out.writeBytes("Connection Failed\n");
                socket.close();
                continue;
            }

            out.writeBytes("Connection Successful\n");
        }
    }
}