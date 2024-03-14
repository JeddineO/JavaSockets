package Object;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        // Création d'un socket serveur écoutant sur le port 6666
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Je suis le serveur, j'attends un client ");

        // Attente d'une connexion entrante et acceptation de la connexion
        Socket s = ss.accept();

        // Flux d'entrée depuis le socket
        InputStream is = s.getInputStream();
        // Création d'un flux d'objets pour désérialiser des objets Java
        ObjectInputStream ois = new ObjectInputStream(is);

        // Lecture de l'objet envoyé par le client
        Compte compte = (Compte) ois.readObject();

        // Affichage des informations du compte
        System.out.println("Nom: " + compte.getLname());
        System.out.println("Prénom: " + compte.getFname());
        System.out.println("Email: " + compte.getEmail());

        // Fermeture du socket serveur
        ss.close();
    }
}
