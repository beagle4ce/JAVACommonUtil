package com.yunyao.mocha.commons.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.common.base.Charsets;

/**
 * 
 * @author gf
 * @date 2016-04-28
 * @desc HttpClient最新版Demo演示(仅演示了Post)
 * 
 */
public final class HttpClientDemo {
	
	/**
	 * 默认超时时间
	 */
	private static final int defaultTimeout = 1000 * 5;
	
	private static RequestConfig defaultConfig = RequestConfig.custom().
													setSocketTimeout(defaultTimeout).
													setConnectTimeout(defaultTimeout).
													setConnectionRequestTimeout(defaultTimeout).
													build();
	
	private static final Header[] EMPTY_HEADERS = {};
	
	/**
	 * 换行符
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * @param uri
	 * @param body 文本请求体
	 * @param headers
	 */
	public static String post(String uri, String body, Header[] headers) throws Exception {
		return post(uri, new StringEntity(body, Charsets.UTF_8), headers);
	}
	
	/**
	 * @param uri
	 * @param body 文本请求体
	 */
	public static String post(String uri, String body) throws Exception {
		return post(uri, body, EMPTY_HEADERS);
	}
	
	/**
	 * @param uri
	 * @param params 参数键值对
	 * @param headers
	 */
	public static String post(String uri, Map<String, String> params, Header[] headers) throws Exception {
		List<NameValuePair> nvs = Collections.emptyList();
		if (MapUtils.isEmpty(params)) {
			return post(uri, new UrlEncodedFormEntity(nvs, Charsets.UTF_8), headers);
		} else {
			nvs = new ArrayList<NameValuePair>(params.size());
			for (String key : params.keySet()) {
				nvs.add(new BasicNameValuePair(key, params.get(key)));
			}
		}
		return post(uri, new UrlEncodedFormEntity(nvs, Charsets.UTF_8), headers);
	}
	
	/**
	 * @param uri
	 * @param params 参数键值对
	 */
	public static String post(String uri, Map<String, String> params) throws Exception {
		return post(uri, params, EMPTY_HEADERS);
	}
	
	private static String post(String uri, HttpEntity entity, Header[] headers) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(uri);
		if (entity != null) {
			httpPost.setEntity(entity);
		}
		httpPost.setConfig(defaultConfig);
		if (ArrayUtils.isNotEmpty(headers)) {
			httpPost.setHeaders(headers);
		}
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				String message = new StringBuilder().append("HTTP状态码异常(").append(statusCode).append(')').
						append(LINE_SEPARATOR).append("URI : ").append(uri).
						append(LINE_SEPARATOR).append("BODY : ").append(entity).
						append(LINE_SEPARATOR).append("HEADERS : ").append(ArrayUtils.toString(headers)).toString();
				System.err.println(message);
				throw new IllegalStateException("HTTP状态码异常(" + statusCode + ")");
			}
			return EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
		} finally {
			IOUtils.closeQuietly(response);
			IOUtils.closeQuietly(httpClient);
		}
	}
	
	@Test
	public void post() {
		String uri = "http://json.cn/";
		Map<String, String> params = new HashMap<String, String>();
		try {
			String result = post(uri, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
