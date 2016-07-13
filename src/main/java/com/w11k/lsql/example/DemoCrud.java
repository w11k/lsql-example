package com.w11k.lsql.example;

import com.w11k.lsql.LSql;

public class DemoCrud {


    public DemoCrud(LSql lSql) {
        lSql.table("person", Person.class);


    }
}
