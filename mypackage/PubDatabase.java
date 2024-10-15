package mypackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PubDatabase implements PubInterface {

    private Connection connection;


    public PubDatabase(Connection connection) {

        this.connection = connection;

    }


    @Override

    public List<PubService> getAllPublications() {

        List<PubService> publications = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM publications");

            while (resultSet.next()) {

                PubSkeleton publication = new PubSkeleton();

                publication.setId(resultSet.getInt("id"));

                publication.setTitle(resultSet.getString("title"));

                publication.setAuthor(resultSet.getString("author"));

                publication.setPublicationDate(resultSet.getString("publication_date"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return publications;

    }


    @Override

    public PubSkeleton getPublicationById(int id) {

        PubSkeleton publication = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM publications WHERE id = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                publication = new PubSkeleton();

                publication.setId(resultSet.getInt("id"));

                publication.setTitle(resultSet.getString("title"));

                publication.setAuthor(resultSet.getString("author"));

                publication.setPublicationDate(resultSet.getString("publication_date"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return publication;

    }


    @Override

    public void createPublication(PubSkeleton publication) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO publications (title, author, publication_date) VALUES (?, ?, ?)");

            statement.setString(1, publication.getTitle());

            statement.setString(2, publication.getAuthor());

            statement.setString(3, publication.getPublicationDate());

            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


    @Override

    public void updatePublication(PubSkeleton publication) {

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE publications SET title = ?, author = ?, publication_date = ? WHERE id = ?");

            statement.setString(1, publication.getTitle());

            statement.setString(2, publication.getAuthor());

            statement.setString(3, publication.getPublicationDate());

            statement.setInt(4, publication.getId());

            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


    @Override

    public void deletePublication(int id) {

        try {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM publications WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
