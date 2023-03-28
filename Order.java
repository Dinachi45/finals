import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Order {
    private int OrderID;
    private int UserID;
    private int ProductID;
    private Date Orderdate;
    private String Orderstatus;
    private int Quantity;
    private static String sqlStatement;
   public Order(int OrderID, int   UserID, int ProductID, Date Orderdate, String Orderstatus, int Quantity) {
       this.OrderID = OrderID;
       this.UserID = UserID;
       this.ProductID = ProductID;
       this.Orderdate = Orderdate;
       this.Orderstatus = Orderstatus;
       this.Quantity = Quantity;


   }
   public void setOrderID(int OrderID){
       this.OrderID=OrderID;

   }
   public int getOrderID(){
       return this.OrderID;
   }
    public void setUserID(int UserID ){
        this.UserID=UserID;

    }
    public int getUserID(){
        return this.UserID;
    }
    public void setProductID(int ProductID){
        this.ProductID=ProductID;

    }
    public int getProductID(){
        return this.ProductID;
    }public void setOrderdate(Date Orderdate){
        this.Orderdate=Orderdate;

    }
    public Date getOrderdate(){
        return this.Orderdate;
    }public void setOrderstatus(String Orderstatus){
        this.Orderstatus=Orderstatus;

    }
    public int getQuantity(){
        return this.Quantity;
    }public void setQuantity(int Quantity){
        this.Quantity=Quantity;

    }

    public static void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        sqlStatement = "INSERT INTO order (OrderID, UserID, ProductID, Orderdate," +
                " Orderstatus, Quantity ) VALUES (6, 6,6, '2022-09-07', 'Purchased', 10)";
        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean insert = statement.execute(sqlStatement);
        if (insert) {
            System.out.println("data inserted successfully");
        }

        DbConnector.closeConnection();
    }

    public static void update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean update = statement.execute("UPDATE order SET Quantity= 10  WHERE OrderID = 3  ");
        if (update) {
            System.out.println("data updated successfully");
        }
        DbConnector.closeConnection();

    }

    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean delete = statement.execute("DELETE * FROM  order  WHERE OrderID = 5  ");
        if (delete) {
            System.out.println("data deleted successfully");
        }
        DbConnector.closeConnection();
    }


    public static void query() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement statement = DbConnector.createStatement(sqlStatement);
        Boolean query = statement.execute("SELECT * FROM order ");

        if (query) {
            System.out.println("all data shown");

        }
        DbConnector.closeConnection();
    }
}
