package com.blink.example.mvc.controller;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blink.example.mvc.view.ViewManager;
import com.blink.example.mvc.action.ActionDispather;
import com.blink.example.mvc.action.IActionDispather;
import com.blink.example.mvc.helper.ValueStackHelper;
import com.blink.example.mvc.valuestack.ValueStack;


/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class FilterDispather implements Filter {
	//����һ��ֵջ������
	private ValueStackHelper valueStackHelper = new ValueStackHelper();
	//Ӧ��IActionDispather
	IActionDispather actionDispather = new ActionDispather();
	
	
	//server����ʱҪ��������
	public void destroy() {

	}

	//����������ʵ�ֵ�
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		//ת��ΪHttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//���ݵ���������������
		chain.doFilter(req, res);
		//��ô�HTTP�����ACTION����
		String actionName = getActionNameFromURI(req);		
		//��ViewManager��Ӧ��
		ViewManager viewManager = new ViewManager(actionName);
		//���в�������ֵջ
		ValueStack  valueStack = valueStackHelper.putIntoStack(req);
		//�����е����󴫵ݸ�ActionDispatcher����
		String result =actionDispather.actionInvoke(actionName);
		String viewPath = viewManager.getViewPath(result);
		//ֱ��ת��
		RequestDispatcher rd = req.getRequestDispatcher(viewPath);
		rd.forward(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		/*
		 * 1�����XML�����ļ��Ƿ���ȷ
		 * 2��������س��򣬹۲������ļ��Ƿ���ȷ
		 */
	}
	
	//ͨ��url���actionName
	private String getActionNameFromURI(HttpServletRequest req){
		String path = (String) req.getRequestURI();
		String actionName = path.substring(path.lastIndexOf("/") + 1,path.lastIndexOf("."));
		return actionName;
	}
	
}
