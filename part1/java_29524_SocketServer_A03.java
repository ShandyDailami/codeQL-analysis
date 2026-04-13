import java.io.*;
import java.net.*;

public class java_29524_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                break;
            }

            out.writeBytes("Hello Client, you sent: " + message + "\n");
            out.flush();
        }

        server.close();
    }
}