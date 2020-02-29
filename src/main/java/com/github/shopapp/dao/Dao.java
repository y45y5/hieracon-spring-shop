package com.github.shopapp.dao;

import com.github.shopapp.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class Dao<T> {

    protected void saveObject(T t){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void deleteObject(T t){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void updateObject(T t){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void mergeObject(T t){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<T> getObjectList(Class<T> type){
        List<T> objectList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(type);
            criteria.from(type);
            objectList = session.createQuery(criteria).getResultList();
            session.close();
        }
        catch (Exception e){ e.printStackTrace(); }
        finally { session.close(); }
        return objectList;
    }

    protected List<T> getObjectListByObject(Class<T> type, String column, Object object){
        List<T> objectList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(type);
            Root<T> root = criteria.from(type);
            criteria.select(root).where(builder.equal(root.get(column), object));
            objectList = session.createQuery(criteria).getResultList();
        }
        catch (Exception e){ e.printStackTrace(); }
        finally { session.close(); }
        return objectList;
    }
}

