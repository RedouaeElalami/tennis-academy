package com.zenika.academy.tennisacademy.repository;

import com.zenika.academy.tennisacademy.domain.Player;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

//@Repository
public class HibernatePlayerRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Player> findPlayersByAge(Integer age) {
        final Session session = (Session) entityManager.getDelegate();
        return Collections.emptyList();
    }
}
