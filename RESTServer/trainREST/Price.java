package trainREST;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Price extends ServerResource {  
	@Get  
	public String toString() {
		String price = (String) getRequestAttributes().get("price");
		long lprice = Long.parseLong(price);

		List<Train> trainList = ReadJson.ListTrain();

		List <List>  idprice = filterTrain(lprice);
		List<String> filtertrain = idprice.get(0);
		List<Integer> filterprice = idprice.get(1);
		
		//List <String> filterprice = filtertrain.stream().map(Train::getId).collect(Collectors.toList());
				
		String trainanswer =  filtertrain.toString();
		String priceanswer = filterprice.toString();
		
		if (filtertrain != null && filtertrain.isEmpty()) { return "No available train"; }
		
		return "The items at " + lprice + "  to  bought are Train of IDs: " + trainanswer + "  of corresponding fares: " + priceanswer;
		
	}


	public List <List> filterTrain(long price) {

		List<String> idlist= new ArrayList<>();
		List<Integer> priceList = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/tp_aisg_efrei";
		String username = "root";
		String password = "timothe123";

		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			String sql =  "SELECT * FROM trains WHERE price ="+ price;
			Statement stat = connection.createStatement();
			ResultSet result = stat.executeQuery(sql);

			while (result.next()){
				String id = result.getString("id");
				int priceT = result.getInt("price");
				priceList.add(priceT);
				idlist.add(id);
			}

			connection.close();

		} catch (SQLException e) {
			System.out.println("can't connect to databse");
			e.printStackTrace();
		}

		List< List> map =new ArrayList<List>();
		map.add(idlist);
		map.add(priceList);
		return map;
	}
}