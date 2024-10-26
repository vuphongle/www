package vn.edu.iuh.fit.demo6.repositories;

import vn.edu.iuh.fit.demo6.entities.Xe;

import java.util.List;

public interface XeDAO {
    List<Xe> getAll();
    Xe insert(Xe xe, String tenHangXe);
    List<Xe> getByTenXe(String tenXe);

    Xe getByMaXe(String maXe);
}
