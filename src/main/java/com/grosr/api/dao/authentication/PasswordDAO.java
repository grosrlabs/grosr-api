package com.grosr.api.dao.authentication;

import com.grosr.api.domain.account.Password;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Repository
@Transactional
public class PasswordDAO{
    /**
     * Save the Password in the database.
     */
    public Password create(Password password) {
        try {
            entityManager.persist(password);
        } catch(ConstraintViolationException e) {

        } catch(JDBCConnectionException e) {

        } catch (Exception e) {

        }
        return password;
    }

    /**
     * Delete the Password from the database.
     */

    public void delete(Password password) {
        if (entityManager.contains(password))
            entityManager.remove(password);
        else
            entityManager.remove(entityManager.merge(password));
        return;
    }

    /**
     * Return all the Passwords stored in the database.
     */

    public List<Password> read() {
        return entityManager.createQuery("from G_ACCOUNT").getResultList();
    }


    /**
     * Return the Password having the passed id.
     */
    public Password getByUserId(Long userId) {
        return entityManager.find(Password.class, userId);
    }

    /**
     * Update the passed Password in the database.
     */

    public void update(Password password) {
        entityManager.merge(password);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

}