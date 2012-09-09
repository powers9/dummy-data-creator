package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Preferences.*;

public class IntRules extends BaseRules {

	private Integer min;
	private Integer max;
	
	public IntRules(){
		
	}
	
	public IntRules(String fieldName){
		super(fieldName);
		this.min = getMin(fieldName);
		this.max = getMax(fieldName);
	}
	/**
	 * @return the min
	 */
	public Integer getMin() {
	
		return min;
	}
	
	/**
	 * @param min the min to set
	 */
	public void setMin(Integer min) {
	
		this.min = min;
	}
	
	/**
	 * @return the max
	 */
	public Integer getMax() {
	
		return max;
	}
	
	/**
	 * @param max the max to set
	 */
	public void setMax(Integer max) {
	
		this.max = max;
	}

	public Integer getMin(String fieldName){
		
		Integer i = getIntPreference(fieldName + MIN_RANGE);
		return i != null ? i : DEFAULT_INT_MIN_LENGTH;
	}	
	
	public Integer getMax(String fieldName){
		
		Integer i = getIntPreference(fieldName + MAX_RANGE);
		return i != null ? i : DEFAULT_INT_MAX_LENGTH;
	}
}
