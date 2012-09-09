package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Preferences.*;

public class LongRules extends BaseRules {

	private Long min;
	private Long max;
	
	public LongRules(){
		
	}
	
	public LongRules(String fieldName){
		
		super(fieldName);
		this.min = getMin(fieldName);
		this.max = getMax(fieldName);
	}
	/**
	 * @return the min
	 */
	public Long getMin() {
	
		return min;
	}
	
	/**
	 * @param min the min to set
	 */
	public void setMin(Long min) {
	
		this.min = min;
	}
	
	/**
	 * @return the max
	 */
	public Long getMax() {
	
		return max;
	}
	
	/**
	 * @param max the max to set
	 */
	public void setMax(Long max) {
	
		this.max = max;
	}
	
	public Long getMin(String fieldName){
		
		Long l = getLongPreference(fieldName + MIN_RANGE);
		return l != null ? l : DEFAULT_LONG_MIN_LENGTH;
	}
	
	public Long getMax(String fieldName){
		
		Long l = getLongPreference(fieldName + MAX_RANGE);
		return l != null ? l : DEFAULT_LONG_MAX_LENGTH;
	}
}
