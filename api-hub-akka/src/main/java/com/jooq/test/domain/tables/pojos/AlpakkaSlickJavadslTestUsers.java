/*
 * This file is generated by jOOQ.
*/
package com.jooq.test.domain.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AlpakkaSlickJavadslTestUsers implements Serializable {

    private static final long serialVersionUID = 483968979;

    private Integer id;
    private String  name;

    public AlpakkaSlickJavadslTestUsers() {}

    public AlpakkaSlickJavadslTestUsers(AlpakkaSlickJavadslTestUsers value) {
        this.id = value.id;
        this.name = value.name;
    }

    public AlpakkaSlickJavadslTestUsers(
        Integer id,
        String  name
    ) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AlpakkaSlickJavadslTestUsers (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
