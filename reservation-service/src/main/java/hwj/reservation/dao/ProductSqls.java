package hwj.reservation.dao;

public class ProductSqls {
		//COUNT All
		static final String COUNT_ALL_PRODUCT="SELECT COUNT(*) FROM PRODUCT ";
		//COUNT BY Category
		static final String COUNT_PRODUCT_BY_CATEGORY="SELECT COUNT(*) FROM PRODUCT WHERE category_id=:category_id ";
		
		//Select All List by limit num
		static final String SELECT_ALL_PRODUCT= 
				"SELECT id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date "
				+ "FROM PRODUCT LIMIT 0"
				+", :num";
		
		//SELECT ALL List 
		static final String SELECT_ALL_PRODUCT_DEFAULT= 
				"SELECT id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date "
				+"FROM PRODUCT";
		
		//SELECT BY CATEGORY ID
		static final String SELECT_BY_CATEGORY_ID = 
				"SELECT id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date "
				+ "FROM PRODUCT WHERE category_id =:category_id LIMIT 0"
				+ ", :num";
		
		// -- optional --
		
		//SELECT BY ID
		static final String SELECT_BY_PRODUCT_ID =
				"SELECT id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date "
				+ "FROM PRODUCT WHERE id = :id";
		//SELECT BY NAME
		static final String SELECT_BY_PRODUCT_NAME = 
				"SELECT id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date "
				+ "FROM PRODUCT WHERE name =:name";
		
		//UPDATE 
		static final String UPDATE_PRODUCT_NAME=
				"UPDATE product SET\n"
				+ "name =:name\n"
				+ "description=:description\n"
			    + "WHERE id=:id";
		//DELETE BY NAME
		static final String DELETE_BY_PRODUCT_NAME=
				"DELETE FROM PRODUCT WHERE name= :name";
		
		//DELETE BY ID
		static final String DELETE_BY_PRODUCT_ID=
				"DELETE FROM PRODUCT WHERE id= :id";
		
}
