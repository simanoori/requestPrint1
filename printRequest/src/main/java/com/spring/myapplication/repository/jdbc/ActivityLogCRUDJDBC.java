package com.spring.myapplication.repository.jdbc;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.entity.ActivityLog;
import com.spring.myapplication.model.entity.CardPrintRequest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Hi on 6/18/2022.
 */
public class ActivityLogCRUDJDBC {
    JdbcTemplate jdbcTemplate;
    @ExecuteTime
    public ActivityLog saveactivityLog(ActivityLog activityLog) {
        String SQL = "INSERT INTO t_activitylog (c_name,c_personalcode,c_cardpan,c_applicationtype) VALUES (?,?,?,?)";
        ActivityLog saveActivityLog = jdbcTemplate.queryForObject(
                SQL, new Object[]{activityLog.getId()}, new ActivityLogMapper()
        );
        return saveActivityLog;
    }


}
