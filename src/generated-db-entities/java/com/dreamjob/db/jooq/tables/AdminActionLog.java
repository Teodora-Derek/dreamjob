/*
 * This file is generated by jOOQ.
 */
package com.dreamjob.db.jooq.tables;


import com.dreamjob.db.jooq.DefaultSchema;
import com.dreamjob.db.jooq.Keys;
import com.dreamjob.db.jooq.tables.records.AdminActionLogRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
public class AdminActionLog extends TableImpl<AdminActionLogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>admin_action_log</code>
     */
    public static final AdminActionLog ADMIN_ACTION_LOG = new AdminActionLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AdminActionLogRecord> getRecordType() {
        return AdminActionLogRecord.class;
    }

    /**
     * The column <code>admin_action_log.id</code>.
     */
    public final TableField<AdminActionLogRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>admin_action_log.admin_id</code>.
     */
    public final TableField<AdminActionLogRecord, Integer> ADMIN_ID = createField(DSL.name("admin_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>admin_action_log.action_type</code>.
     */
    public final TableField<AdminActionLogRecord, String> ACTION_TYPE = createField(DSL.name("action_type"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>admin_action_log.target_table</code>.
     */
    public final TableField<AdminActionLogRecord, String> TARGET_TABLE = createField(DSL.name("target_table"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>admin_action_log.record_id</code>.
     */
    public final TableField<AdminActionLogRecord, Integer> RECORD_ID = createField(DSL.name("record_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>admin_action_log.change_details</code>.
     */
    public final TableField<AdminActionLogRecord, JSONB> CHANGE_DETAILS = createField(DSL.name("change_details"), SQLDataType.JSONB, this, "");

    /**
     * The column <code>admin_action_log.created_on</code>.
     */
    public final TableField<AdminActionLogRecord, LocalDateTime> CREATED_ON = createField(DSL.name("created_on"), SQLDataType.LOCALDATETIME(3).nullable(false), this, "");

    private AdminActionLog(Name alias, Table<AdminActionLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private AdminActionLog(Name alias, Table<AdminActionLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>admin_action_log</code> table reference
     */
    public AdminActionLog(String alias) {
        this(DSL.name(alias), ADMIN_ACTION_LOG);
    }

    /**
     * Create an aliased <code>admin_action_log</code> table reference
     */
    public AdminActionLog(Name alias) {
        this(alias, ADMIN_ACTION_LOG);
    }

    /**
     * Create a <code>admin_action_log</code> table reference
     */
    public AdminActionLog() {
        this(DSL.name("admin_action_log"), null);
    }

    public <O extends Record> AdminActionLog(Table<O> child, ForeignKey<O, AdminActionLogRecord> key) {
        super(child, key, ADMIN_ACTION_LOG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<AdminActionLogRecord, Integer> getIdentity() {
        return (Identity<AdminActionLogRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AdminActionLogRecord> getPrimaryKey() {
        return Keys.ADMIN_ACTION_LOG_PKEY;
    }

    @Override
    public List<ForeignKey<AdminActionLogRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ADMIN_ACTION_LOG__FK_ADMIN_ACTION_LOG_ADMINISTRATOR_ID);
    }

    private transient Administrator _administrator;

    /**
     * Get the implicit join path to the <code>public.administrator</code>
     * table.
     */
    public Administrator administrator() {
        if (_administrator == null)
            _administrator = new Administrator(this, Keys.ADMIN_ACTION_LOG__FK_ADMIN_ACTION_LOG_ADMINISTRATOR_ID);

        return _administrator;
    }

    @Override
    public AdminActionLog as(String alias) {
        return new AdminActionLog(DSL.name(alias), this);
    }

    @Override
    public AdminActionLog as(Name alias) {
        return new AdminActionLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AdminActionLog rename(String name) {
        return new AdminActionLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AdminActionLog rename(Name name) {
        return new AdminActionLog(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, String, Integer, JSONB, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
