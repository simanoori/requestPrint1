package com.spring.myapplication.repository.jdbc;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.CardPrintRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hi on 6/17/2022.
 */
public class CardPrintRequestMapper implements RowMapper<CardPrintRequest> {

    @ExecuteTime
    @Override
    public CardPrintRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        CardPrintRequest cardPrintRequest = new CardPrintRequest((CardPrintRequestId) rs.getObject(0),rs.getString("cardPan"),rs.getString("personnelCode"),rs.getString("branchCode"),rs.getString("ipAddress"));
        return cardPrintRequest;
    }
}
