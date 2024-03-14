package Object;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String args[]) throws IOException {
        String serverIpAddress = "localhost";
        int serverPort = 6666;

        Socket socket = new Socket(serverIpAddress, serverPort);

        // Flux de sortie vers le socket
        OutputStream os = socket.getOutputStream();
        // Création d'un flux d'objets pour sérialiser des objets Java
        ObjectOutputStream oss = new ObjectOutputStream(os);

        // Création d'un objet de type Compte à envoyer au serveur
        Compte compte = new Compte("Jalal Eddine", "OUTGOUGA", "outgougajalaldine@gmail.com");

        // Écriture de l'objet dans le flux de sortie
        oss.writeObject(compte);

        // Fermeture du socket serveur
        socket.close();
    }
}
