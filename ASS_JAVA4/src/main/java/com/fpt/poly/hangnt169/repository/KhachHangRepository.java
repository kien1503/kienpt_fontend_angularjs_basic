package com.fpt.poly.hangnt169.repository;

import com.fpt.poly.hangnt169.entity.KhachHang;
import com.fpt.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    public List<KhachHang> getList() {
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public KhachHang getOne(UUID id) {
        KhachHang kh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang kh WHERE kh.id=:id", KhachHang.class);
            query.setParameter("id", id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kh;

    }

    public Boolean addKH(KhachHang kh) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateKH(KhachHang kh) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean deleteKH(KhachHang kh) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<KhachHang> seachTen(String ten){
        List<KhachHang> seachKH = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang x WHERE x.ten like :ten", KhachHang.class);
            query.setParameter("ten","%"+ten+"%");
            seachKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seachKH;
    }


}
