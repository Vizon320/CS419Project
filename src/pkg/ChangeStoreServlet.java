package pkg;
import org.json.simple.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeStoreServlet
 */
@WebServlet("/testservlet")
public class ChangeStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStoreServlet() {
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
		StoreDao.initializeJdbc();
		// read form fields
	 //String store2 = "walmart";
	 String store2 = request.getParameter("Store");
	 String locationY = request.getParameter("locationY");
	 String id = request.getParameter("id");
	 String name = request.getParameter("name");
	 String department = request.getParameter("department");
	 String aisle = request.getParameter("aisle");
	 String section = request.getParameter("section");
	 String locationX = request.getParameter("locationX");

	 	//System.out.println(aisle + " " + locationX + " " + locationY + " " + id + " " + name + " " + department + " " +  section);
	 	
	 	// Create a List of all store products from table "store2" and a JSONArray
	 	List<StoreProduct> items = StoreDao.getAllProductsFromTable(store2);
		JSONArray arrayF = new JSONArray();
		
		// Populate JSONArray arrayF with elements from List items
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
		 
		 // Convert arrayF to a string message2
		 String message2 = arrayF.toString();
		 //System.out.println("items: " + message2);
        
		 // Pass along message2 back to the website
        request.setAttribute("message2", message2);
        RequestDispatcher rd = request.getRequestDispatcher("/testsite.jsp");
        rd.forward(request, response);
	}

}
