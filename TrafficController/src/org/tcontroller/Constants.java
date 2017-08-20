package org.tcontroller;
import java.util.Dictionary;
import java.util.Hashtable;

public final class Constants {
	
	public static final boolean PASSES = true;
	
	public static final Dictionary<String,Integer>  ROAD_CONDITIONS = new Hashtable<String, Integer>();
	{
		ROAD_CONDITIONS.put("frozen", 0);
		ROAD_CONDITIONS.put("flooded", 0);
		ROAD_CONDITIONS.put("wet", 1);
		ROAD_CONDITIONS.put("dry", 2);
	}
	
	public static final Dictionary<String,Integer>  WEATHER_CONDITIONS = new Hashtable<String, Integer>();
	{
		WEATHER_CONDITIONS.put("rainy", 1);
		WEATHER_CONDITIONS.put("sunny", 2);
		WEATHER_CONDITIONS.put("snow", 1);
		WEATHER_CONDITIONS.put("cloudy", 2);
	}
	public static final Dictionary<String,Integer>  OBSTRUCTION = new Hashtable<String, Integer>();
	{
		OBSTRUCTION.put("full_lane", 0);
		OBSTRUCTION.put("half_lane", 1);
		OBSTRUCTION.put("non", 2);
		
	}
	
	
	private Constants(){
	    //this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	  }

}
