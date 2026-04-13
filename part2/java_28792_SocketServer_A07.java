import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28792_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                OutputStream out = socket.getOutputStream();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.write(("Hello client, you connected to server\n").getBytes());
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}