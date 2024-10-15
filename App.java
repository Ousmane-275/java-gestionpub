import mypackage.*;

import java.util.List;
import java.util.Scanner;
/* import java.util.List; */

public class App {
    /* Attribut */
        private PubService PubService;
        private Scanner scanner;
    /* fin Atrribut */

    /* Constucteur */

        public App(PubService pubAction) {

            this.PubService = pubAction;

            this.scanner = new Scanner(System.in);

        }

    /* fin Constructeur */

    /* debut des methods */
        public void displayMenu() {

            System.out.println("\n\t\t\t Gestion des publications\n\n");

            System.out.println("1. Afficher toutes les Publication");

            System.out.println("2. Create une nouvelle publication");

            System.out.println("3. Update une publication");

            System.out.println("4. Delete une publication");

            System.out.println("5. Exit \n");

        };

        public void run(){
            int choix;
            choix = scanner.nextInt();

            while (choix != 5) {
                displayMenu();
                System.out.print("Choisissez une optionen entrant le numero correspondant: ");
                choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        List<PubSkeleton> publications = PubService.getAllPublications();

                        for (PubSkeleton publication : publications) {

                            System.out.println(publication.getTitle());

                        }

                        break;

                    case 2:
                        PubSkeleton publication = new PubSkeleton();
                            System.out.println("Entrer un titre:");
                            publication.setTitle(scanner.nextLine());
                            System.out.println("Entrer l'auteur:");
                            publication.setAuthor(scanner.nextLine());
                            System.out.println("Entrer la date de la publication:");
                            publication.setPublicationDate(scanner.nextLine());

                            PubService.createPublication(publication);

                        break;

                    case 3:
                        System.out.println("Enter ID of publication to update:");
                        int id = Integer.parseInt(scanner.nextLine());
                        PubSkeleton pubToUpdate = PubService.getPublicationById(id);
                        if (pubToUpdate != null) {
                            System.out.println("Entrer un nouveau titre:");
                            pubToUpdate.setTitle(scanner.nextLine());
                            System.out.println("Entrer le nom de l'auteur:");
                            pubToUpdate.setAuthor(scanner.nextLine());
                            System.out.println("Entrer une nouvelle publication:");
                            pubToUpdate.setPublicationDate(scanner.nextLine());
                            PubService.updatePublication(pubToUpdate);
                        } else {
                            System.out.println("Publication introuvable");
                        }

                        break;

                    case 4:
                        System.out.println("Entrer l'id de la publication pour la supprimer:");
                        id = scanner.nextInt();
                        PubService.deletePublication(id);

                        break;

                    case 5:
                        System.out.println("A bientot!");
                        break;

                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            };
        }
    /* fin des methods */
            
    public static void main(String[] args){
        PubDao pubcrud = new PubDao();
        PubService pubAction = new PubService(pubcrud);
        App app = new App(pubAction);
        app.run();
    };

}