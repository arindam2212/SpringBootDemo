package com.interview.food.satisfaction.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.food.satisfaction.bean.Item;
import com.interview.food.satisfaction.utils.InputFileReader;

@RestController
public class FoodSatisfactionMVCController {

	@RequestMapping("/")
	public String getMaxSatisfactionLevel() {
		try{
			InputFileReader reader= new InputFileReader();
			
			Map<Item,Double> sortedDataMap=sortByValue(reader.getDataFromFile());
			int time=InputFileReader.totalTime;
			int timeTaken=0;
			int timeLeft=0;
			int maxSatisfactionLevel=0;
			if(!(timeTaken>= time)){
				
				for (Map.Entry<Item,Double> entry : sortedDataMap.entrySet()){
					
					if(timeTaken>0)
						timeLeft=time-timeTaken;
						
					if(timeTaken==0 || entry.getKey().getTimeTaken()<=timeLeft){
					maxSatisfactionLevel=maxSatisfactionLevel+entry.getKey().getSatisfactionAmount();
					timeTaken=timeTaken+entry.getKey().getTimeTaken();
					System.out.println(timeLeft);
					}
					else{
						maxSatisfactionLevel=maxSatisfactionLevel+(timeLeft*entry.getValue().intValue());
						break;
					}
					}
			}
			
			return "The Satisfaction Gordon Get in Given Time"+time+" :: "+Integer.toString(maxSatisfactionLevel);
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return ex.getMessage();
			}
		
			
	}

	@RequestMapping(value="/{time}")
	@ResponseBody
	public static String getMaxSatisfactionInTime(@PathVariable("time") int time){
		try{
		InputFileReader reader= new InputFileReader();
		
		Map<Item,Double> sortedDataMap=sortByValue(reader.getDataFromFile());
		//int time=InputFileReader.totalTime;
		int timeTaken=0;
		int timeLeft=0;
		int maxSatisfactionLevel=0;
		if(!(timeTaken>= time)){
			
			for (Map.Entry<Item,Double> entry : sortedDataMap.entrySet()){
				
				if(timeTaken>0)
					timeLeft=time-timeTaken;
					
				if(timeTaken==0 || entry.getKey().getTimeTaken()<=timeLeft){
				maxSatisfactionLevel=maxSatisfactionLevel+entry.getKey().getSatisfactionAmount();
				timeTaken=timeTaken+entry.getKey().getTimeTaken();
				//System.out.println(timeLeft);
				}
				else{
					maxSatisfactionLevel=maxSatisfactionLevel+(timeLeft*entry.getValue().intValue());
					break;
				}
				}
		}
		
		return "The Satisfaction Gordon Get in Given Time"+time+" :: "+Integer.toString(maxSatisfactionLevel);
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			return ex.getMessage();
		}
	
		
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
