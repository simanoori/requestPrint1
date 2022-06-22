package com.spring.myapplication.service;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.entity.ActivityLog;
import com.spring.myapplication.model.entity.CardPrintRequest;
import com.spring.myapplication.repository.jdbc.ActivityLogCRUDJDBC;

import javax.transaction.Transactional;

/**
 * Created by Hi on 6/18/2022.
 */
public class ActivityLogService {
    ActivityLogCRUDJDBC activityLogCRUDJDBC;
    @ExecuteTime
    @Transactional
    public ActivityLog insertActivityLog(ActivityLog activityLog){
        ActivityLog saveactivityLog= activityLogCRUDJDBC.saveactivityLog(activityLog);
        return saveactivityLog;
    }
}
