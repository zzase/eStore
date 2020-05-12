package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Product;

@Repository
@Transactional // spring framework
public class ProductDao {

	/*
	 * private JdbcTemplate jdbcTemplate;
	 * 
	 * @Autowired public void setDataSource(DataSource dataSource) { jdbcTemplate =
	 * new JdbcTemplate(dataSource); }
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);

		return product;

		/*
		 * String sqlStatement = "select * from product where id=?";
		 * 
		 * return jdbcTemplate.queryForObject(sqlStatement,new Object[] {id}, new
		 * RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("UnitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product;
		 * 
		 * } });
		 */
	}

	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";

		Query<Product> query = session.createQuery(hql, Product.class);
		List<Product> productList = query.getResultList();

		return productList;

		/*
		 * String sqlStatement = "select * from product";
		 * 
		 * return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("UnitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product;
		 * 
		 * } });
		 */
	}

	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

		// jdbc사용이였으면 method type은 boolean

		/*
		 * int id = product.getId(); String name = product.getName(); String category =
		 * product.getCategory(); int price = product.getPrice(); String manufacturer =
		 * product.getManufacturer(); int unitInStock = product.getUnitInStock(); String
		 * description = product.getDescription();
		 * 
		 * // id는 auto increament이기때문에 따로 지정해주지않아도 시스템이 자동적으로 숫자를 증가시켜 생성해줌
		 * 
		 * String sqlStatement =
		 * "insert into product (id,name,category,price,manufacturer,unitInStock,description)"
		 * + "values (?,?,?,?,?,?,?)";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { id, name, category,
		 * price, manufacturer, unitInStock, description }) == 1);
		 */
	}

	public void deleteProduct(Product product) {
		// jdbc 사용이면 boolean 타입에 인자는 id
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();

		/*
		 * String sqlStatement = "delete from product where id=?";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1);
		 */
	}

	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

		/*
		 * int id = product.getId(); String name = product.getName(); String category =
		 * product.getCategory(); int price = product.getPrice(); String manufacturer =
		 * product.getManufacturer(); int unitInStock = product.getUnitInStock(); String
		 * description = product.getDescription();
		 * 
		 * // id는 auto increament이기때문에 따로 지정해주지않아도 시스템이 자동적으로 숫자를 증가시켜 생성해줌
		 * 
		 * String sqlStatement =
		 * "update product set name=?, category=?, price=?, manufacturer=?, unitInStock=?, description=?"
		 * + "where id=? ";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { name, category,
		 * price, manufacturer, unitInStock, description, id }) == 1);
		 */
	}

}
