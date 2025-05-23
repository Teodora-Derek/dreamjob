/*
 * This file is generated by jOOQ.
 */
package com.dreamjob.db.jooq.tables;


import com.dreamjob.db.jooq.DefaultSchema;
import com.dreamjob.db.jooq.Indexes;
import com.dreamjob.db.jooq.Keys;
import com.dreamjob.db.jooq.tables.records.ProfessionRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class Profession extends TableImpl<ProfessionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>profession</code>
     */
    public static final Profession PROFESSION = new Profession();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProfessionRecord> getRecordType() {
        return ProfessionRecord.class;
    }

    /**
     * The column <code>profession.id</code>.
     */
    public final TableField<ProfessionRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>profession.profession_name</code>.
     */
    public final TableField<ProfessionRecord, String> PROFESSION_NAME = createField(DSL.name("profession_name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>profession.description</code>.
     */
    public final TableField<ProfessionRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>profession.status</code>.
     */
    public final TableField<ProfessionRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>profession.created_on</code>.
     */
    public final TableField<ProfessionRecord, LocalDateTime> CREATED_ON = createField(DSL.name("created_on"), SQLDataType.LOCALDATETIME(3).nullable(false), this, "");

    /**
     * The column <code>profession.updated_on</code>.
     */
    public final TableField<ProfessionRecord, LocalDateTime> UPDATED_ON = createField(DSL.name("updated_on"), SQLDataType.LOCALDATETIME(3).nullable(false), this, "");

    private Profession(Name alias, Table<ProfessionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Profession(Name alias, Table<ProfessionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>profession</code> table reference
     */
    public Profession(String alias) {
        this(DSL.name(alias), PROFESSION);
    }

    /**
     * Create an aliased <code>profession</code> table reference
     */
    public Profession(Name alias) {
        this(alias, PROFESSION);
    }

    /**
     * Create a <code>profession</code> table reference
     */
    public Profession() {
        this(DSL.name("profession"), null);
    }

    public <O extends Record> Profession(Table<O> child, ForeignKey<O, ProfessionRecord> key) {
        super(child, key, PROFESSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_PROFESSION_PROFESSION_NAME);
    }

    @Override
    public Identity<ProfessionRecord, Integer> getIdentity() {
        return (Identity<ProfessionRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProfessionRecord> getPrimaryKey() {
        return Keys.PROFESSION_PKEY;
    }

    @Override
    public Profession as(String alias) {
        return new Profession(DSL.name(alias), this);
    }

    @Override
    public Profession as(Name alias) {
        return new Profession(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Profession rename(String name) {
        return new Profession(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Profession rename(Name name) {
        return new Profession(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
