package cn.testrunner.coolweather.util;

import android.text.TextUtils;
import cn.testrunner.coolweather.db.City;
import cn.testrunner.coolweather.db.Country;
import cn.testrunner.coolweather.db.Province;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 用于解析和处理服务器返回的响应结果
 *
 * @author lujichao
 * @version 1
 * @since 2020/8/8
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     *
     * @param response 服务器返回的Json格式的数据
     * @return 解析结果
     */
    public static boolean handleProvincesResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @param response  服务器返回的结果
     * @param provinceId 省份id
     * @return 返回成功或者失败
     */
    public static boolean handleCitiesResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @param response 服务器返回的县级信息
     * @param cityId 城市id
     * @return 返回保存成功还是失败
     */
    public static boolean handleCountriesResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCountries = new JSONArray(response);
                for (int i = 0; i < allCountries.length(); i++) {
                    JSONObject countryObject = allCountries.getJSONObject(i);
                    Country country = new Country();
                    country.setWeatherId(countryObject.getInt("weather_id"));
                    country.setCountryName(countryObject.getString("name"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
