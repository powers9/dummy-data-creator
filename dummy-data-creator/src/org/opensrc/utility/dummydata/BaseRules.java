
package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Preferences.*;

public abstract class BaseRules {

	private String type;
	private String format;
	
	public BaseRules(){
		
	}
	
	public BaseRules(String fieldName){
		
		this.format = getFormat(fieldName);
		this.type = getType(fieldName);
	}
	/**
	 * @return the type
	 */
	public String getType() {
	
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
	
		this.type = type;
	}
	
	/**
	 * @return the format
	 */
	public String getFormat() {
	
		return format;
	}
	
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
	
		this.format = format;
	}
	
	public String getFormat(String fieldName){
		
		String toReturn = getStringPreference(fieldName + FORMAT);
		return toReturn != null? toReturn : DEFAULT_ALPHA_FORMAT;
	}
	
	public String getType(String fieldName){
		
		return getStringPreference(fieldName + DATA_TYPE);
	}
}
