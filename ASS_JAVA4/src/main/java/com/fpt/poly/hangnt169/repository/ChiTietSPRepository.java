package com.fpt.poly.hangnt169.repository;

import com.fpt.poly.hangnt169.entity.ChiTietSanPham;
import com.fpt.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    public List<ChiTietSanPham> getList() {

        List<ChiTietSanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSanPham.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietSanPham getOne(UUID id) {
        ChiTietSanPham chiTietSP = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP  ctsp WHERE ctsp.id=:id", ChiTietSanPham.class);
            query.setParameter("id", id);
            chiTietSP = (ChiTietSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public Boolean addCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteCTSP(ChiTietSanPham ctsp) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        ChiTietSPRepository repo = new ChiTietSPRepository();
        repo.getList().forEach(s-> System.out.println(s));
    }
}
