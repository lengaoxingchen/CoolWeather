package cn.testrunner.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 封装Http请求,用于发送请求获取数据
 *
 * @author lujichao
 * @version 1
 * @since 2020/8/8
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
