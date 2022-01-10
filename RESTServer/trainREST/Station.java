package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Station extends ServerResource {  
	@Get  
	public String toString() {
		String dstation = (String) getRequestAttributes().get("dstation");
		String astation = (String) getRequestAttributes().get("astation");

		List<Train> trainList = ReadJson.ListTrain();

		List <List>  idprice = filterTrain(dstation,astation);
		List<String> filtertrain = idprice.get(0);
		List<Integer> filterprice = idprice.get(1);

		String trainanswer =  filtertrain.toString();
		String priceanswer = filterprice.toString();

		if (filtertrain != null && filtertrain.isEmpty()) { return "No available train"; }

		return "The train departing from " + astation +" to " + dstation +
				" are: "+ trainanswer + "  of corresponding fares: " + priceanswer;
	}

	private List<List> filterTrain(String dstation, String astation) {

		List<String> idlist= new ArrayList<>();
		List<Integer> priceList = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/tp_aisg_efrei";
		String username = "root";
		String password = "timothe123";

		try {
			Connection connection = DriverManager.getConnection(url,username,password);

			String sql =  "SELECT * FROM trains WHERE departureStation = '"+ dstation.trim() +"' AND arrivalStation = '"+ astation.trim()+"'";
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
