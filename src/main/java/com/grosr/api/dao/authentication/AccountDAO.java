package com.grosr.api.dao.authentication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.grosr.api.domain.authentication.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class is used to access data for the Account entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class AccountDAO {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Save the Account in the database.
     */
    public void create(Account account) {
        entityManager.persist(account);
        return;
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
                "from G_ACCOUNT where username = :username")
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