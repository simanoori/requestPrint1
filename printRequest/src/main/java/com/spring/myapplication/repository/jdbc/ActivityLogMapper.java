package com.spring.myapplication.repository.jdbc;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.ActivityLog;
import com.spring.myapplication.model.entity.CardPrintRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Hi on 6/18/2022.
 */
public class ActivityLogMapper implements RowMapper<ActivityLog>{
    @ExecuteTime
    @Override
    public ActivityLog mapRow(ResultSet rs, int rowNum) throws SQLException {
        ActivityLog activityLog = new ActivityLog(rs.getString("name"),rs.getString("personalCode"),rs.getString("cardPan"));
        return activityLog;
    }
}
