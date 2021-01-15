
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 class InventoryDAO {
     private static final String Insert_pro = "INSERT INTO inventory" + "  (Product_Name, Product_rating) VALUES " + " (?, ?);";
    private static final String Select_pro = "select Product_Name, Product_rating from inventory where Product_Id =?";
    private static final String Select_all = "select * from inventory;";
    private static final String Delete_pro = "delete from inventory where Product_Id = ?;";
    private static final String Update_pro = "update inventory set Product_Name = ?,Product_rating= ? where Product_Id = ?;";

    public InventoryDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_Inventory", "root", "root");
        } catch(ClassNotFoundException e){ 
        	System.out.println(e);
        	}
        catch(SQLException e){ 
        	System.out.println(e);
        	}
        
        try {
			int x=0,y=10;
			int z = y/x;
			
        } 
		  catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.print("Here is an Arithmetic error.");
		  }  
        finally {
			
		}
        
        return connection;
    }

    public void insertProduct(Inventory inven) throws SQLException {
        System.out.println(Insert_pro);

        try (Connection connection = getConnection(); 
        		PreparedStatement preparedStatement = connection.prepareStatement(Insert_pro)) {
            preparedStatement.setString(1, inven.getName());
            preparedStatement.setInt(2, inven.getRating());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
       }      
    }
    
  public Inventory selectPro(int id) {
	Inventory invent = null;
    
    try (Connection connection = getConnection();
         
        PreparedStatement preparedStatement = connection.prepareStatement(Select_pro);) {
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            String name = rs.getString("Product_Name");
            int rating = Integer.parseInt(rs.getString("Product_rating"));
            invent = new Inventory(id, name, rating);
        }
    } catch (Exception e) {
        System.out.println(e);
   }
    return invent;
  }  
  public List < Inventory > selectAllPro() throws SQLException {

      List < Inventory > lst_inven = new ArrayList < > ();
      try (Connection connection = getConnection(); 
    		  PreparedStatement preparedStatement = connection.prepareStatement(Select_all);) {
          System.out.println(preparedStatement);

          ResultSet rs = preparedStatement.executeQuery();

         
          while (rs.next()) {
              int id = Integer.parseInt(rs.getString("Product_Id"));
              String name = rs.getString("Product_Name");
              int rating = Integer.parseInt(rs.getString("Product_rating"));         
              lst_inven.add(new Inventory(id, name, rating));
          }
      } 
      return lst_inven;
  }
  
public boolean deleteProduct(int id) throws SQLException {
boolean rowDeleted;
try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(Delete_pro);) {
    statement.setInt(1, id);
    rowDeleted = statement.executeUpdate() > 0;
}
return rowDeleted;
}

public boolean updateProduct(Inventory inven) throws SQLException {
boolean rowUpdated;
try (Connection connection = getConnection(); 
		PreparedStatement statement = connection.prepareStatement(Update_pro);) {
    statement.setString(1, inven.getName());
    statement.setInt(2, inven.getRating());
    statement.setInt(3, inven.getId());
    rowUpdated = statement.executeUpdate() > 0;
}
return rowUpdated;
}
}