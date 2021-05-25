package com.demo.service;

import com.demo.domain.Account;
import com.demo.util.JSONResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 32050
 */
public interface AccountService {
    /**
     * 用户登入
     * @param obj
     * @param captcha
     * @return
     */
    JSONResult<HashMap<String, Object>> login(Map<String, Object> obj, Object captcha);
    JSONResult<Account> register(Account account);
    JSONResult<Account> updateAccount(Account account);
    JSONResult<Object> passwd(Map<String,Object> obj, String phoneCode);

}
