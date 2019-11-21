<!-- InitializeConnection.jsp -->
<!-- Some of the code is done, but not all of it. Based off of BookExamples_ch38_JSP2\WebContent\DBLoginInitialization.jsp
	Functionality needed for this jsp:
		-Create the ListBean that will store the items in the user's shopping list (started, not done)
		-Make sure the shopping list will stay for the whole session (done using scope = "session")
		-Create a StoreDao as a bean(?) and run its initializeJdbc method to make the database connection
		-If database connection fails (getConnection() == null), probably display an error message -->
		
<!-- Would page import = "pkg.*" bring in everything in that package? If so, would be very helpful -->
<%@ page import = "pkg.ListBean" %>
<jsp:useBean id = "shoppingListBeanId" class = "pkg.ListBean" scope = "session" ></jsp:useBean>
<html>
  <head>
    <!-- This is where the title would go, but I don't think one is needed because it's not the webpage itself, it's just initializing? -->
  </head>
  <body>
  <h3><%-- This is heading 3, a kind of subheading where a subtitle can be put. Probably not necessary? --%></h3>
  	<form method = "post">
 		<!-- The code that runs when the .jsp is first loaded goes here -->
 		<!-- Helpful tip: <jsp:forward page = "Something.jsp" /> goes straight to Something.jsp after preceding code is run -->
    </form>
  </body>
</html>
