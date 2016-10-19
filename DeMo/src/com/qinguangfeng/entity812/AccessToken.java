package com.qinguangfeng.entity812;
/**
 * 首先，要用到 网络流，NetUtils ,

 * 然后，要去微信
 * 
 * 这里是 用 工具类， 后面需要专门写在一个包里面
 */
 
import com.fasterxml.jackson.databind.JsonNode;
import com.hzit.util.NetUtils;

/**
 * 这是用来获取 微信的AccessToken 的
 * 
 * @author Administrator
 *
 */
public class AccessToken {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		try {
			NetUtils http = new NetUtils();
			String cropid = "wx56fa916da08b0108";
			String scret = "rGq6rcc8kwDHor3K7StzjTA9G37ER4M4qjdnpNjfY5aROWrqZ6-8_x7TjrEyKzn_";
			JsonNode node = http.getJson("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + cropid + "&corpsecret=" + scret);

			System.out.println(node.get("expires_in"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
