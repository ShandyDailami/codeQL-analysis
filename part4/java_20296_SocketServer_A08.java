import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20296_SocketServer_A08 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is running...");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected!");

                    try (InputStream in = socket.getInputStream();
                         OutputStream out = socket.getOutputStream()) {
                        int request;
                        while ((request = in.read()) != -1) {
                            System.out.println("Client says: " + request);
                            out.write(request);
                            out.flush();
                       
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}