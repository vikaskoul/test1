package test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Q1 {
		
	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		String lineRead = "";
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		if(args.length == 0 || args.length > 1) {
			System.out.println("Invalid number of arguments. Please enter file path correctly");
			System.exit(0);
		}
		try {
			File file = new File(args[0]);
			if(file.exists()) { 
				br = new BufferedReader(new FileReader(args[0]));
				while ((lineRead = br.readLine()) != null) {
					String[] buff = lineRead.split(",");
					for(int i=0;i<buff.length;i++) {
						inputList.add(Integer.parseInt(buff[i]));
					}
				}
			}
			Collections.sort(inputList);
			Scanner reader = new Scanner(System.in);
			System.out.println("****Menu***");
			while(true){
				System.out.println("1.Calculate the mean \n2.Calculate the median\n3.Calculate the mode ");
				
				System.out.println("Enter your choice:");
				int choice = reader.nextInt();
				switch(choice) {
				case 1: System.out.println("Calculating Mean\n");
						calculateMean(inputList);
					break;
				case 2: System.out.println("Calculating Median \n");
						calculateMedian(inputList);
					break;
				case 3: System.out.println("Calculating Mode \n");
						calculateMode(inputList);
					break;
				default: reader.close();
					System.exit(0);
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void calculateMode(ArrayList<Integer> inputList) {
		// TODO Auto-generated method stub
		int modeValue = 0, maxCount = 0, counter = 0;
	    for (int i = 0; i < inputList.size(); i++) {
	        counter = 0;
	        for (int j = 0; j < inputList.size(); j++) {
	            if (inputList.get(j) == inputList.get(i))
	            	counter++;
	        }
	        if (counter > maxCount) {
	            maxCount = counter;
	            modeValue = inputList.get(i);
	        }
	    }
	    System.out.println("Mode Value is: "+modeValue);
	}

	private static void calculateMedian(ArrayList<Integer> inputList) {
		// TODO Auto-generated method stub
		int medianValue = 0;
		double medianVal = 0.0;
		int middleValue = inputList.size() / 2;
	    if (inputList.size() % 2 != 0) {
	        medianValue = inputList.get(middleValue) ;
	        System.out.println("Median Value is: "+medianValue);
	    }
	    else {
	    	medianVal = (inputList.get(middleValue - 1) + inputList.get(middleValue)) / 2;
	    	System.out.println("Median Value is: "+medianVal);
	    }
	}

	private static void calculateMean(ArrayList<Integer> inputList) {
		// TODO Auto-generated method stub
		int sum = 0;
		double result = 0.0;
	    for (int i = 0; i < inputList.size(); i++) {
	        sum = sum +  inputList.get(i);
	    }
	    result =  sum / inputList.size();
	    System.out.println("Mean is: "+result);
	}
}
