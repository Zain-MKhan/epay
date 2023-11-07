package dbObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        return prdList;


    }



    
}
