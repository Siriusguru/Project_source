package com.google.appengine.codelab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

public class QuestionServlet extends BaseServlet {

	
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

  super.doGet(req, resp);
  String searchBy = req.getParameter("item-searchby");
  String searchFor = req.getParameter("q");
  PrintWriter out = resp.getWriter();
  if (searchFor == null || searchFor.equals("")) {
    Iterable<Entity> entities = Item.getAllItems();
    out.println(Util.writeJSON(entities));
  } else if (searchBy == null || searchBy.equals("name")) {
    Iterable<Entity> entities = Item.getItem(searchFor);
    out.println(Util.writeJSON(entities));
  } else if (searchBy != null && searchBy.equals("product")) {
    Iterable<Entity> entities = Item.getItemsForProduct("Item", searchFor);
    out.println(Util.writeJSON(entities));
  }
}
}
