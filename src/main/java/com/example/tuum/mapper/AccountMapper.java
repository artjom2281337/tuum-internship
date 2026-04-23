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

    Account findByIdWithBalances(Long id);

    @Insert("insert into accounts(customer_id, country) values(#{customer_id}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Account account);

}
