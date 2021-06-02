package com.demo.persitence;

import com.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 32050
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    /**
     * 通过username与password查找账户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回账户信息，如果没找到则返回null
     */
    Account findAccountByUsernameAndPassword(String username, String password);

    /**
     * 同各国username查找账户信息
     * @param username 用户名
     * @return 返回账户信息，如果没有找到则返回null
     */
    Account findAccountByUsername(String username);

}
