package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Util.*;

public class Formatter {

	private DataGenerator dataGenerator;
	
	
	/**
	 * @return the dataGenerator
	 */
	public DataGenerator getDataGenerator() {
	
		return dataGenerator;
	}

	
	/**
	 * @param dataGenerator the dataGenerator to set
	 */
	public void setDataGenerator(DataGenerator dataGenerator) {
	
		this.dataGenerator = dataGenerator;
	}

	public String getDummyString(AlphaRules rules){
		
		String toReturn = rules.getFormat();
		if(rules.getType().equals(EMAIL_TYPE)){
			
			toReturn = getDataGenerator().getDefaultEmail();
		}else if(rules.getType().equals(SENTENCE_TYPE)){
			
			int sentenceLength = randomInt(rules.getMin(), rules.getMax());
			StringBuffer sb = new StringBuffer();
			while(sentenceLength > 0){
				
				int wordLength = randomInt(1, rules.getWordLength());
				sentenceLength = sentenceLength - wordLength;
				sb.append(getDataGenerator().generateWord(wordLength))
				.append(" ");
			}
			toReturn = toReturn.replaceAll(DATA_VAR, sb.toString());
			
		}else{

			int wordLength = randomInt(1, rules.getWordLength());
			String tmp = getDataGenerator().generateWord(wordLength);			
			toReturn = toReturn.replaceAll(DATA_VAR, tmp);
			System.out.println("tmp:" +tmp +", toReturn:" +toReturn);
		}		
		return toReturn;
	}
	
	public Integer getDummyInteger(IntRules rules){
		
		return randomInt(rules.getMin(), rules.getMax());
	}
	
	public Long getDummyLong(LongRules rules){
		
		return randomLong(rules.getMin(), rules.getMax());
	}	
	
	public Boolean getDummyBoolean(){
		
		return  (Math.random() >= .5)? true: false;
	}
}
