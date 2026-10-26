package lab.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.model.Person;

import java.io.IOException;

// هذا السطر (Annotation) يغنينا عن كتابة web.xml
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. قراءة البيانات من الـ Form
        // ملاحظة: تأكد أن أسماء الحقول في الـ HTML تطابق هذه الأسماء
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay"); // أو birthDate
        String sex = request.getParameter("sex");

        // 2. إنشاء كائن Person باستخدام المُنشئ
        Person person = new Person(firstName, lastName, birthDay, sex);

        // 3. إضافة الكائن إلى الـ Request لتمريره للـ JSP
        request.setAttribute("personBean", person);
        String targetJSP = "/young.jsp"; // الافتراضي
        if (birthDay != null && birthDay.compareTo("2006-01-01") < 0) {
            targetJSP = "/old.jsp";
        }


        // 4. تمرير الطلب (Forward) إلى صفحة JSP
        // يمكنك استخدام include أو forward. التمرين يطلب include
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(targetJSP);

        // Note: في العادة نستخدم forward، لكن التمرين يطلب include:
        dispatcher.include(request, response);
    }
}