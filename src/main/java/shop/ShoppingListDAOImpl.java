package shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class ShoppingListDAOImpl implements ShoppingListDAO {
    public static final String SELECT_QUERY = "SELECT * FROM item";
    public static final String INSERT_QUERY = "INSERT INTO item (Name, Quantity) VALUES (?, ?)";
    private String HOST;
    private String USERNAME;
    private String PASSWORD;

    public ShoppingListDAOImpl() {
        try (InputStream configFile = new FileInputStream("db-config.properties")){
            final Properties properties = new Properties();
            properties.load(configFile);
            HOST = properties.get("host").toString();
            USERNAME = properties.get("user").toString();
            PASSWORD = properties.get("pass").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> items = new LinkedList<>();
        try(final Connection con = getConnection(HOST, USERNAME, PASSWORD);
            PreparedStatement SELECT = con.prepareStatement(SELECT_QUERY);){


            final ResultSet resultSet = SELECT.executeQuery();
            while (resultSet.next()){
                final String name = resultSet.getString("Name");
                final int quantity = resultSet.getInt("Quantity");
                items.add(new Item(name, quantity));
            }

        } catch (SQLException e){
            throw new MainSQLException(e);
        }
        return items;
    }

    @Override
    public void saveItems(List<Item> items) {
        try(final Connection con = getConnection(HOST, USERNAME, PASSWORD);
            PreparedStatement INSERT = con.prepareStatement(INSERT_QUERY);){

            INSERT.setString(1, "Orange");
            INSERT.setInt(2, 5);
            INSERT.executeUpdate();

        } catch (SQLException e){
            throw new MainSQLException(e);
        }
    }
}
