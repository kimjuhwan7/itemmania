package com.itemmania.repository;

import com.itemmania.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TradeRepository extends JpaRepository<TradeEntity,Integer> {

    List<TradeEntity> findByTradeIsSuccessTrueAndSellerNum_UserNumAndTradeTimeBetween(int userNum, LocalDate tradeTimeStart, LocalDate tradeTimeEnd);

    List<TradeEntity> findByTradeIsSuccessTrueAndConsumerNum_UserNumAndTradeTimeBetween(int userNum, LocalDate tradeTimeStart, LocalDate tradeTimeEnd);

}