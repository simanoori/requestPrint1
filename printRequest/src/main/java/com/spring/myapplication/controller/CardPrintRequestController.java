package com.spring.myapplication.controller;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.exception.NotFoundException;
import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.ActivityLog;
import com.spring.myapplication.model.entity.CardPrintRequest;
import com.spring.myapplication.repository.custom.CardPrintRequestCustomImpl;
import com.spring.myapplication.service.ActivityLogService;
import com.spring.myapplication.service.CardPrintRequestService;
import com.spring.myapplication.valueObject.CardPrintRequestVO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hi on 6/18/2022.
 */
@RestController
public class CardPrintRequestController {
    CardPrintRequestService cardPrintRequestService;
    ActivityLogService activityLogService;
    Logger logger = LoggerFactory.getLogger(CardPrintRequestController.class);

    @PatchMapping("/cardprintrequestresource/{id}")
    @ExecuteTime
    public ResponseEntity<?> updateResource(@RequestBody @Valid CardPrintRequest cardPrintRequest,
                                            @PathVariable("id") CardPrintRequestId id) {
        cardPrintRequestService.updatePersonelCode(cardPrintRequest, id);
        ActivityLog activityLog = new ActivityLog("updatePersonelCode", cardPrintRequest.getPersonnelCode(), cardPrintRequest.getCardPan());
        activityLogService.insertActivityLog(activityLog);
        return ResponseEntity.ok("resource saved");
    }

    @PostMapping("/postbody")
    @ExecuteTime
    public CardPrintRequest saveResource(@RequestBody @Valid CardPrintRequestVO cardPrintRequestVO) {
        CardPrintRequest newCardPrintRequest = new CardPrintRequest();
        CardPrintRequest cardPrintRequest = new CardPrintRequest();

        try {
            if (cardPrintRequestVO == null)
                throw new NotFoundException("card PrintRequest Not Found");
            cardPrintRequest = new CardPrintRequest(cardPrintRequestVO.getCardPan(), cardPrintRequestVO.getPersonnelCode(), cardPrintRequestVO.getBranchCode(), cardPrintRequestVO.getIpAddress());
            newCardPrintRequest = cardPrintRequestService.insertCardPrintRequest(cardPrintRequest);
            ActivityLog activityLog = new ActivityLog("insertCardPrintRequest", cardPrintRequestVO.getPersonnelCode(), cardPrintRequestVO.getCardPan());
            activityLogService.insertActivityLog(activityLog);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return newCardPrintRequest;

    }

    @GetMapping(value = "/cardprintrequests")
    @ExecuteTime
    public List<CardPrintRequest> getCardPrintRequest() {
        List<CardPrintRequest> cardPrintRequests = new ArrayList<CardPrintRequest>();
        try {
            cardPrintRequests = cardPrintRequestService.loadCardPrintRequests();
            if (cardPrintRequests.size() == 0)
                throw new NotFoundException("PrintRequests NotFound");
        } catch (NotFoundException e) {
            logger.info(e.getMessage());
        }
        return cardPrintRequests;
    }

    @PutMapping("/updatecardprintrequest")
    @ExecuteTime
    public ResponseEntity<?> updateResourceForPut(@PathVariable @Valid String cardPan, @org.springframework.web.bind.annotation.RequestBody @Valid CardPrintRequest cardPrintRequest) {
        cardPrintRequestService.updateCardPan(cardPan, cardPrintRequest);
        ActivityLog activityLog = new ActivityLog("c", cardPrintRequest.getPersonnelCode(), cardPan);
        activityLogService.insertActivityLog(activityLog);
        return ResponseEntity.ok("resource updated");
    }


}
