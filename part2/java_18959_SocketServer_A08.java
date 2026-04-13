import java.io.*;
import java.net.*;

public class java_18959_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);

        while (true) {
            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                if (message.equals("quit")) {
                    out.writeBytes("Bye!\n");
                    socket.close();
                    break;
                } else {
                    out.writeBytes("Hello, client!\n");
                }

                out.flush();
            }

            socket.close();
        }
    }
}