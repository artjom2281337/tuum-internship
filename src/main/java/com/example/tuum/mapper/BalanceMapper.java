package com.example.tuum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.tuum.model.Balance;

@Mapper
public interface BalanceMapper {

    @Select("select * from balances where account_id=#{accountId}")
    List<Balance> findById(Long accountId);

    @Select("select * from balances where account_id=#{accountId} and currency=#{currency}")
    Balance findByIdAndCurrency(@Param("account_id") Long accountId, @Param("currency") String currency);

    @Insert("insert into balances(account_id, available_amount, currency) values(#{accountId}, #{availableAmount}, #{currency})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Balance balance);

    @Update("update balances set available_amount=#{availableAmount} where id=#{id}")
    void update(Balance balance);
}
