
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class Product {
    private static int ProductID;
    private String Productname;
    private String Category;

    private static String sqlStatement;

    public Product(int ProductID, String Productname, String Category) {
        this.ProductID = ProductID;
        this.Productname = Productname;
        this.Category = Category;

    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getProductID() {
        return this.ProductID;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
    }

    public String getProductname() {
        return this.Productname;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getCategory() {
        return this.Category;
    }
    public static void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean insert = statement.execute("INSERT INTO product (ProductID, Productname, Category) VALUES ('7', 'HP', 'Computer') ");

        if (insert) {
            System.out.println("data inserted");
        }
        DbConnector.closeConnection();
    }



    public static void update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean update = statement.execute("UPDATE product SET Category= 'Computing'  WHERE ProductID = 3  ");
        if (update) {
            System.out.println("data updated successfully");
        }
        DbConnector.closeConnection();

    }

    public static void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean delete = statement.execute("DELETE * FROM  product  WHERE ProductID = 5  ");
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