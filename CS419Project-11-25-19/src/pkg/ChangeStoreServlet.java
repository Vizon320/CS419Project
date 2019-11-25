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
@WebServlet("/ChangeStoreServlet")
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
		String action = request.getParameter("test");
        if("storepick".equals(action)){
        	StoreDao store = new StoreDao();
    		store.initializeJdbc();
    	 //String store2 = "walmart";
    	 String store2 = request.getParameter("Store");
    	 
    	 
    	 List<StoreProduct> items = StoreDao.getAllProductsFromTable(store2);
    	// JSONObject json = new JSONObject();
    	 //json.put("name", "student");

    	// JSONArray array = new JSONArray();
    	// JSONObject item2 = new JSONObject();
    	// item2.put("information", "test");
    	// item2.put("id", 3);
    	// item2.put("name", "course1");
    	// array.add(item2);

    	// json.put("course", array);
    	// String message = json.toString();
    	//	System.out.println(message);
    		JSONArray arrayF = new JSONArray();
    		 
    		 //System.out.println(message2);
    		// request.setAttribute("message2", message2);
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
//    			//lblStatus.setText(lblStatus.getText() + "\n" + item.getName());
    			//System.out.println(item.getName());
    		}
    	 
     
           // String username = request.getParameter("username");
    	// String username = JSON.stringify(test2);
    	 String messageAll = arrayF.toString();
           System.out.println("items: " + messageAll);
            
            request.setAttribute("messageAll", messageAll);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);        }
	}

}