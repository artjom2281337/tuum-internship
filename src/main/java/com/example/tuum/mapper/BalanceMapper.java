package com.example.tuum.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.tuum.model.Balance;

@Mapper
public interface BalanceMapper {

    @Select("select * form balances where account_id=#{account_id}")
    List<Balance> findById(Long account_id);

    @Select("select * from balances where account_id#{account_id} and currency=#{currency}")
    Optional<Balance> findByIdAndCurrency(@Param("account_id") Long account_id, @Param("currency") String currency);

    @Insert("insert into balances(account_id, available_amount, currency) values(#{account_id}, #{available_amount}, #{currency})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Balance balance);

    @Update("update balances set available_amount=#{available_amount} where id=#{id}")
    void update(Balance balance);
}
