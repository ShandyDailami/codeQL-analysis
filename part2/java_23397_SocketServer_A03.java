import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class java_23397_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Waiting for client...");

            SSLSocket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here, we're assuming the client sends the string 'exit' to close the connection.
                // In a real-world scenario, you'd replace this with a more secure mechanism.
                if (message.equals("exit")) {
                    clientSocket.close();
                    serverSocket.close();
                    System.out.println("Connection closed");
                    break;
                }
            }

            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}