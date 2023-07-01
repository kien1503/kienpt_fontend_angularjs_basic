package com.fpt.poly.hangnt169.repository;

import com.fpt.poly.hangnt169.entity.ChucVu;
import com.fpt.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {

    public List<ChucVu> getList() {
        List<ChucVu> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu", ChucVu.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChucVu getOne(UUID id) {
        ChucVu cv = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu x WHERE x.id=:id", ChucVu.class);
            query.setParameter("id", id);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    public Boolean addSP(ChucVu cv) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateSP(ChucVu cv) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteSP(ChucVu cv) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChucVu> seachTen(String ten) {
        List<ChucVu> seachCV = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu x WHERE x.ten like :ten", ChucVu.class);
            query.setParameter("ten", "%" + ten + "%");
            seachCV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seachCV;
    }

    public static void main(String[] args) {
        ChucVuRepository repo = new ChucVuRepository();
        repo.getList().forEach(s -> System.out.println(s));
    }
}
