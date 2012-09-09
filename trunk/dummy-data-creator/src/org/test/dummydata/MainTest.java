package org.test.dummydata;

import java.io.IOException;

import org.opensrc.utility.dummydata.DataGenerator;
import org.opensrc.utility.dummydata.DummyData;
import org.opensrc.utility.dummydata.Formatter;
import org.opensrc.utility.dummydata.Preferences;


public class MainTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	public static void main(String[] args) 
	throws InstantiationException, IllegalAccessException, 
	IllegalArgumentException, ClassNotFoundException, IOException {

		// TODO Auto-generated method stub

		Preferences.setPreferences("dummydata.properties");
		@SuppressWarnings("rawtypes")
		DummyData dd = new DummyData();
		DataGenerator dataGenerator = new DataGenerator();
		Formatter formatter = new Formatter();
		formatter.setDataGenerator(dataGenerator);
		dd.setFormatter(formatter);
		
		Object obj = dd.dummyData(SampleVO.class, "");
		SampleVO dummy = (SampleVO)obj;
		System.out.println(dummy.getUsers().get(0).getAccountNumber().get(0));
		
	}

}
