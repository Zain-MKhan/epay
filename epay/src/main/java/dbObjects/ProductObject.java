package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Cart;
import business.Product;

public class ProductObject {
    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductObject(Connection connection) {
        super();
        this.connection = connection;
    }

    public List<Product> getAllProducts() {
        List<Product> prdList = new ArrayList<>();

        try {

            myQuery = "select * from products";
            preparedStatement = this.connection.prepareStatement(myQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product row = new Product();
                row.setSku(resultSet.getInt("sku"));
                row.setName(resultSet.getString("name"));
                row.setPrice(resultSet.getDouble("price"));
                row.setDescription(resultSet.getString("description"));
                row.setVendor(resultSet.getNString("vendor"));
                row.setSlug(resultSet.getString("slug"));
                row.setImage(resultSet.getString("image"));
                prdList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return prdList;

        
    }


        public List<Product> getSku() {
        List<Product> prdList = new ArrayList<>();

        try {

            myQuery = "select sku from products";
            preparedStatement = this.connection.prepareStatement(myQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product row = new Product();
                row.setSku(resultSet.getInt("sku"));
                prdList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return prdList;
    }



        public List<Cart> getCartProducts(ArrayList<Cart> cL) {
        List<Cart> prdList = new ArrayList<>();
        try {
            if (cL.size() > 0) {
                for (Cart item: cL) {
                    myQuery = "select * from products where id=?";
                    preparedStatement = this.connection.prepareStatement(myQuery);
                    preparedStatement.setInt(1, item.getSku());
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Cart row = new Cart();
                        row.setSku(resultSet.getInt("sku"));
                        row.setName(resultSet.getString("name"));
                        row.setPrice(resultSet.getDouble("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        row.setDescription(resultSet.getString("description"));
                        row.setVendor(resultSet.getNString("vendor"));
                        row.setSlug(resultSet.getString("slug"));
                        prdList.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return prdList;



        

    }



}
