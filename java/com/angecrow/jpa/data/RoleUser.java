package com.angecrow.jpa.data;


/**
 * Created by AngeCrow on 20.04.2015.
 */

public enum RoleUser {
    ROLE_ADMIN(0),
    ROLE_STUDENT(1),
    ROLE_TEACHER(2);
    public final int value;
    private RoleUser(int value)
    {
        this.value=value;
    }
    public int getRoleUserValue()
    {
        return this.value;
    }

}
