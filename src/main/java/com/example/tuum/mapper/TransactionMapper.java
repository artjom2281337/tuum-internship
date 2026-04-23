package com.example.tuum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.tuum.model.Transaction;

@Mapper
public interface TransactionMapper {
    @Select("select * from transactions where account_id=#{account_id} order by id asc")
    List<Transaction> findByAccountId(Long account_id);

    @Insert("insert into transactions(account_id, amount, currency, direction, description, balance_after_transaction) values(#{account_id}, #{amount}, #{currency}, #{direction}, #{description}, #{balance_after_transaction})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Transaction transaction);
}
