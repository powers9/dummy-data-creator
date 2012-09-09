package org.opensrc.utility.dummydata;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

	public static int SIZE_OF_LIST = 10;
	
	private Formatter formatter;
	
	
	/**
	 * @return the formatter
	 */
	public Formatter getFormatter() {
	
		return formatter;
	}
	
	/**
	 * @param formatter the formatter to set
	 */
	public void setFormatter(Formatter formatter) {
	
		this.formatter = formatter;
	}

	public void setPreferences(String propertyFileName) throws IOException {
		
		Preferences.setPreferences(propertyFileName);
	}

	/**
	 * Send the current dummy object and field to be get set with default value
	 * 
	 * @param Type
	 * @return The value of field which Type is passed as argument
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public Object dummyData(Type type, String fieldName)
		throws InstantiationException, IllegalAccessException,
		IllegalArgumentException, ClassNotFoundException {

		System.out.println("-->Current field type:" + getClassFullNameFromType(type));

		// If Type is a list. Return a list
		if (type.toString().toLowerCase().indexOf("list") > -1 &&
			type instanceof ParameterizedType) {

			ParameterizedType pt = (ParameterizedType) type;
			@SuppressWarnings("rawtypes")
			List tmp = new ArrayList();
			for (Type t : pt.getActualTypeArguments()) {

				String className =
					getClassFullNameFromType(t);
				System.out.println("Actual type of list:" +
					className);
				for (int j = SIZE_OF_LIST; j > 0; j--) {
					tmp.add(dummyData(Class.forName(className), fieldName));
				}
			}
			return tmp;

		}
		else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {

			IntRules rules = new IntRules(fieldName);
			return getFormatter().getDummyInteger(rules);
		}
		else if (type.equals(Long.TYPE) || type.equals(Long.class)) {

			LongRules rules = new LongRules(fieldName);
			return getFormatter().getDummyLong(rules);
		}
		else if (type.equals(String.class) || type.equals(String.class)) {

			AlphaRules rules = new AlphaRules(fieldName);
			System.out.println("fieldName:" + fieldName + ", type:" + rules.getType());
			return getFormatter().getDummyString(rules);
		}
		else if(type.equals(Boolean.TYPE) || type.equals(Boolean.class)){
			
			return (Math.random() >= .5)? true: false;
		}
		else{
			// Custom Class object will be created and returned
			Object obj = Class.forName(getClassFullNameFromType(type)).newInstance();
			// Find out all the fields of VO
			List<Field> fieldList = getAllFields(getClassFullNameFromType(type));
			for (Field f : fieldList) {

				System.out.println(f.getName() + ":" +
						f.getType().getName());
				f.setAccessible(true);
				f.set(obj, dummyData(f.getGenericType(), f.getName()));
			}
			return obj;
		}

	}
	
	/**
	 * All the fields of the class will be returned
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	private List<Field> getAllFields(String className) throws ClassNotFoundException{
		
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName(className);
		List<Field> fieldList = new ArrayList<Field>();
		Field[] inheretedFields = clazz.getFields();
		for (Field f : inheretedFields) {

			fieldList.add(f);
		}
		inheretedFields = null;
		Field[] definedFields = clazz.getDeclaredFields();
		for (Field f : definedFields) {

			fieldList.add(f);
		}
		definedFields = null;
		return fieldList;
	}
		
	/**
	 * Return full class name for the type
	 * @param type
	 * @return
	 */
	public String getClassFullNameFromType(Type type){
		
		return type.toString().replace("class ", "");
	}
}
