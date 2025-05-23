/*
 * This file is generated by jOOQ.
 */
package com.dreamjob.db.jooq.tables.daos;


import com.dreamjob.db.jooq.tables.Offer;
import com.dreamjob.db.jooq.tables.records.OfferRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.16.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class OfferDao extends DAOImpl<OfferRecord, com.dreamjob.db.jooq.tables.pojos.Offer, Integer> {

    /**
     * Create a new OfferDao without any configuration
     */
    public OfferDao() {
        super(Offer.OFFER, com.dreamjob.db.jooq.tables.pojos.Offer.class);
    }

    /**
     * Create a new OfferDao with an attached configuration
     */
    @Autowired
    public OfferDao(Configuration configuration) {
        super(Offer.OFFER, com.dreamjob.db.jooq.tables.pojos.Offer.class, configuration);
    }

    @Override
    public Integer getId(com.dreamjob.db.jooq.tables.pojos.Offer object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Offer.OFFER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchById(Integer... values) {
        return fetch(Offer.OFFER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.dreamjob.db.jooq.tables.pojos.Offer fetchOneById(Integer value) {
        return fetchOne(Offer.OFFER.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.dreamjob.db.jooq.tables.pojos.Offer> fetchOptionalById(Integer value) {
        return fetchOptional(Offer.OFFER.ID, value);
    }

    /**
     * Fetch records that have <code>trader_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfTraderId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Offer.OFFER.TRADER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>trader_id IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByTraderId(Integer... values) {
        return fetch(Offer.OFFER.TRADER_ID, values);
    }

    /**
     * Fetch records that have <code>city_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfCityId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Offer.OFFER.CITY_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>city_id IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByCityId(Integer... values) {
        return fetch(Offer.OFFER.CITY_ID, values);
    }

    /**
     * Fetch records that have <code>profession_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfProfessionId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Offer.OFFER.PROFESSION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>profession_id IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByProfessionId(Integer... values) {
        return fetch(Offer.OFFER.PROFESSION_ID, values);
    }

    /**
     * Fetch records that have <code>price_unit BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfPriceUnit(String lowerInclusive, String upperInclusive) {
        return fetchRange(Offer.OFFER.PRICE_UNIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price_unit IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByPriceUnit(String... values) {
        return fetch(Offer.OFFER.PRICE_UNIT, values);
    }

    /**
     * Fetch records that have <code>wage_per_price_unit BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfWagePerPriceUnit(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Offer.OFFER.WAGE_PER_PRICE_UNIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>wage_per_price_unit IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByWagePerPriceUnit(BigDecimal... values) {
        return fetch(Offer.OFFER.WAGE_PER_PRICE_UNIT, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Offer.OFFER.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByDescription(String... values) {
        return fetch(Offer.OFFER.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(Offer.OFFER.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByStatus(String... values) {
        return fetch(Offer.OFFER.STATUS, values);
    }

    /**
     * Fetch records that have <code>created_on BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfCreatedOn(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Offer.OFFER.CREATED_ON, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_on IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByCreatedOn(LocalDateTime... values) {
        return fetch(Offer.OFFER.CREATED_ON, values);
    }

    /**
     * Fetch records that have <code>updated_on BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchRangeOfUpdatedOn(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Offer.OFFER.UPDATED_ON, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_on IN (values)</code>
     */
    public List<com.dreamjob.db.jooq.tables.pojos.Offer> fetchByUpdatedOn(LocalDateTime... values) {
        return fetch(Offer.OFFER.UPDATED_ON, values);
    }
}
