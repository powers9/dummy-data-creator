
package org.opensrc.utility.dummydata;

import java.io.IOException;
import java.util.Properties;

public class Preferences {

	private static Properties preferences = null;
	private static boolean isPreferencesSet = false;

	/**
	 * @return the preferences
	 */
	public static Properties getPreferences() {

		return preferences;
	}

	/**
	 * @param preferences
	 *            the preferences to set
	 */
	public static void setPreferences(Properties preferences) {

		Preferences.preferences = preferences;
	}

	public static void setPreferences(String propertyFileName)
		throws IOException {

		Preferences.preferences = new Properties();
		ClassLoader classLoader =
			Preferences.class.getClassLoader();
		preferences.load(classLoader.getResourceAsStream(propertyFileName));
		isPreferencesSet = true;
	}

	public static Integer getIntPreference(String property) {

		if (isPreferencesSet) {

			Integer toReturn = null;
			try {

				toReturn =
					Integer.parseInt(
						getPreferences().getProperty(property),
						10);
			}
			catch (NumberFormatException e) {

				toReturn = null;
			}
			return toReturn;
		}
		else {
			return null;
		}
	}

	public static Long getLongPreference(String property) {

		if (isPreferencesSet) {

			Long toReturn = null;
			try{
				
				toReturn = Long.parseLong(
					getPreferences().getProperty(property), 10);
			}catch(NumberFormatException e){
				
				toReturn = null;
			}
			return toReturn;
		}
		else {
			return null;
		}
	}

	public static String getStringPreference(String property) {

		if (isPreferencesSet) {
			return getPreferences().getProperty(property);
		}
		else {
			return null;
		}
	}

}
