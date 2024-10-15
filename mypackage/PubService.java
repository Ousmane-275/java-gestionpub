package mypackage;

import java.util.List;

public class PubService {
    private PubDao publicationDAO;

    public PubService(PubDao publicationDAO) {

        this.publicationDAO = publicationDAO;

    }

    public List<PubSkeleton> getAllPublications() {

        return publicationDAO.getAllPublications();

    }

    public PubSkeleton getPublicationById(int id) {

        return publicationDAO.getPublicationById(id);

    }

    public void createPublication(PubSkeleton publication) {

        publicationDAO.createPublication(publication);

    }

    public void updatePublication(PubSkeleton publication) {

        publicationDAO.updatePublication(publication);

    }

    public void deletePublication(int id) {

        publicationDAO.deletePublication(id);

    }
}
