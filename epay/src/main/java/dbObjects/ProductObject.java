package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Product getProductBySlug(String slug) {
        Product product = null;

        try {
            myQuery = "SELECT * FROM products WHERE slug=?";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setString(1, slug);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setSku(resultSet.getInt("sku"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setVendor(resultSet.getString("vendor"));
                product.setSlug(resultSet.getString("slug"));
                product.setImage(resultSet.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return product;
    }

    public boolean insertProduct(Product product) {
        try {
            myQuery = "INSERT INTO products (sku, name, price, description, vendor, slug, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setInt(1, product.getSku());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getVendor());
            preparedStatement.setString(6, product.getSlug());
            preparedStatement.setString(7, product.getImage());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        try {
            myQuery = "UPDATE products SET name = ?, price = ?, description = ?, vendor = ?, image = ? WHERE slug = ?";
            preparedStatement = connection.prepareStatement(myQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getVendor());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setString(6, product.getSlug());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

}
