import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private int UserID;
    private String Username;
    private String City;
    private static String sqlStatement;

    public User(int UserID, String Username, String City) {
        this.UserID = UserID;
        this.Username = Username;
        this.City = City;

    }
public void setUserID(int UserID){
        this.UserID=UserID;

}
public int getUserID(){
        return this.UserID;
}
public void setUsername(String Username){
    this.Username=Username;

}
public String getUsername(){
        return this.Username;
}
public void setCity(String City){
        this.City=City;
}
    public String getCity(){
        return this.City;
    }
    public static void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean insert = statement.execute("INSERT INTO user (UserID, Username, City)" +
                " VALUES ('6', 'Embelo Erega', 'Yahunde')");
        if (insert) {
            System.out.println("data inserted successfully");
        }
        DbConnector.closeConnection();
    }

    public static void update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean update = statement.execute("UPDATE user SET City= 'Kano'  WHERE UserID = 3  ");
        if (update) {
            System.out.println("data updated successfully");
        }
        DbConnector.closeConnection();

    }

    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean delete = statement.execute("DELETE * FROM  product  WHERE UserID = 5  ");
        if (delete) {
            System.out.println("data deleted successfully");
        }
        DbConnector.closeConnection();
    }


    public static void query() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean query = statement.execute("SELECT * FROM product ");

        if (query) {
            System.out.println("all data shown");

        }
        DbConnector.closeConnection();
    }
}

