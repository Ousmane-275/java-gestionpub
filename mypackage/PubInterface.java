package mypackage;

import java.util.List;

public interface PubInterface {

    List<PubService> getAllPublications();

    PubSkeleton getPublicationById(int id);

    void createPublication(PubSkeleton publication);

    void updatePublication(PubSkeleton publication);

    void deletePublication(int id);

}