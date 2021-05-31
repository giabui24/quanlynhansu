import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.buihoanggia.entity.NhanVien;
import com.buihoanggia.entity.PhongBan;

import Hibernate.HibernateUtils;

public class QuanLyNhanSu {
	public static Scanner scanner = new Scanner(System.in);

	private String inputTenPhongBan() {
		System.out.print("Vui Long Nhap Ten Phong Ban: ");
		return scanner.nextLine();
	}

	private String inputTenNhanVien() {
		System.out.print("Vui Long Nhap Ten Nhan Vien: ");
		return scanner.nextLine();
	}

	private int inputTuoiNhanVien() {
		System.out.print("Vui Long Nhap Ten Nhan Vien: ");
		return scanner.nextInt();
	}

	private int inputIdNhanVien() {
		System.out.print("Vui Long Nhap Id Nhan Vien: ");
		return scanner.nextInt();
	}

	private String inputMaPhongBan() {
		System.out.print("Vui Long Nhap Ma Phong Ban: ");
		return scanner.nextLine();
	}

	private int inputIdPhongBan() {
		System.out.print("Vui Long Nhap Id Phong Ban: ");
		return scanner.nextInt();
	}

	public void addPhongBan() {
		String tenphongban = inputTenPhongBan();
		String maphongban = inputMaPhongBan();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		PhongBan phongban = new PhongBan();
		phongban.setMaPhongBan(maphongban);
		phongban.setTenPhongBan(tenphongban);
		session.save(phongban);
		session.getTransaction().commit();
		session.close();

	}

	public void addNhanVien() {
		int idPhongBan = inputIdPhongBan();
		String tennhanVien = inputTenNhanVien();
		int tuoinhanVien = inputTuoiNhanVien();

		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		PhongBan phongban = session.get(PhongBan.class, idPhongBan);
		NhanVien nhanvien = new NhanVien();
		nhanvien.setTenNhanVien(tennhanVien);
		nhanvien.setPhongban(phongban);

		session.save(nhanvien);
		session.getTransaction().commit();
		session.close();

	}

	public void deletePhongBan() {
		int id = inputIdPhongBan();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		PhongBan phongban = session.get(PhongBan.class, id);
		session.delete(phongban);
		session.getTransaction().commit();
		session.close();

	}

	public void deleteNhanVien() {
		int id = inputIdNhanVien();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		NhanVien nhanvien = session.get(NhanVien.class, id);
		session.delete(nhanvien);
		session.getTransaction().commit();
		session.close();

	}

	public void updatePhongBan() {
		int id = inputIdPhongBan();
		String tenphongban = inputTenPhongBan();
		String maphongban = inputMaPhongBan();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		PhongBan phongban = session.get(PhongBan.class, id);
		phongban.setTenPhongBan(tenphongban);
		phongban.setMaPhongBan(maphongban);
		session.update(phongban);
		session.getTransaction().commit();
		session.close();

	}

	public void updateNhanVien() {
		int id = inputIdNhanVien();
		String tennhanvien = inputTenNhanVien();
		int tuoinhanvien = inputTuoiNhanVien();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		NhanVien nhanvien = session.get(NhanVien.class, id);
		nhanvien.setTenNhanVien(tennhanvien);
		nhanvien.setTuoi(tuoinhanvien);
		session.update(nhanvien);
		session.getTransaction().commit();
		session.close();

	}
	public void updateNhanVienPhongBan() {
		int id = inputIdNhanVien();
		int idPhongBan = inputIdPhongBan();
		String tennhanvien = inputTenNhanVien();
		int tuoinhanvien = inputTuoiNhanVien();
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		NhanVien nhanvien = session.get(NhanVien.class, id);
		PhongBan phongban = session.get(PhongBan.class, idPhongBan);
		nhanvien.setPhongban(phongban);
		nhanvien.setTenNhanVien(tennhanvien);
		nhanvien.setTuoi(tuoinhanvien);
		session.update(nhanvien);
		session.getTransaction().commit();
		session.close();

	}


	public void showListPhongBan() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String query = "from phongban";
		List<PhongBan> phongbans = (List<PhongBan>) session.createQuery(query).getResultList();

		for (PhongBan phongban : phongbans) {
			System.out.format("%5d | ", phongban.getIdPhongBan());
			System.out.format("%20s | ", phongban.getTenPhongBan());
//			System.out.format("%5d | ", phongban.getMaPhongBan());

			System.out.println("/n");
		}
		session.getTransaction().commit();
		session.close();

	}

	public void showListNhanVien() {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String query = "from nhanvien";
		List<NhanVien> nhanviens = (List<NhanVien>) session.createQuery(query).getResultList();

		for (NhanVien nhanvien : nhanviens) {
			System.out.format("%5d | ", nhanvien.getIdNhanVien());
			System.out.format("%20s | ", nhanvien.getTenNhanVien());
			System.out.format("%5d | ", nhanvien.getTuoi());

			System.out.println("/n");
		}
		session.getTransaction().commit();
		session.close();

	}


}
