import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25125_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client accepted!");

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            // Process the received object
            process(inputStream, outputStream);

            outputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        try {
            Class[] classes = new Class[10]; // create array of Class objects
            for (int i = 0; i < 5; i++) { // read first 5 classes
                classes[i] = inputStream.readClass();
            }

            // use classes to execute code (e.g., access methods, fields, etc.)
            // for simplicity, we only print the class names
            for (int i = 0; i < 5; i++) {
                outputStream.writeObject(classes[i].getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}