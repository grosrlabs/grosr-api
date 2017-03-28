package com.grosr.api.dao.common;

/**
 * Created by grosr on 3/16/17.
 */
public interface IBaseDAO {

    public Object create(Class c);

    public Object delete(Class c);

    public Object update(Class c);

    public Object read();
}
