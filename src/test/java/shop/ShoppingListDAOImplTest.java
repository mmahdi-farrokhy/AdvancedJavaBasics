package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

// Integration Test
public class ShoppingListDAOImplTest {
    public static final String ERROR = "Connection To DataBase Failed";
    public static final String INSERT_QUERY = "INSERT INTO item (Name, Quantity) VALUES(?, ?)";
    public static final String SELECT_QUERY = "SELECT * FROM item ORDER BY id DESC LIMIT 1";
    public static final String DELETE_QUERY = "DELETE FROM item ORDER BY id DESC LIMIT 1";
    private String HOST;
    private String USERNAME;
    private String PASSWORD;

    @BeforeEach
    void setUp() {
        try (InputStream configFile = new FileInputStream("db-config.properties")){
            final Properties properties = new Properties();
            properties.load(configFile);
            HOST = properties.get("host").toString();
            USERNAME = properties.get("user").toString();
            PASSWORD = properties.get("pass").toString();
        } catch (IOException e) {
            e.printStackTrace();
            fail(ERROR);
        }
    }

    @Test
    void should_connect_to_MySQL_database() {
        try(final Connection con = getConnection(HOST, USERNAME, PASSWORD)){
            if (con == null){
                fail(ERROR);
            }

        } catch (SQLException sqle){
            sqle.printStackTrace();
            fail("Connection To DataBase Failed");
        }
    }

    @Test
    void should_insert_read_and_deleye_an_item_in_database() {
        try(final Connection con = getConnection(HOST, USERNAME, PASSWORD);
            PreparedStatement INSERT = con.prepareStatement(INSERT_QUERY);
            PreparedStatement SELECT = con.prepareStatement(SELECT_QUERY);
            PreparedStatement DELETE = con.prepareStatement(DELETE_QUERY);){

            INSERT.setString(1, "Orange");
            INSERT.setInt(2, 5);
            INSERT.executeUpdate();

            final ResultSet resultSet = SELECT.executeQuery();
            while (resultSet.next()){
                final String name = resultSet.getString("Name");
                final int quantity = resultSet.getInt("Quantity");

                assertThat(name).isEqualTo("Orange");
                assertThat(quantity).isEqualTo(5);
            }
            DELETE.executeUpdate();

        } catch (SQLException sqle){
            sqle.printStackTrace();
            fail("Connection To DataBase Failed");
        }
    }
}
