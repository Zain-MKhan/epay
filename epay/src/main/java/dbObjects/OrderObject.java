package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.*;

public class OrderObject {
    private Connection connection;
    private String myQuery;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public OrderObject(Connection connection) {
        this.connection = connection;
    }

    public boolean insertOrder(Order myOrder) {
        boolean result = false;
        try {
            // orderid will increment on its own as our database is designed this way
            myQuery = "insert into orders (productsku, email, quantity, shippingAddress, date, orderid, trackingNumber) values(?,?,?,?,?,?,?)";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setInt(1, myOrder.getSku());
            preparedStatement.setString(2, myOrder.getEmail());
            preparedStatement.setInt(3, myOrder.getQuantity());
            preparedStatement.setString(4, myOrder.getShippingAddress());
            preparedStatement.setString(5, myOrder.getDate());
            preparedStatement.setInt(6, myOrder.getOrderId());
            preparedStatement.setInt(7, myOrder.getTrackingNumber());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Order> userOrders(String email) {
        List<Order> orderList = new ArrayList<>();
        try {
            myQuery = "select * from orders where email=?";
            preparedStatement = this.connection.prepareStatement(myQuery);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order myOrder = new Order();
                ProductObject productObject = new ProductObject(this.connection);
                myOrder.setOrderId(resultSet.getInt("orderid"));
                myOrder.setSku(resultSet.getInt("productsku"));
                myOrder.setQuantity(resultSet.getInt("quantity"));
                myOrder.setDate(resultSet.getString("date"));
                orderList.add(myOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }

    // for staff members
    public List<Order> userOrders() {
        List<Order> orderList = new ArrayList<>();
        try {
            myQuery = "select * from orders";
            preparedStatement = this.connection.prepareStatement(myQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order myOrder = new Order();
                ProductObject productObject = new ProductObject(this.connection);
                myOrder.setOrderId(resultSet.getInt("orderid"));
                myOrder.setSku(resultSet.getInt("productsku"));
                myOrder.setQuantity(resultSet.getInt("quantity"));
                myOrder.setDate(resultSet.getString("date"));
                orderList.add(myOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
}
