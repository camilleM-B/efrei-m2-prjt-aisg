package trainREST;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Spring;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
	
	public static List<Train> trainList = new ArrayList<Train>();
	
	@SuppressWarnings("unchecked")
	public static List<Train> ListTrain() 
	{

		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("sample_train.json"))
		{
			//Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray trainSample = (JSONArray) obj;
           // System.out.println(trainSample);
            
            //Iterate over employee array
            trainSample.forEach( tr -> parseTrain( (JSONObject) tr ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		/*removeDuplicates();
		trainList.forEach( tr -> tr.display() );*/
		return trainList;

	}

	private static void parseTrain(JSONObject train) 
	{
		
		//Get employee object within list
		JSONObject trainObject = (JSONObject) train.get("train");
		
		String id = (String) trainObject.get("id");			
		String departureStation = (String) trainObject.get("departureStation");	
		String arrivalStation = (String) trainObject.get("arrivalStation");	
		String outboundDate = (String) trainObject.get("outboundDate");	
		String returnDate = (String) trainObject.get("returnDate");	
		long totalTickets =  (long) trainObject.get("totalTickets");	
		long remainingTickets = (long) trainObject.get("remainingTickets");	
		String travelClass = (String) trainObject.get("travelClass");	
		long price = (long) trainObject.get("price");	

		/*
		System.out.println(id);
		System.out.println(dStation);
		System.out.println(aStation);
		System.out.println(oDate);
		System.out.println(rDate);
		System.out.println(tTicket);
		System.out.println(rTicket);
		System.out.println(tClass);
		System.out.println(price);
		
		System.out.println("--");*/
		//System.out.println(trainObject);
		Train mytrain = new Train( id,  departureStation,  arrivalStation,  outboundDate,  returnDate,  totalTickets
			    ,  remainingTickets,  travelClass,  price);
		
		trainList.add(mytrain);
		
	}
	
	public static void removeDuplicates() {
		trainList = trainList.stream().distinct().collect(Collectors.toList());
	}

}
