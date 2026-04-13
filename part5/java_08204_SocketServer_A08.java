import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08204_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000, 100, InetAddress.getByName("localhost"));
            System.out.println("Server started at port 6000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equals("integrity failure")) {
                        System.out.println("Integrity failure detected in message: " + message);
                        writer.println("Integrity failure detected");
                        writer.flush();
                    } else {
                        System.out.println("Received message: " + message);
                        writer.println("Received message: " + message);
                        writer.flush();
                    }
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}