import java.io.*;
import java.net.*;

public class java_33844_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    out.writeBytes("exit\n");
                    break;
                }
                out.writeBytes(message.toUpperCase() + "\n");
            }

            socket.close();
        }
    }
}