package com.qinguangfeng.entity812;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * 这是 测试 用JSON  把之前的 增删查改 的 例子  转换成 集合
 * @author Administrator
 *
 */
public class Json_Aarray {

	public static void main(String[] args) {
		try {
			DealXml dealXml=new DealXml();
			List<StuLeiJson> data=dealXml.selectAll();//==有了一个集合
			
			
			//===将集合 转换成为 JSON字符串
			 
			String str=JSON.toJSONString(data);
		//====== 把字符串 转化成 JSON集合。。
			JSONArray array=JSON.parseArray(str);
			
			System.out.println(array);
			//解决了，就是乱码没搞完。。
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
