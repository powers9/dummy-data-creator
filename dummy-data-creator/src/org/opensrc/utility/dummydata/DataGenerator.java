package org.opensrc.utility.dummydata;

import static org.opensrc.utility.dummydata.Constants.*;
import static org.opensrc.utility.dummydata.Preferences.*;
import static org.opensrc.utility.dummydata.Util.*;

import java.util.Date;

public class DataGenerator {

	private String longRandomString;
	private static Integer veryLargeValue;
	
	public String generateWord(int wordLength){
		
		if(longRandomString == null){
			
			veryLargeValue = 
				DEFAULT_STRING_MAX_LENGTH;
			StringBuffer buffer = new StringBuffer();
			String consonants = getStringPreference(CONSONANTS);
			consonants = consonants != null ? consonants : DEFAULT_CONSONANTS;
			String vowels = getStringPreference(VOWELS);
			vowels = vowels != null ? vowels : DEFAULT_VOWELS;
			String[] consoSet = consonants.split("");
			String[] vowelSet = vowels.split(""); 
			int consoSetSize = consoSet.length;
			int vowelSetSize = vowelSet.length;
			
			for(int i = veryLargeValue, j=0; i > 0; i--){
				if(j>=2){
					
					j = 0;
					buffer.append(vowelSet[randomInt(vowelSetSize)]);
				}else{
					
					j++;
					buffer.append(consoSet[randomInt(consoSetSize)]);					
				}
			}
			this.longRandomString = buffer.toString();
			veryLargeValue = longRandomString.length();
		}
		
		if(veryLargeValue <= wordLength){
			
			wordLength = DEFAULT_WORD_LENGTH;
		}
		
		int beginIndex = randomInt(veryLargeValue - wordLength);
		int endIndex = beginIndex + wordLength;
		return longRandomString.substring(beginIndex, endIndex);
//		System.out.println("beginIndex:" +beginIndex +", endIndex:" + endIndex +  ", veryLargeValue:" +veryLargeValue + ", longRandomString:" +longRandomString.length());
//		if(beginIndex < veryLargeValue && endIndex < veryLargeValue){
//			
//			return longRandomString.substring(beginIndex, endIndex);
//		}else{
//			return longRandomString.substring(10, 15);
//		}

	}
	
	public Date getDefaultDate(){
		
		return null;
	}

	public String getDefaultEmail(){
		
		return new StringBuffer()
			.append(generateWord(DEFAULT_EMAIL_PREFIX_LENGTH))
			.append("@")
			.append(generateWord(DEFAULT_EMAIL_SUFFIX_LENGTH))
			.append(".com")
			.toString();
	}	
}
