package com.w11k.lsql.example;

import com.googlecode.flyway.core.Flyway;
import com.w11k.lsql.LSql;
import com.w11k.lsql.dialects.PostgresDialect;
import com.w11k.lsql.schemaexporter.SchemaExporter;
import org.apache.commons.dbcp.BasicDataSource;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class Init {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, URISyntaxException {

        BasicDataSource ds = new BasicDataSource();
        String url = "jdbc:postgresql://localhost:5432/lsql";
        ds.setUrl(url);
        ds.setUsername("lsql");
        ds.setPassword("lsql");

        Flyway flyway = new Flyway();
        flyway.setDataSource(ds);
//        flyway.clean();
        flyway.migrate();

        LSql lSql = new LSql(new PostgresDialect(), ds);
        lSql.table("person");

        SchemaExporter schemaExporter = new SchemaExporter(lSql);
        schemaExporter.setPackageName("com.w11k.example.dto");
        schemaExporter.setOutputPath(SchemaExporter.pathRelativeToProjectRoot("pom.xml", "src/generated/java"));
        schemaExporter.export();

        new DemoCrud(lSql);
    }

}
