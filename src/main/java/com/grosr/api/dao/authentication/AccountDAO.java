package com.grosr.api.dao.authentication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import com.grosr.api.domain.account.Account;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class AccountDAO {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Save the Account in the database.
     */
    public Account create(Account account) {
        try {
            entityManager.persist(account);
        } catch(ConstraintViolationException e) {

        } catch(JDBCConnectionException e) {

        } catch (Exception e) {

        }
        return account;
    }

    /**
     * Delete the Account from the database.
     */
    public void delete(Account account) {
        if (entityManager.contains(account))
            entityManager.remove(account);
        else
            entityManager.remove(entityManager.merge(account));
        return;
    }

    /**
     * Return all the Accounts stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<Account> getAll() {
        return entityManager.createQuery("from G_ACCOUNT").getResultList();
    }

    /**
     * Return the Account having the passed email.
     */
    public Account getByUsername(String username) {
        return (Account) entityManager.createQuery(
                "from Account where username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    /**
     * Return the Account having the passed id.
     */
    public Account getByUserId(Long userId) {
        return entityManager.find(Account.class, userId);
    }

    /**
     * Update the passed Account in the database.
     */
    public void update(Account account) {
        entityManager.merge(account);
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