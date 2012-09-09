package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Preferences.getIntPreference;
import static org.opensrc.utility.dummydata.Preferences.getStringPreference;


public class AlphaRules extends BaseRules {

	private Integer min;
	private Integer max;
	private Integer wordLength;
	
	
	/**
	 * @return the wordLength
	 */
	public Integer getWordLength() {
	
		return wordLength;
	}

	
	/**
	 * @param wordLength the wordLength to set
	 */
	public void setWordLength(Integer wordLength) {
	
		this.wordLength = wordLength;
	}

	public AlphaRules(){
		
	}
	
	public AlphaRules(String fieldName){
		
		super(fieldName);
		this.min = getMin(fieldName);
		this.max = getMax(fieldName);
		this.wordLength = getWordLength(fieldName);
		getType(fieldName);
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
		return i != null ? i : DEFAULT_SENTENCE_MIN_LENGTH;
	}	
	
	public Integer getMax(String fieldName){
		
		Integer i = getIntPreference(fieldName + MAX_RANGE);
		return i != null ? i : DEFAULT_SENTENCE_MAX_LENGTH;
	}
	
	public Integer getWordLength(String fieldName){
		
		Integer i = getIntPreference(fieldName + WORD_LENGTH);
		return i != null ? i : DEFAULT_WORD_LENGTH;
	}


	/* (non-Javadoc)
	 * @see org.opensrc.utility.dummydata.BaseRules#getType(java.lang.String)
	 */
	@Override
	public String getType(String fieldName) {

		String type = getStringPreference(fieldName + DATA_TYPE);
		System.out.println("-->fieldName:" + fieldName + ", type:" + type);
		if(type != null){
			setType(type);
		}else{
			
			setType(DEFAULT_ALPHA_TYPE);
		}
		return getType();
	}
	
}
