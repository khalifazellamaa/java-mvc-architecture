package lab.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.model.Person;

import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        Person person = new Person(firstName, lastName, birthDay, sex);
        request.setAttribute("personBean", person);

        String targetPage = "/old.jsp";

        if (birthDay != null && birthDay.compareTo("2006-01-01") > 0) {
            targetPage = "/young.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }
}