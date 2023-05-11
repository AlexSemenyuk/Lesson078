package org.itstep.dao;

import java.util.List;

// Data Access Object
public interface GenericDao<S, U> {

    void addUser (S firstName, S lastName, S login, S password);

    U findUserByLoginAndPassword (S login, S password);

}


