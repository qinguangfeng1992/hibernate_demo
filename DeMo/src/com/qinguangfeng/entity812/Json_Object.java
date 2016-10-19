package com.qinguangfeng.entity812;

import com.alibaba.fastjson.JSON;


/**
 * 这里是 用 JSON 把 原有的 字符串转化成 对象
 * 或者  把对象转化成 字符串 测试 的例子。。
 * @author Administrator
 *
 */
public class Json_Object {

	public static void main(String[] args) {
		/**将字符串 转换成   JSONObject 的对象
		 *或者叫  把字符串 转换成 JSON格式的输出
		 * 先写一个字符串，用parse方法转
		 * 接收的话 ，是一个 叫  JSONObject  的对象来接收
		 */
		//String str="{\"name\":\"张三\",\"socre\":\"78\",\"clas\":\"研发一班\"}";
		
		//JSONObject object=(JSONObject)JSON.parse(str);
		//System.out.println(object);
		
		/**
		 * 把对象转换为 JSON对象
		 * 先得有一个对象，
		 * 再将 对象转换成JSON字符串，
		 * 再把JSON字符串用ParseObject转换成 叫 JSONObject 的对象
		 * 有以下两种方法：
		 */
	
		
		/**
		 * 将对象转换成 JSON对象，的第一种写法
		 * 先new出对象，然后 再用set方法，给对象里的属性赋值，
		 * 再用JSON方法
		 * 用JSON格式输出
		 */
		/*StuLeiJson stujson=new StuLeiJson();
		stujson.setId("1");
		stujson.setScore("89");
		stujson.setClas("java");
	
		
		//将对象转换成JSON字符串，
		String s=JSON.toJSONString(stujson);
		System.out.println(s);*/
		
		/**
		 * 将对象转换成 JSON对象，的第二种写法
		 * 或者说JSON字符串 转换 成  已经有的 封装类的  对象
		 * 先 写 对象里面的 JSON格式 的字符串，给与属性赋值
		 * 再用方法，
		 * 用JSON格式输出
		 */
		/*String stu="{\"name1\":\"周海\",\"id\":\"9\",\"score\":\"89\",\"clas\":\"sql\",}";
		
		StuLeiJson clazz=(StuLeiJson)JSON.parseObject(stu, StuLeiJson.class);
		//===转换成 对象之后，然后掉 类里面的方法
		clazz.show();
		*/	
		
		
		

	}

}
