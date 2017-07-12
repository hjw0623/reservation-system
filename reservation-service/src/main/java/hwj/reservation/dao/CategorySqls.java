package hwj.reservation.dao;

public class CategorySqls {
	//Select All
	static final String SELECT_ALL_CATEGORY = 
			"SELECT id, name FROM category order by id asc";
	//SELECT BY ID
	static final String SELECT_BY_CID =
			"SELECT id, name FROM category WHERE id = :id";
	//SELECT BY NAME
	static final String SELECT_BY_CNAME = 
			"SELECT id, name FROM category WHERE name =:name";
	
	//UPDATE 
	static final String UPDATE_CATEGORY=
			"UPDATE category SET\n"
			+ "name =:name\n"
		    + "WHERE id=:id";
	//DELETE BY NAME
	static final String DELETE_BY_CNAME=
			"DELETE FROM category WHERE name= :name";
	
	//DELETE BY ID
	static final String DELETE_BY_CID=
			"DELETE FROM category WHERE id= :id";
	
	

}
