package com.demo.service;

import com.demo.domain.Account;
import com.demo.persitence.AccountRepository;
import com.demo.util.EncryptUtils;
import com.demo.util.JSONResult;
import com.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 32050
 */
@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public JSONResult<HashMap<String, Object>> login(Map<String, Object> obj, Object captcha) {
        if (!captcha.equals(obj.get("code"))) {
            return new JSONResult<>(403, "验证码错误", null);
        }
        Account account =this.accountRepository.findAccountByUsernameAndPassword((String) obj.get("username"), EncryptUtils.encrypt((String) obj.get("password")));
        if (account == null) {
            return new JSONResult<>(403, "密码错误或账号不存在", null);
        } else {
            String token = TokenUtil.sign((String) obj.get("username"));
            HashMap<String, Object> hs = new HashMap<>();
            hs.put("token", token);
            hs.put("account", account);
            return new JSONResult<>(200, "登录成功", hs);
        }
    }

    @Override
    public JSONResult<Account> register(Account account) {
        if (this.accountRepository.findAccountByUsername(account.getUsername()) != null) {
            return new JSONResult<>(403, "账户已存在", null);
        }
        account.setPassword(EncryptUtils.encrypt(account.getPassword()));
        return new JSONResult<>(200, "注册成功", this.accountRepository.save(account));
    }

    @Override
    public JSONResult<Account> updateAccount(Account account) {
        return new JSONResult<>(200, "注册成功", this.accountRepository.save(account));
    }

    @Override
    public JSONResult<Object> passwd(Map<String, Object> obj, String phoneCode) {
        return null;
    }
}
