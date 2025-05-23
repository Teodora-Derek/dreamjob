/*
 * This file is generated by jOOQ.
 */
package com.dreamjob.db.jooq.tables.records;


import com.dreamjob.db.jooq.tables.Offer;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


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
public class OfferRecord extends UpdatableRecordImpl<OfferRecord> implements Record10<Integer, Integer, Integer, Integer, String, BigDecimal, String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>offer.id</code>.
     */
    public OfferRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>offer.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>offer.trader_id</code>.
     */
    public OfferRecord setTraderId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>offer.trader_id</code>.
     */
    public Integer getTraderId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>offer.city_id</code>.
     */
    public OfferRecord setCityId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>offer.city_id</code>.
     */
    public Integer getCityId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>offer.profession_id</code>.
     */
    public OfferRecord setProfessionId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>offer.profession_id</code>.
     */
    public Integer getProfessionId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>offer.price_unit</code>.
     */
    public OfferRecord setPriceUnit(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>offer.price_unit</code>.
     */
    public String getPriceUnit() {
        return (String) get(4);
    }

    /**
     * Setter for <code>offer.wage_per_price_unit</code>.
     */
    public OfferRecord setWagePerPriceUnit(BigDecimal value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>offer.wage_per_price_unit</code>.
     */
    public BigDecimal getWagePerPriceUnit() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>offer.description</code>.
     */
    public OfferRecord setDescription(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>offer.description</code>.
     */
    public String getDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>offer.status</code>.
     */
    public OfferRecord setStatus(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>offer.status</code>.
     */
    public String getStatus() {
        return (String) get(7);
    }

    /**
     * Setter for <code>offer.created_on</code>.
     */
    public OfferRecord setCreatedOn(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>offer.created_on</code>.
     */
    public LocalDateTime getCreatedOn() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>offer.updated_on</code>.
     */
    public OfferRecord setUpdatedOn(LocalDateTime value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>offer.updated_on</code>.
     */
    public LocalDateTime getUpdatedOn() {
        return (LocalDateTime) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Integer, Integer, Integer, String, BigDecimal, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Integer, Integer, Integer, String, BigDecimal, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Offer.OFFER.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Offer.OFFER.TRADER_ID;
    }

    @Override
    public Field<Integer> field3() {
        return Offer.OFFER.CITY_ID;
    }

    @Override
    public Field<Integer> field4() {
        return Offer.OFFER.PROFESSION_ID;
    }

    @Override
    public Field<String> field5() {
        return Offer.OFFER.PRICE_UNIT;
    }

    @Override
    public Field<BigDecimal> field6() {
        return Offer.OFFER.WAGE_PER_PRICE_UNIT;
    }

    @Override
    public Field<String> field7() {
        return Offer.OFFER.DESCRIPTION;
    }

    @Override
    public Field<String> field8() {
        return Offer.OFFER.STATUS;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return Offer.OFFER.CREATED_ON;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return Offer.OFFER.UPDATED_ON;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getTraderId();
    }

    @Override
    public Integer component3() {
        return getCityId();
    }

    @Override
    public Integer component4() {
        return getProfessionId();
    }

    @Override
    public String component5() {
        return getPriceUnit();
    }

    @Override
    public BigDecimal component6() {
        return getWagePerPriceUnit();
    }

    @Override
    public String component7() {
        return getDescription();
    }

    @Override
    public String component8() {
        return getStatus();
    }

    @Override
    public LocalDateTime component9() {
        return getCreatedOn();
    }

    @Override
    public LocalDateTime component10() {
        return getUpdatedOn();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getTraderId();
    }

    @Override
    public Integer value3() {
        return getCityId();
    }

    @Override
    public Integer value4() {
        return getProfessionId();
    }

    @Override
    public String value5() {
        return getPriceUnit();
    }

    @Override
    public BigDecimal value6() {
        return getWagePerPriceUnit();
    }

    @Override
    public String value7() {
        return getDescription();
    }

    @Override
    public String value8() {
        return getStatus();
    }

    @Override
    public LocalDateTime value9() {
        return getCreatedOn();
    }

    @Override
    public LocalDateTime value10() {
        return getUpdatedOn();
    }

    @Override
    public OfferRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public OfferRecord value2(Integer value) {
        setTraderId(value);
        return this;
    }

    @Override
    public OfferRecord value3(Integer value) {
        setCityId(value);
        return this;
    }

    @Override
    public OfferRecord value4(Integer value) {
        setProfessionId(value);
        return this;
    }

    @Override
    public OfferRecord value5(String value) {
        setPriceUnit(value);
        return this;
    }

    @Override
    public OfferRecord value6(BigDecimal value) {
        setWagePerPriceUnit(value);
        return this;
    }

    @Override
    public OfferRecord value7(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public OfferRecord value8(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public OfferRecord value9(LocalDateTime value) {
        setCreatedOn(value);
        return this;
    }

    @Override
    public OfferRecord value10(LocalDateTime value) {
        setUpdatedOn(value);
        return this;
    }

    @Override
    public OfferRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, BigDecimal value6, String value7, String value8, LocalDateTime value9, LocalDateTime value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OfferRecord
     */
    public OfferRecord() {
        super(Offer.OFFER);
    }

    /**
     * Create a detached, initialised OfferRecord
     */
    @ConstructorProperties({ "id", "traderId", "cityId", "professionId", "priceUnit", "wagePerPriceUnit", "description", "status", "createdOn", "updatedOn" })
    public OfferRecord(Integer id, Integer traderId, Integer cityId, Integer professionId, String priceUnit, BigDecimal wagePerPriceUnit, String description, String status, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(Offer.OFFER);

        setId(id);
        setTraderId(traderId);
        setCityId(cityId);
        setProfessionId(professionId);
        setPriceUnit(priceUnit);
        setWagePerPriceUnit(wagePerPriceUnit);
        setDescription(description);
        setStatus(status);
        setCreatedOn(createdOn);
        setUpdatedOn(updatedOn);
    }

    /**
     * Create a detached, initialised OfferRecord
     */
    @ConstructorProperties({ "id", "traderId", "cityId", "professionId", "priceUnit", "wagePerPriceUnit", "description", "status", "createdOn", "updatedOn" })
    public OfferRecord(com.dreamjob.db.jooq.tables.pojos.Offer value) {
        super(Offer.OFFER);

        if (value != null) {
            setId(value.getId());
            setTraderId(value.getTraderId());
            setCityId(value.getCityId());
            setProfessionId(value.getProfessionId());
            setPriceUnit(value.getPriceUnit());
            setWagePerPriceUnit(value.getWagePerPriceUnit());
            setDescription(value.getDescription());
            setStatus(value.getStatus());
            setCreatedOn(value.getCreatedOn());
            setUpdatedOn(value.getUpdatedOn());
        }
    }
}
