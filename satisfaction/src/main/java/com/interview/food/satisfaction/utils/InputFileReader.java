package com.interview.food.satisfaction.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.interview.food.satisfaction.bean.Item;

public class InputFileReader {

	public static String inputPath;
	public static int totalTime = 0;
	public static int itemNo = 0;

	/*
	 * public InputFileReader(String path) { this.inputPath = path; }
	 */

	/*
	 * This method returns the Item Object in a list
	 */
	public Map<Item, Double> getDataFromFile() {

		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		Map<Item, Double> itemMap = new HashMap<Item, Double>();
		Item item = null;
		try {

			fileReader = new FileReader(new File(inputPath));
			bufferedReader = new BufferedReader(fileReader);
			String nextLine;
			int i = 0;
			while ((nextLine = bufferedReader.readLine()) != null) {
				i++;
				if (i > 1) {
					item = tokenizeData(item, nextLine, i);
					itemMap.put(item, item.getSatisfactionIndex());
				} else {

					StringTokenizer tokenizer = new StringTokenizer(nextLine,
							" ");
					while (tokenizer.hasMoreTokens()) {
						totalTime = Integer.parseInt(tokenizer.nextToken());
						itemNo = Integer.parseInt(tokenizer.nextToken());
					}

				}

			}

		} catch (Exception e) {
			System.err.println("Exception while reading data from File "
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				System.err.println("Exception while closing BufferedReader "
						+ e.getStackTrace());
			}
		}

		return itemMap;
	}

	private Item tokenizeData(Item item, String line, int i) {

		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		item = new Item();
		while (tokenizer.hasMoreTokens()) {

			item.setItemId(i - 1);
			item.setSatisfactionAmount(Integer.parseInt(tokenizer.nextToken()));
			item.setTimeTaken(Integer.parseInt(tokenizer.nextToken()));
			item.setSatisfactionIndex();
		}
		return item;
	}

}
