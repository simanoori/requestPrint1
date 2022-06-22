package com.spring.myapplication.repository.jdbc;

import com.github.javafaker.Faker;
import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.CardPrintRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hi on 6/11/2022.
 */
public class CardPrintRequestCRUDJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Persistent
    EntityManager entityManager;

    public CardPrintRequestCRUDJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ExecuteTime
    public List<CardPrintRequest> addFakeDatas() {
        List<CardPrintRequest> cardPrintRequests = new ArrayList<CardPrintRequest>();
        for (int i = 0; i < 5; i++) {
            CardPrintRequest cardPrintRequest = cardPrintRequestFakeData();
            cardPrintRequests.add(cardPrintRequest);
        }
        addCardPrintRequests(cardPrintRequests);
        return cardPrintRequests;
    }

    @ExecuteTime
    public CardPrintRequest cardPrintRequestFakeData() {
        Faker fakeCardPrintRequest = new Faker();
        CardPrintRequest cardPrintRequest = new CardPrintRequest(fakeCardPrintRequest.code().imei(), fakeCardPrintRequest.code().imei() + fakeCardPrintRequest.code().asin(), fakeCardPrintRequest.code().gtin8(), fakeCardPrintRequest.internet().ipV6Address());
        return cardPrintRequest;
    }

    @ExecuteTime
    public void addFakeDateToCardPrintRequests() {
        addCardPrintRequests(addFakeDatas());
    }

    @ExecuteTime
    public void addCardPrintRequests(List<CardPrintRequest> cardPrintRequests) {
        for (CardPrintRequest cardPrintRequest : cardPrintRequests) {
            jdbcTemplate.update("INSERT INTO t_PrintRequest (c_personalCode,c_branchCode,c_cardPAN,c_ipAddress) VALUES (?,?,?,?)", cardPrintRequest.getPersonnelCode(), cardPrintRequest.getBranchCode(), cardPrintRequest.getCardPan(), cardPrintRequest.getIpAddress());
        }
    }

    @ExecuteTime
    public CardPrintRequest saveCardPrintRequest(CardPrintRequest cardPrintRequest) {
        String SQL = "INSERT INTO t_cardPrintRequest (c_PersonalCode,c_BranchCode,c_CardPAN,c_IpAddress) VALUES (?,?,?,?)";
        CardPrintRequest saveCardPrintRequest = jdbcTemplate.queryForObject(
                SQL, new Object[]{cardPrintRequest.getCardPrintRequestId()}, new CardPrintRequestMapper()
        );
        return saveCardPrintRequest;
    }

    @ExecuteTime
    public CardPrintRequest loadCardPrintRequest(CardPrintRequestId cardPrintRequestId) {
        String sql = "SELECT * FROM t_cardprintrequest WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cardPrintRequestId}, new CardPrintRequestMapper());
    }

    @ExecuteTime
    public List<CardPrintRequest> loadCardPrintRequests() {
        String sql = "SELECT * FROM t_cardprintrequest";
        return (List<CardPrintRequest>) jdbcTemplate.queryForObject(sql, new CardPrintRequestMapper());
    }

    @ExecuteTime
    public void updatePersonelCode(CardPrintRequest cardPrintRequest, CardPrintRequestId id) {
        this.jdbcTemplate.update(
                "update t_cardprintrequest set personnelCode = ? where id = ?",
                cardPrintRequest.getPersonnelCode() , id);
    }

    @ExecuteTime
    public void updateCardPan(String cardPan,CardPrintRequest cardPrintRequest) {
        this.jdbcTemplate.update(
                "update t_cardprintrequest set cardPan = ? where branchcode = ? and ipAddress = ?",
                cardPan , cardPrintRequest.getBranchCode(),cardPrintRequest.getIpAddress());
    }

}