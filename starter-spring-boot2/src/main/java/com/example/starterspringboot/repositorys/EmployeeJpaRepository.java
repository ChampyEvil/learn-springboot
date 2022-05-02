package com.example.starterspringboot.repositorys;

import com.example.starterspringboot.responses.EmployeeRepostResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<EmployeeRepostResponse> findByNativeQuery() {
        Query query = entityManager.createNativeQuery("SELECT e.id as ID, e.first_name as FIRST_NAME, e.last_name as LAST_NAME, 'IT' as DEPARTMENT FROM EMPLOYEE e", EmployeeRepostResponse.class);

        return query.getResultList();
    }
}
