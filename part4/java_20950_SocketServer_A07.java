import java.io.*;
import java.net.*;
import java.util.*;

public class java_20950_SocketServer_A07 {

    private static final String SERVER_PORT = "1234";
    private static final String AUTH_KEY = "SECRET_AUTH_KEY";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(SERVER_PORT));
            System.out.println("Server started at port: " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg;
                while ((clientMsg = in.readLine()) != null) {
                    if (clientMsg.equals(AUTH_KEY)) {
                        out.writeBytes("Authorized\n");
                    } else {
                        out.writeBytes("Not Authorized\n");
                    }
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}