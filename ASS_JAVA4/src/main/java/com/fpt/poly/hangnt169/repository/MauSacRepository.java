package com.fpt.poly.hangnt169.repository;

import com.fpt.poly.hangnt169.entity.MauSac;
import com.fpt.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    public List<MauSac> getList() {
        List<MauSac> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac", MauSac.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MauSac getOne(UUID id) {
        MauSac ms = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac x WHERE x.id=:id", MauSac.class);
            query.setParameter("id", id);
            ms = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    public Boolean addSP(MauSac ms) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateSP(MauSac ms) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteSP(MauSac ms) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        MauSacRepository repo = new MauSacRepository();
        repo.getList().forEach(s -> System.out.println(s));
    }
}
