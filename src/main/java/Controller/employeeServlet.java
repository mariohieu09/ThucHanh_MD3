package Controller;

import DAO.employeeDAO;
import Model.employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeServlet", value = "/employee")
public class employeeServlet extends HttpServlet {
    private employeeDAO employeeDAO;
    @Override
    public void init() throws ServletException {
        employeeDAO = new employeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
               showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;

            default:
                getListEmployee(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
        }
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormEdit(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try{
            request.setAttribute("id", id);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        employee employee = employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        try {
            request.setAttribute("employee", employee);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        private void getListEmployee(HttpServletRequest request, HttpServletResponse response){
        List<employee> employeeList = employeeDAO.employeeList();
        request.setAttribute("list", employeeList);
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("TrangChu.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void editEmployee(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
         String name =  request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        employeeDAO.updateEmployee(name, email, address, phone, salary, department_id, id);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void createEmployee(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int department_id = Integer.parseInt(request.getParameter("department_id"));
        employee employee = new employee(name, email, address, phone, salary, department_id);
        employeeDAO.insertEmployee(employee);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showSearchForm(HttpServletRequest request, HttpServletResponse response){
            String name = request.getParameter("name");
            employee employee = employeeDAO.selectEmployeeByName(name);
            request.setAttribute("employee", employee);
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
