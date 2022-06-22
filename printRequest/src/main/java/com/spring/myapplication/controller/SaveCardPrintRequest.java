package com.spring.myapplication.controller;

import com.spring.myapplication.model.entity.ActivityLog;
import com.spring.myapplication.model.entity.CardPrintRequest;
import com.spring.myapplication.service.ActivityLogService;
import com.spring.myapplication.service.CardPrintRequestService;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hi on 6/20/2022.
 */
@ServletComponentScan("/save.do")
public class SaveCardPrintRequest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardPrintRequest cardPrintRequest = new CardPrintRequest(req.getParameter("name"), req.getParameter("lastName")
                , req.getParameter("identityNumber"), req.getParameter("nameOfFather"));

        try {
            CardPrintRequestService cardPrintRequestService = new CardPrintRequestService();
            cardPrintRequestService.insertCardPrintRequest(cardPrintRequest);
            ActivityLog activityLog = new ActivityLog("insertCardPrintRequest", cardPrintRequest.getPersonnelCode(), cardPrintRequest.getCardPan());
            ActivityLogService activityLogService = new ActivityLogService();
            activityLogService.insertActivityLog(activityLog);
            resp.sendRedirect("/showcardprintrequest.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
