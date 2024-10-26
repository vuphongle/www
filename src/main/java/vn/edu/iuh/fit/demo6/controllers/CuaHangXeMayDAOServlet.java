package vn.edu.iuh.fit.demo6.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.demo6.entities.HangXe;
import vn.edu.iuh.fit.demo6.entities.Xe;
import vn.edu.iuh.fit.demo6.repositories.HangXeDAO;
import vn.edu.iuh.fit.demo6.repositories.XeDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/cua-hang-xe-may")
public class CuaHangXeMayDAOServlet extends HttpServlet {
    @Inject
    private HangXeDAO hangXeDAO;
    @Inject
    private XeDAO xeDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            List<Xe> xes = xeDAO.getAll();

            req.setAttribute("xes", xes);
            req.getRequestDispatcher("views/cuahang.jsp").forward(req, resp);
        } else {
            if(action.equalsIgnoreCase("add")){
                List<HangXe> hangXes = hangXeDAO.getAll();

                req.setAttribute("hangXes", hangXes);

                String status = req.getParameter("status");

                req.setAttribute("message", status);
                req.getRequestDispatcher("views/themcuahang.jsp").forward(req, resp);
            } else if (action.equalsIgnoreCase("filter")) {
                String param = req.getParameter("paramFilter");
                String tenXe = null;

                tenXe = param.toLowerCase().trim();

                List<Xe> xes = xeDAO.getByTenXe(tenXe);

                req.setAttribute("xes", xes);
                req.getRequestDispatcher("views/cuahang.jsp").forward(req, resp);
            } else if (action.equalsIgnoreCase("edit")) {
                String maXe = req.getParameter("maXe");
                Xe xe = xeDAO.getByMaXe(maXe);

                List<HangXe> hangXes = hangXeDAO.getAll();
                req.setAttribute("hangXes", hangXes);
                req.setAttribute("xe", xe);

                req.getRequestDispatcher("views/suacuahang.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null) {
            if(action.equalsIgnoreCase("add")) {
                String tenXe = req.getParameter("tenXe");
                String giaXe = req.getParameter("giaXe");
                String namSanXuat = req.getParameter("namSanXuat");
                String hangXe = req.getParameter("hangXe");

                Xe xe = Xe.builder()
                        .tenXe(tenXe)
                        .giaXe(Double.parseDouble(giaXe))
                        .namSanXuat(Integer.parseInt(namSanXuat))
                        .hangXe(HangXe.builder().maHangXe(hangXe).build())
                        .build();

                xeDAO.insert(xe, hangXe);

                resp.sendRedirect(req.getContextPath() + "/cua-hang-xe-may");
            } else if (action.equalsIgnoreCase("edit")) {
                String maXe = req.getParameter("maXe");
                String tenXe = req.getParameter("tenXe");
                String giaXe = req.getParameter("giaXe");
                String namSanXuat = req.getParameter("namSanXuat");
                String hangXe = req.getParameter("hangXe");

                Xe xe = Xe.builder()
                        .maXe(maXe)
                        .tenXe(tenXe)
                        .giaXe(Double.parseDouble(giaXe))
                        .namSanXuat(Integer.parseInt(namSanXuat))
                        .hangXe(HangXe.builder().maHangXe(hangXe).build())
                        .build();

                xeDAO.insert(xe, hangXe);

                resp.sendRedirect(req.getContextPath() + "/cua-hang-xe-may");
            }
        }
    }
}
