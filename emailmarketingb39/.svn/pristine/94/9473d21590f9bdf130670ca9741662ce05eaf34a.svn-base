package com.nacre.emailmarketing.serviceI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dao.UserDaoI;
import com.nacre.emailmarketing.daoI.UserDaoImpl;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.ProductVeiwDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;

public class UserServiceImpl implements UserServiceI {
	// overridden method for finding product id and mailId (riyaz+rohit)
	@Override
	public List findProduct(ProductVeiwDto dto) throws Exception {
		UserDaoImpl dao = new UserDaoImpl();

		return dao.getProduct(dto.getProdId(), dto.getMailId());
	}// findProduct
	//Create Account:Rajkumar and Supriya start
	@Override
	public Integer registerUserDetails(RegisterDto registerDto) throws DatabaseException {
		Connection connection=null;
		UserDaoI userDaoI=null;
		
		//Create Connection
		connection=DbUtil.getConnection();
		//Create DAO obj
		userDaoI=new UserDaoImpl();
		return userDaoI.registerUserDetails(connection, registerDto);
	}//registerUserDetails(-,-)
	@Override
	public Map<String, Integer> getCity(int cityId) {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoI.getCity(connection, cityId);
	}
	@Override
	public Map<String, Integer> getState(int stateId) {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoI.getSate(connection, stateId);
	}
	@Override
	public Map<String, Integer> getCountry() {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return daoI.getCountry(connection);
	}
	

	//Create Account:Rajkumar and Supriya end

	
	
	@Override	public int login(LoginDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	//chinymai
	@Override
	public List checkNewArival(ProductDto pd) throws DatabaseException {
		Connection con=null;
		System.out.println("hiiiiiiiiiiiiiiiii");
		try{
		con=DbUtil.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/*Integer productId=pd.getProductId();
		String productName=pd.getProductName();
		String Image=pd.getImage();
		Integer productPrice=pd.getProductPrice();
		Integer quantity=pd.getQuantity();
		*/
	UserDaoImpl dao=new UserDaoImpl();
	List status=dao.checkSuccess(con,pd);
	
	System.out.println("dao close");
	return status;
	
	}

/*//krishna&amit
public ProductDto productInfo(ProductDto dto) throws SQLException, DatabaseException {
				UserDaoI dao=new UserDaoImpl();
				ProductDto dto1=dao.productInfo(dto);
				return dto1;
		
	}

		
			public Operation addToCart(Operation1 dto) throws DatabaseException, SQLException {
				UserDaoI dao=new UserDaoImpl();
				Operation1 dto1=dao.addToCart(dto);
				return dto1;
			}

			@Override
			public int checkCart() throws DatabaseException, SQLException {
				UserDaoI dao=new UserDaoImpl();
				int result=dao.checkCart();
				return result;
			}

			@Override
			public int buyProduct(Operation1 dto) throws DatabaseException, SQLException {
				UserDaoI dao=new UserDaoImpl();
				int result=dao.buyProduct(dto);
				return result;
			}

			@Override
			public ArrayList<Datadto> getAllCartProducts() throws DatabaseException, SQLException {
				ArrayList<Datadto> productList=null;
				UserDaoI dao=new UserDaoImpl();
				
				productList=dao.getAllCartProducts();
				return productList;
			}

			@Override
			public boolean buyProductfromCart(int operationId) throws DatabaseException, SQLException {
				UserDaoI dao=new UserDaoImpl();
				boolean result=dao.buyProductfromCart(operationId);
				return result;
			}

			@Override
			public int login(LoginDto dto) throws DatabaseException, SQLException {
				UserDaoI dao=new UserDaoImpl();
				int result=dao.login(dto);
				return result;
			}
*/







	
}// class
