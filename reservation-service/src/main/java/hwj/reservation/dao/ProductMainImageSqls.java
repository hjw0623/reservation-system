package hwj.reservation.dao;

public class ProductMainImageSqls {
	//SELECT LIST With MAIN Image BY CategoryID
	static final String SELECT_WITH_MAIN_IMAGE_BY_CATEGORY_ID = 
			
			"SELECT A.id, A.category_id, A.name, A.description, A.sales_start, A.sales_end, A.sales_flag, A.event, A.create_date, A.modify_date,"
			+" B.product_id, B.file_id, B.type, C.save_file_name "
			+" FROM PRODUCT as A INNER JOIN PRODUCT_IMAGE as B  ON B.product_id=A.id, File as C "
			+" WHERE category_id=:category_id and type=0 and C.id = B.file_id ORDER BY A.id "
			+" LIMIT 0, :num";
	
	//SELECT All LIST With MAIN Image
	public static String SELECT_ALL_PRODUCT_WITH_MAIN_IMAGE=
			
			"SELECT A.id, A.category_id, A.name, A.description, A.sales_start, A.sales_end, A.sales_flag, A.event, A.create_date, A.modify_date,"
			+" B.product_id, B.file_id, B.type, C.save_file_name " 
			+" FROM PRODUCT as A INNER JOIN PRODUCT_IMAGE as B  ON B.product_id=A.id, File as C "
			+" WHERE type=0 and C.id = B.file_id ORDER BY A.id "
			+" LIMIT 0, :num";
}
