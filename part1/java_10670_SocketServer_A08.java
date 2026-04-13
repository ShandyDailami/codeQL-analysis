import java.io.*;
import java.net.*;

public class java_10670_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(65534);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread thread = new Thread(new ServerThread(clientSocket));
            thread.start();
        }
    }
}

class ServerThread implements Runnable {

    private Socket socket;

    public java_10670_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            DataOutputStream writer = new DataOutputStream(output);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);

                // Forward the request to the client
                writer.writeBytes(line + "\n");
            }

            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}