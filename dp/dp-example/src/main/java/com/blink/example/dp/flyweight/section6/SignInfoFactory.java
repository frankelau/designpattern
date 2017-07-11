package com.blink.example.dp.flyweight.section6;

import java.util.HashMap;


/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class SignInfoFactory {
	//������
	private static HashMap<String,SignInfo> pool = new HashMap<String,SignInfo>();

	
	//�ӳ��л�ö���
	public static SignInfo getSignInfo(String key){
		//���÷��ض���
		SignInfo result = null;
		//����û�иö������������������
		if(!pool.containsKey(key)){

			result = new SignInfo4Pool(key);
			pool.put(key, result);
		}else{
			result = pool.get(key);

		}
		return result;
	}
}