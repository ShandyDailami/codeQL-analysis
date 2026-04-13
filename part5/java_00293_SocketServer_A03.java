import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00293_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = reader.readLine();
                System.out.println("Received message: " + message);

                String response = processMessage(message);

                OutputStream writer = socket.getOutputStream();
                writer.write(response.getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processMessage(String message) {
        if (message.contains("injection")) {
            return "Found injection attempt, aborting.";
        } else {
            return "Processed message: " + message;
        }
    }
}