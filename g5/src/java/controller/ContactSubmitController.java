/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ContactDAO;
import entity.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seth
 */
@WebServlet(name = "ContactSubmitController", urlPatterns = {"/contact"})
public class ContactSubmitController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactDAO dao = new ContactDAO();
        String name = request.getParameter("name");
        int contactType = Integer.parseInt(request.getParameter("contactType"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
        
        Contact contact = new Contact();
        contact.setFullname(name);
        contact.setCategoryId(contactType);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);
        dao.addNewContact(contact);
    }
    
}
