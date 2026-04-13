import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32843_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // listen on port 8080
            System.out.println("Server started. Listening on port 8080...");

            while (true) { // infinite loop to keep the server running
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);

                    // Send back a response
                    outputStream.write("Hello client, you sent: " + line + "\n".getBytes());
                    outputStream.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}