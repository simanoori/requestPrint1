package com.spring.myapplication.repository.custom;

import com.spring.myapplication.aspect.ExecuteTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Hi on 6/11/2022.
 */
@Repository
public class CardPrintRequestCustomImpl implements CardPrintRequestCustom,BeanPostProcessor {

    Logger logger = LoggerFactory.getLogger(CardPrintRequestCustomImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @ExecuteTime
        public List<String> getIpAddressesByBranchCode(String branchCode) {
        Query query = entityManager.createQuery("SELECT cpr.ipAddress FROM CardPrintRequest cpr WHERE cpr.branchCode =:branchCode");
        query.setParameter("branchCode", branchCode);
        return query.getResultList();
    }

    @ExecuteTime
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("bean before initialize");
        return bean;
    }

    @ExecuteTime
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("bean after initialize");
        return bean;
    }
}
