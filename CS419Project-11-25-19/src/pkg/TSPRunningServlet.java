package pkg;

import org.json.simple.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class testservlet2
 */
@WebServlet("/TSPRunningServlet")
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
		// TODO Auto-generated method stub
		String action = request.getParameter("test");
		if("itempick".equals(action)) {
   		 String[] id = request.getParameterValues("id");
   		 String[] name = request.getParameterValues("name");
   		 String[] department = request.getParameterValues("department");
   		 String[] aisle = request.getParameterValues("aisle");
   		 String[] section = request.getParameterValues("section");
   		 String[] locationX = request.getParameterValues("locationX");
   		String[] locationY = request.getParameterValues("locationY");
   		
			List<StoreProduct> listpath = new ArrayList<StoreProduct>();
			StoreProduct entrance = new StoreProduct();
			entrance.setX(0);
			entrance.setY(0);
			listpath.add(entrance);

   		 for( int i = 0; i <= name.length - 1; i++) {
   			// Put the shopping cart products into the list
   			StoreProduct s = new StoreProduct();
   			//Integer.parseInt()
   			s.setName(name[i]);
   			s.setDepartment(department[i]);
   			s.setAisle(aisle[i]);
   			s.setSection(section[i]);
   			s.setX(Integer.parseInt(locationX[i]));
   			s.setY(Integer.parseInt(locationY[i]));
   			s.setId(Integer.parseInt(id[i]));
   			listpath.add(s);
   		 }
   		 
 		List<StoreProduct> itemspath = Algorithms.shortestPath(listpath);

 		JSONArray arrayFpath = new JSONArray();
		 JSONObject itemFtop = new JSONObject();
		 
 		for(int i = 0; i < itemspath.size(); i++) {
			StoreProduct itempath = itemspath.get(i);
   //System.out.println("\n\t" + (i+1) + ": " + itempath.getName() + "\tat \t(" + itempath.getX() + ", " + itempath.getY() + ")");
		 JSONObject itemFpath = new JSONObject();

		 itemFpath.put("order", (i+1));
		 itemFpath.put("locationX", itempath.getX());
		 itemFpath.put("locationY", itempath.getY());
		 itemFpath.put("name", itempath.getName());
		 itemFpath.put("department", itempath.getDepartment());
		 itemFpath.put("aisle", itempath.getAisle());
		 itemFpath.put("section", itempath.getSection());
		 itemFpath.put("id", itempath.getId());
		 arrayFpath.add(itemFpath);

		}
			 itemFtop.put("Distance", "");
      
	 String messagePath = arrayFpath.toString();
	 String messageTop = itemFtop.toString();

		StoreDao.initializeJdbc();
	 String store2 = request.getParameter("Store");
	 
	 
	 List<StoreProduct> items = StoreDao.getAllProductsFromTable(store2);
	
		JSONArray arrayF = new JSONArray();
		 
		 
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
		 arrayF.add(itemF);
		 
		 k++;

		}
	 
 
       
	 String messageAll = arrayF.toString();
       //System.out.println("messageAll: " + messageAll);
       //System.out.println("messagePath: " + messagePath);
       //System.out.println("messageTop: " + messageTop);

       
       request.setAttribute("messageTop", messageTop);

        request.setAttribute("messageAll", messageAll);
        request.setAttribute("messagePath", messagePath);

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);     
   	        } 
	}

}
