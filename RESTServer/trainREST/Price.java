package trainREST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Price extends ServerResource {  
	@Get  
	public String toString() {  
		List<Train> trainList = ReadJson.ListTrain();
		trainList =		trainList.stream().distinct().collect(Collectors.toList()); ;
		String price = (String) getRequestAttributes().get("price");
		long lprice = Long.parseLong(price);
		
		//trainList.get(1).display();
		//System.out.println("price"+lprice);
		List<Train> filtertrain = filterPrice(lprice);
		
		List <String> filterprice = filtertrain.stream().map(Train::getId).collect(Collectors.toList());
				
		String answer =  filterprice.toString();
		
		if (filtertrain != null && filtertrain.isEmpty()) { answer = "No available train"; }
		
		return "The items at \"" + lprice + "\"  to  bought are Train of IDs: " + answer ;  
		
	}  
	
	
	public List<Train> filterPrice(long price) {

		//System.out.println("---0");
		List<Train> trainlist = ReadJson.ListTrain() ;
		List<Train> filtertrain =  trainlist.stream().filter(tr -> tr.getPrice()== price).collect(Collectors.toList());
				//.contains("test")).collect(Collectors.toList());

		//System.out.println("---1");
		filtertrain.forEach( tr -> tr.display() );

		//System.out.println("--2"+ Arrays.toString(filtertrain.toArray()));
		return filtertrain;
	}
}  