package com.langpath.app.queries;

/**
 * Created by root on 20.10.16.
 */
public interface QueryService <I, O>{
    O query(I criteria);
}
