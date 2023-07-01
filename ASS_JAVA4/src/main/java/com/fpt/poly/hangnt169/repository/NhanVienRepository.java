package com.fpt.poly.hangnt169.repository;

import com.fpt.poly.hangnt169.entity.NhanVien;
import com.fpt.poly.hangnt169.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public List<NhanVien> getList() {
        List<NhanVien> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien ", NhanVien.class);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getOne(UUID id) {
        NhanVien nv = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien nv WHERE nv.id=:id",NhanVien.class);
            query.setParameter("id", id);
            nv = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public Boolean addNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteNV(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<NhanVien> seachTen(String ten){
        List<NhanVien> seachNV = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien x WHERE x.ten like :ten", NhanVien.class);
            query.setParameter("ten","%"+ten+"%");
            seachNV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seachNV;
    }

    public static void main(String[] args) {
        NhanVienRepository repo = new NhanVienRepository();
        repo.getList().forEach(s-> System.out.println(s));
    }
}
