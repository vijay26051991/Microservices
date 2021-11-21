package com.mylearning.employeeservice.entity;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.io.Serializable;

public class RealNamingStrategyImpl extends SpringPhysicalNamingStrategy implements Serializable {

    public static final PhysicalNamingStrategy INSTANCE = new PhysicalNamingStrategy() {
        @Override
        public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return null;
        }

        @Override
        public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return null;
        }

        @Override
        public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return null;
        }

        @Override
        public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return null;
        }

        @Override
        public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return new Identifier(identifier.getText(), identifier.isQuoted());
        }
    };

}
