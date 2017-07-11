package com.blink.web.interfaces;

import com.blink.web.bean.ResultEnum;

/**
 * 业务逻辑类接口
 *
 * @param <T>
 */
public interface ILogic<T> {
    ResultEnum exec(T t);
}
