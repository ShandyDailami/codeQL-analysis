import java.io.*;
import java.net.*;

public class java_03610_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Authentication
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equals("auth")) {
                out.writeBytes("ok\n");
            } else {
                out.writeBytes("failed\n");
            }

            socket.close();
        }
    }
}