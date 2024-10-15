package mypackage;

import java.util.ArrayList;
import java.util.List;

/* 
    PubDao est l'accronyme de Publication Data access object
    Cette class permet d'encapsuler les données de mon programme
*/

public class PubDao {
        private List<PubSkeleton> publications;


    public PubDao() {

        this.publications = new ArrayList<>();

    }


    public List<PubSkeleton> getAllPublications() {

        return publications;

    }


    public PubSkeleton getPublicationById(int id) {

        for (PubSkeleton publication : publications) {

            if (publication.getId() == id) {

                return publication;

            }

        }

        return null;

    }


    public void createPublication(PubSkeleton publication) {

        publications.add(publication);

    }


    public void updatePublication(PubSkeleton publication) {

        for (int i = 0; i < publications.size(); i++) {

            if (publications.get(i).getId() == publication.getId()) {

                publications.set(i, publication);

                return;

            }

        }

    }


    public void deletePublication(int id) {

        for (int i = 0; i < publications.size(); i++) {

            if (publications.get(i).getId() == id) {

                publications.remove(i);

                return;

            }

        }

    }
}
