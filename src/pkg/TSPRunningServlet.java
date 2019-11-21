package pkg;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * Servlet implementation class TSPRunningServlet
 */
@WebServlet("/page2")
public class TSPRunningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSPRunningServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	// Create a List to hold shopping cart products
	 	List<StoreProduct> list = new ArrayList<StoreProduct>();
		
		// Put the shopping cart products into the list
	 	JSONParser why = new JSONParser();
		String readIn;
		StoreProduct s = new StoreProduct();
		s.setName(request.getParameter("name"));
		s.setDepartment(request.getParameter("department"));
		s.setAisle(request.getParameter("aisle"));
		s.setSection(request.getParameter("section"));
		s.setX(Integer.valueOf(request.getParameter("locationX")));
		s.setY(Integer.valueOf(request.getParameter("locationY")));
		list.add(s);
		
		// Run the list through the tsp and create a JSONArray
		List<StoreProduct> items = Algorithms.shortestPath(list);
		JSONArray arrayItems = new JSONArray();
		
		// Populate JSONArray arrayItems with elements from List items
		 int k = 0;
		 for(StoreProduct item : items) {
			 JSONObject itemF = new JSONObject();
	
			 itemF.put("id", k);
			 itemF.put("locationX", item.getX());
			 itemF.put("locationY", item.getY());
			 itemF.put("name", item.getName());
			 
			 itemF.put("department", item.getDepartment());
			 itemF.put("aisle", item.getAisle());
			 itemF.put("section", item.getSection());
			 arrayItems.add(itemF);
			 
			 k++;
		}
		 
		 // Convert arrayF to a string listString
		 String listString = arrayItems.toString();
		 //System.out.println("items: " + message2);
        
		 // Pass along message2 back to the website
        request.setAttribute("listString", listString);
        RequestDispatcher rd = request.getRequestDispatcher("/testsite.jsp");
        rd.forward(request, response);
	}

}
