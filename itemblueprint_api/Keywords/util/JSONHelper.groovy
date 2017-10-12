package util

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import com.kms.katalon.core.annotation.Keyword

public class JSONHelper {
	@Keyword
	public static String getValueOfProperty(String jsonStr, String property){

		try{

			if(isIndexOfArray(property)){
				JSONArray jsonArr = new JSONArray(jsonStr);
				int index = getIndex(property);
				return jsonArr.get(index);
			} else {
				String[] properties = property.split("\\.");
				int size = properties.length;

				if(size == 0){
					JSONObject jsonObject  = new JSONObject(jsonStr);
					return jsonObject.get(property);
				} else {
					JSONObject jsonObject;
					JSONArray jsonArr;
					Object obj;
					for(int i = 0; i < size; i++){
						if(isIndexOfArray(properties[i])){
							if(i == 0){
								jsonArr = new JSONArray(jsonStr);
							} else {
								jsonArr = (JSONArray) obj;
							}
							obj = jsonArr.get(getIndex(properties[i]));
						} else {
							if(i == 0){
								jsonObject = new JSONObject(jsonStr);
							} else {
								jsonObject = (JSONObject) obj;
							}
							obj = jsonObject.get(properties[i]);
						}

						if(i == size-1){
							return obj;
						}
					}
				}
			}
		} catch(JSONException e){
			e.printStackTrace();
			return 'undefined';
		} catch(Exception e){
			e.printStackTrace();
			return 'Error occurs';
		}

		return 'undefined';
	}
	
	static private int getIndex(String str){
		int length = str.length();
		return Integer.parseInt(str.substring(1, length-1));
	}
	
	static private boolean isIndexOfArray(String arg){
		arg = arg.trim();
		int length = arg.length();
		if (arg.charAt(0) == '[' && arg.charAt(length - 1) == ']' && isNumber(arg.substring(1, length - 1))) {
			return true;
		} else {
			return false;
		}
	}

	static private boolean isNumber(String str){
		boolean result = true;
		try{
			Integer.parseInt(str);
		} catch (Exception e){
			result = false;
		}
		return result;
	}
	
}
