package com.w11k.lsql.example;

import com.w11k.lsql.LSql;
import com.w11k.lsql.PojoTable;
import com.w11k.lsql.example.dto.Person;

public class DemoCrud {

    private final PojoTable<Person> personTable;

    public DemoCrud(LSql lSql) {
        this.personTable = lSql.table("person", Person.class);
    }


    public void run() {
        Person p = new Person();
        p.setFirstName("Adam");
        p.setLastName("Doe");
        personTable.insert(p);
    }
}
