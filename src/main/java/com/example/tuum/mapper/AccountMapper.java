package com.example.tuum.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.tuum.model.Account;

@Mapper
public interface AccountMapper {
    @Select("select * from accounts where id=#{id}")
    Optional<Account> findById(Long id);

    @Select("""
            select a.id as account_id, a.customer_id, a.country, b.id as balance_id, b.available_amount, b.currency
            from accounts a
            left join balances b on a.id = b.account_id
            where a.id=${id}
            """)
    Account findByIdWithBalances(Long id);

    @Insert("insert into accounts(customer_id, country) values(#{customer_id}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Account account);

}
