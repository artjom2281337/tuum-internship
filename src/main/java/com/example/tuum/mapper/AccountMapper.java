package com.example.tuum.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.tuum.model.Account;

@Mapper
public interface AccountMapper {
    @Select("select * from accounts where id=#{id}")
    Optional<Account> findById(Long id);

    Account findByIdWithBalances(Long id);

    @Insert("insert into accounts(customer_id, country) values(#{customerId}, #{country})")
    void insert(Account account);

}
