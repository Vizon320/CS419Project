<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ page import = "pkg.*" %>
<%@ page import = "java.util.*" %>
<jsp:useBean id = "shoppingListBeanId" class = "pkg.ListBean" scope = "session" ></jsp:useBean>

<HTML>
  <head>
  <title> testsite.jsp </title>
  <meta charset="ISO-8859-1">
	<!-- rgb(171, 210, 237) -->
    <style>


    body {
      margin: 0;
      padding: 0;
      font-family: 'Open Sans', sans-serif;
      font-size: 16px;
      background: rgb(255, 255, 255);
      color: #333;
    }

    a {
      text-decoration: none;
    }

    .button {
      padding: 10px;
      border-radius: 5px;
      display: inline-block;
      background: rgb(255, 33, 0);
      color: white;
      font-size: 12px;
      font-weight: bold;
    }

    .container {

      height: 100%;

      padding: 0 10%;
    }

    .header {
      height: 9vw;
    }

    .header a {
      color: inherit;
    }

    .header a:hover {
      font-weight: bold;
    }

    .header-logo {
      margin: 0;

    }

    .header-nav {
      float: right;
    }

    .header-nav ul li {
      display: inline-block;
      margin: 0 20px;
    }

    .products {

    }

    .product {

      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 5px;
      background: rgb(255, 169, 156);
    }

    .product2 {

      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 5px;
      background: rgb(255, 169, 156);
    }
    .product span {
      font-weight: bold;
    }

    .product2 span {
      font-weight: bold;
    }


    .row .product:last-child {
      margin-right: 0;
    }

    .product-add-to-cart {
      overflow: hidden;
      clear: both;
      margin-top: 10px;
    }



    .add-to-cart {
      float: right;
    }

    .shopping-cart {

      float: right;
      overflow: auto;
      width: 300px;
      min-height: 300px;
      max-height: 500px;


      background: rgb( 40, 121, 176);
      color: white;

    }

    .tableHolder {

      float: left;
      overflow: auto;
      min-width: 300px;

      height: 600px;



    }

    .tableHolder2 {
      display:none;

      overflow: auto;
      min-width: 300px;

      max-height: 300px;



    }

    .picW img{
      zoom: 45%;




    }
    .picT img{
      zoom: 45%;
    }
    .picC img{
      zoom: 45%;
    }
    .picW {
      float: right;
      display:none;

    }
    .picC {
      float: right;
      display:none;

    }
    .picT {
      float: right;
      display:none;

    }
    .debugscontainer{
      display: none;

    }

    #myTable {
      background: rgb( 40, 121, 176);
      color: black;
      font-weight: bold;
    }
    #myTable2 {
      background: rgb( 40, 121, 176);
      color: black;
      font-weight: bold;
    }

    .shopping-cart-head {
      background: rgb(255, 33, 0);
      color: white;
      padding: 5px;
    }

    .shopping-cart,
    .shopping-cart-head {
      border-radius: 5px;
    }

    .empty-cart-btn,
    .cart-checkout {
      display: none;

    }

    .empty-cart-btn {
      margin-bottom: 5px;
    }
    .empty-final-btn {
      margin-bottom: 5px;
    }
    .empty-final-btndebug {
      margin-bottom: 5px;
    }
    .subheader {

    }

    .cart-checkout {
      background: limegreen;
    }

    .cart-return{
      background: limegreen;
    }
    </style>
  </head>
  <body>
    <div class="container">
      <header class="header">
        <br>
        <h1 class="header-logo">NO-Store-Selected</h1>
        <br>
        <a style="display: inline-block; color: white;"  onclick="ResetEmergency()" class="button empty-final-btndebug">ResetEmergency</a>
        <br>

        <label   style="position: relative; font-weight: bold;font-size: 1.17em;" class="debugonoff">
          <input type="radio" name="donoff" onclick="debugload(this.value)" value="yes"> debug on</label>
          <label style="position: relative; font-weight: bold;font-size: 1.17em;" class="debugonoff"><input type="radio" name="donoff" onclick="debugload(this.value)" value="no"> debug off</label>

          <nav class="header-nav">

			<!-- The buttons to choose a store -->
			<form class="TheForm2" id="myForm2" action="testservlet" method="post">
				<ul style="margin-block-start: 0; margin-block-end: 0;padding-inline-start: 0;">
             		<li><input type="radio" name="Store" onclick="storeload(this.value)" value="target"> Target</li>
             		<li><input type="radio" name="Store" onclick="storeload(this.value)" value="costco"> Costco</li>
              		<li><input type="radio" name="Store" onclick="storeload(this.value)" value="walmart"> Walmart</li>
              	</ul>
            </form>
          </nav>
        </header>
        <br>
        <br>
        <div class="subheader">
          <div class="debugscontainer">
            <h2>Debugcarthtml</h2>
            <div class="debug">

            </div>
            <h2>Debugsessionstoragestate</h2>
            <div class="debug2">

            </div>
            <h2>Debugidofproductandcartitem</h2>
            <div class="debug3">

            </div>
            <h2>Debugspecificobjectinarrayofobjects</h2>
            <div class="debug4">

            </div>
            <h2>Debug5contentsofarrayandwhatissubmittedbytheform</h2>
            <div class="debug5">

            </div>
            <h2>Debug6idofaddcartitem</h2>
            <div class="debug6">

            </div>
            <h2>Debug7tobeused</h2>
            <div class="debug7">

            </div>
            <h2>Debug8tobeused</h2>
            <div class="debug8">

            </div>
            <h2>Debug9tobeused</h2>
            <div class="debug9">

            </div>
            <h2>Debug10tobeused</h2>
            <div class="debug10">

            </div>
          </div>

        </div>
        <div class="picW">
          <img  src="maptmpwallmart.png">
        </div>
        <div class="picC">
          <img  src="maptmpcostco.png">
        </div>
        <div class="picT">
          <img  src="maptmptarget.png">
        </div>
        <div class="tableHolder2">
          <table  id="myTable2">
            <thead>
              <tr>
                <th >id</th>
                <th >Name</th>
                <th >Department</th>
                <th >locationX</th>
                <th >locationY</th>

              </tr>
            </thead>
            <tbody class="products2">

            </tbody>

          </table>
          <div class="map-buttons">
            <a  class="button empty-final-btn">Reset</a>
            <a  class="button cart-return">Return</a>
          </div>
        </div>

        <div class="tableHolder">
          <input style="height: 30px; position: sticky; top: 0; width: 173px;" type="text" id="myInputname" onkeyup="search()" placeholder="Search for names.." title="Type in a name">
          <input style="height: 30px; position: sticky; top: 0; width: 173px;" type="text" id="myInputdepartment" onkeyup="search()" placeholder="Search for department.." title="Type in a name">
          <table  id="myTable">
            <tbody class="products">
              <tr>
                <!--When a header is clicked, run the sortTable function, with a parameter, 0 for sorting by names, 1 for sorting by department-->
                <th style="width:173px;"onclick="sortTable(0)">Name</th>
                <th style="width:173px;" onclick="sortTable(1)">Department</th>
                <th></th>

              </tr>
            </tbody>

          </table>
        </div>
        <!-- products -->
        <br>
        <br>

        <div class="shopping-cart">
        <!-- This is where the tsp comes in -->
          <form class="TheForm" id="myForm" action="page2" method="post">
          <!-- <input type="hidden" name="shoppingList" value="?????">-->
            <div class="shopping-cart-head">
              <span class="product-quantity">0</span> Product(s) in Cart
            </div>
            <ul class="shopping-cart-list">
            </ul>
            <div class="cart-buttons">
              <a  class="button empty-cart-btn">Empty</a>
              <a  class="button cart-checkout">Get Path</a>
            </div>
          </form>

        </div>
        <div class="checking-out">
        </div>


      </div>


    </body>
	
    <script type="text/javascript">
    var test = localStorage.getItem("store");
    var tileVAR = document.querySelector(".header-logo");
    if (test != "costco" && test != "walmart" && test != "target"){
      tileVAR.innerHTML = "SELECT-STORE-PLEASE";

  }else{tileVAR.innerHTML = test;
  }
  //  if (test == "costco"){
    //}
    //if (test == "walmart"){
    //  document.getElementsByClassName("picW")[0].style.display=viewPic;

    //}
    //if (test == "target"){
      //document.getElementsByClassName("picT")[0].style.display=viewPic;

  //  }
     var  productsInCart= [];//start with empty cart here for no seesion storage overlap
     var debugVAR = document.querySelector(".debug");
     var debug2VAR = document.querySelector(".debug2");
     var debug3VAR = document.querySelector(".debug3");
     var debug4VAR = document.querySelector(".debug4");
     var debug5VAR = document.querySelector(".debug5");
     var debug6VAR = document.querySelector(".debug6");
     var debug7VAR = document.querySelector(".debug7");
     var debug8VAR = document.querySelector(".debug8");
     var debug9VAR = document.querySelector(".debug9");
     var debug10VAR = document.querySelector(".debug10");//lots of debugggin
     window.addEventListener('beforeunload', function (e) {
       if(sessionStorage.length == 0){//test if anything is stored
         debug2VAR.innerHTML = "empty";}
         else{
           debug2VAR.innerHTML = sessionStorage.getItem("productsInCartTest");
           var backupRefresh = document.querySelector(".shopping-cart-list");
           sessionStorage.setItem("thehtml", backupRefresh.innerHTML);//stores a piece of html code

           productsInCart = JSON.parse(sessionStorage.getItem("productsInCartTest"));

         }
         e.returnValue = '';
         //sessionStorage.clear();
       });



       function storeload(value){
         if(value == "walmart"){
           sessionStorage.clear();
           localStorage.setItem("store", "walmart");
           var mytable = document.getElementById("myTable");
           var mytable2 = document.getElementById("myTable2");
           var button = document.querySelectorAll(".button");
           var product = document.querySelectorAll(".product");
           var product2 = document.querySelectorAll(".product2");
           var schead = document.querySelector(".shopping-cart-head");
           schead.style.backgroundColor = "rgb(173, 170, 0)";


           for (i = 0; i < button.length; i++) {
             button[i].style.backgroundColor = "yellow";
             button[i].style.color = "black";
           }
           for (i = 0; i < product.length; i++) {
             product[i].style.backgroundColor = "rgb(179, 176, 36)";

           }
           for (i = 0; i < product2.length; i++) {
             product2[i].style.backgroundColor = "rgb(179, 176, 36)";

           }

document.getElementById("myForm2").submit();

         }
         else if(value == "target"){
           sessionStorage.clear();
           localStorage.setItem("store", "target");
           document.getElementById("myForm2").submit();

         }
         else if(value == "costco"){
           sessionStorage.clear();
           localStorage.setItem("store", "costco");
           document.getElementById("myForm2").submit();


         }



       }



       function ResetEmergency(){
         productsInCart = [];
   localStorage.clear();
         sessionStorage.clear();
         location.reload();

       }
       window.onload = function() {
	         if(sessionStorage.length == 0){
	           debug2VAR.innerHTML = "empty";
	
	         }
	         else{
	           var backupOnload = document.querySelector(".shopping-cart-list");
	           backupOnload.innerHTML = sessionStorage.getItem("thehtml");
	           //loads another piece of webpage
	           debug10VAR.innerHTML= JSON.stringify(productsInCart[0].product.id);
	           for (let i = 0; i < productsInCart.length; i++) {
	             document.getElementById(JSON.stringify(productsInCart[i].product.id)).click();
	           }
	
	         }

			var test = localStorage.getItem("store");
	         var viewPic = sessionStorage.getItem("Pic");
	         var viewTableHolder2 = sessionStorage.getItem("TableHolder2");
	         var viewShoppingcart = sessionStorage.getItem("Shopping-cart");
	         var viewTableHolder = sessionStorage.getItem("TableHolder");
	         if (test == "costco"){
	           document.getElementsByClassName("picC")[0].style.display=viewPic;
	
	         }
	         if (test == "walmart"){
	           document.getElementsByClassName("picW")[0].style.display=viewPic;
	
	         }
	         if (test == "target"){
	           document.getElementsByClassName("picT")[0].style.display=viewPic;
	
	         }
	         document.getElementsByClassName("tableHolder2")[0].style.display=viewTableHolder2;
	         document.getElementsByClassName("shopping-cart")[0].style.display=viewShoppingcart;
	         document.getElementsByClassName("tableHolder")[0].style.display=viewTableHolder;

       }
       
       function goBack(){
	         var viewPic = sessionStorage.getItem("Pic");
	         var test = localStorage.getItem("store");
	
	         var viewTableHolder2 = sessionStorage.getItem("TableHolder2");
	         var viewShoppingcart = sessionStorage.getItem("Shopping-cart");
	         var viewTableHolder = sessionStorage.getItem("TableHolder");
	         if (test == "costco"){
	           document.getElementsByClassName("picC")[0].style.display=viewPic;
	
	         }
	         if (test == "walmart"){
	           document.getElementsByClassName("picW")[0].style.display=viewPic;
	
	         }
	         if (test == "target"){
	           document.getElementsByClassName("picT")[0].style.display=viewPic;
	
	         }
	         document.getElementsByClassName("tableHolder2")[0].style.display=viewTableHolder2;
	         document.getElementsByClassName("shopping-cart")[0].style.display=viewShoppingcart;
	         document.getElementsByClassName("tableHolder")[0].style.display=viewTableHolder;

       }

       function debugload(yn){
         if(yn == "yes"){
           document.getElementsByClassName("debugscontainer")[0].style.display="initial";
           debug7VAR.innerHTML=document.getElementsByClassName("debugscontainer")[0];
         }else if(yn == "no"){
           document.getElementsByClassName("debugscontainer")[0].style.display="none";

         }


       }
       var checkout = "no";

       //debug10VAR.innerHTML= JSON.stringify(d0);

       var cartVAR =     document.querySelector(".shopping-cart-list");
       //var clear =     sessionStorage.getItem("clearF");

       var products2VAR =     document.querySelector(".products2");
       //debugVAR.innerHTML = sessionStorage.getItem("productsF");



       if(sessionStorage.length == 0){
         debug2VAR.innerHTML = "empty";}
         else{
           debug2VAR.innerHTML = sessionStorage.getItem("productsInCartTest");
           productsInCart = JSON.parse(sessionStorage.getItem("productsInCartTest"));

         }


         //cartVAR.innerHTML = sessionStorage.getItem("productsF");
         products2VAR.innerHTML = sessionStorage.getItem("productsF2");
         var ShoppingCart = (function($) {


           var productsVAR = document.querySelector(".products"),


           resetVAR = document.querySelector(".empty-final-btn"),


           returnVAR = document.querySelector(".cart-return"),
           productQuantityVAR = document.querySelector(".product-quantity"),
           emptycartVAR = document.querySelector(".empty-cart-btn"),
           cartCheckoutVAR = document.querySelector(".cart-checkout");


debug8VAR.innerHTML = localStorage.getItem("store");
var test = localStorage.getItem("store");
if (test == "walmart" && '${message2}' != '[]' ){
  
  var products = '${message2}';
  localStorage.setItem("holder", '${message2}')
}
if (test == "target"  && '${message2}' != '[]'){
 var products = '${message2}';
 localStorage.setItem("holder", '${message2}')

}
if (test == "costco"  && '${message2}' != '[]'){
  var products = '${message2}';
  localStorage.setItem("holder", '${message2}')

}else{
	var products = localStorage.getItem("holder");
}
			//var products = JSON.stringify(products);
			debug9VAR.innerHTML = products;
			
			var products = JSON.parse(products);
           	var makeProductList = function() {
           	products.forEach(function(item) {
              
		var hold;
               var productVAR = document.createElement("tr");
               productVAR.className = "product";

               productVAR.innerHTML =' <td class="product-name">'+item.name+'</td>'+
               '<td class="product-department">'+item.department+'</td>'+
               '<td class="product-add-to-cart">'+
               '<a  class="button add-to-cart" data-id="'+item.id+'" id="'+item.id+'" >Add to Cart</a>'+
               '</td>'+
               '</tr>';

               productsVAR.appendChild(productVAR);
             });
           }

           	// Updates the cart list, call whenever it changes
           var updateCartList = function() {

             cartVAR.innerHTML = "";
             //debugVAR.innerHTML = "";
             products2VAR.innerHTML = "";

             //finalVAR.innerHTML = "";
             debug5VAR.innerHTML = JSON.stringify(productsInCart);

             productsInCart.forEach(function(item) {
               //every element of the array or in this case every object in the productsincart array is used and appended
               debug4VAR.innerHTML = JSON.stringify(item);

               var li = document.createElement("li");
               li.id = item.product.id;
               var product2VAR = document.createElement("tr");
               product2VAR.className = "product2";
               product2VAR.innerHTML = '<td class="product2-id">'+item.product.id+'</td>'+
               '<td class="product2-name">'+item.product.name+'</td>'+
               '<td class="product2-department">'+item.product.department+'</td>'+
               '<td class="product2-locationX">'+item.product.locationX+'</td>'+
               '<td class="product2-locationY">'+item.product.locationY+'</td>'+
'</tr>';
               products2VAR.appendChild(product2VAR);
               //for second product list at checkout not displayed until then


               //the type hidden is for form submit without view exess html code
               li.innerHTML = ' '+item.quantity+' '+ item.product.name+' '+
               '<input type="hidden" name="name"  value="'+item.product.name+'" class="pathY"/>'+
               '<input type="hidden" name="locationY"  value="'+item.product.locationY+'" class="pathY"/>'+
               '<input type="hidden" name="locationX"  value="'+item.product.locationX+'" class="pathX"/>'+
               '<input type="hidden" name="department"  value="'+item.product.department+'" class="pathDepartment"/>'+
               '<input type="hidden" name="section"  value="'+item.product.section+'" class="pathSection"/>'+
               '<input type="hidden" name="aisle"  value="'+item.product.aisle+'" class="pathAilse"/>'+
               '<input type="hidden" name="id"  value="'+li.id+'" class="pathID"/>'+
               '<br>'+
               '<a  class="button Remove-from-cart" data-id="'+li.id+'" id="'+li.id+'">Remove from Cart</a> ';
               cartVAR.appendChild(li);

               //debugVAR.innerHTML = cartVAR.innerHTML ;
             });

             productQuantityVAR.innerHTML = productsInCart.length;
             //sessionStorage.setItem("productsF", debugVAR.innerHTML);
             sessionStorage.setItem("productsF2", products2VAR.innerHTML);
             creatCartButtons()
           }


           // Function that generates Empty Cart and Checkout buttons based on condition that checks if productsInCart array is empty
           var creatCartButtons = function() {
             if(productsInCart.length > 0) {
               emptycartVAR.style.display = "inline";
               cartCheckoutVAR.style.display = "inline"
             } else {
               emptycartVAR.style.display = "none";
               cartCheckoutVAR.style.display = "none";
             }
           }

           // Setting up listeners for click event on all products and Empty Cart button as well
           var setupListeners = function() {
             productsVAR.addEventListener("click", function(event) {
               var el = event.target;
               if(el.classList.contains("add-to-cart")) {
                 var elId = el.dataset.id;
                 debug3VAR.innerHTML = JSON.stringify(elId);
                 addToCart(elId);

               }
             });
             cartVAR.addEventListener("click", function(event) {
               var el = event.target;
               if(el.classList.contains("Remove-from-cart")) {
                 var elId = el.dataset.id;


                 removeFromCart(elId);
               }
             });

             emptycartVAR.addEventListener("click", function(event) {

               productsInCart = [];
               sessionStorage.clear();

               location.reload();
             });
             resetVAR.addEventListener("click", function(event) {

               productsInCart = [];
               sessionStorage.clear();
               location.reload();

               //updateCartList();
             });
             cartCheckoutVAR.addEventListener("click", function(event) {

               sessionStorage.setItem("Pic", "block");
               sessionStorage.setItem("TableHolder2", "block");
               sessionStorage.setItem("Shopping-cart", "none");
               sessionStorage.setItem("TableHolder", "none");
               sessionStorage.setItem("productsInCartTest", JSON.stringify(productsInCart));

               document.getElementById("myForm").submit();
               
            	// Get the sorted products from TSPRunningServlet and use them
            	if('${listString}' != '[]') {
	               	var cartProducts = '${listString}';
	               	localStorage.setItem("cartString", '${listString}')
	            }

               	productsInCart = JSON.parse(cartProducts);
               	updateCartList();
             });
             cartCheckoutVAR.addEventListener("dblclick", function(event) {

               sessionStorage.setItem("Pic", "block");
               sessionStorage.setItem("TableHolder2", "block");
               sessionStorage.setItem("Shopping-cart", "none");
               sessionStorage.setItem("TableHolder", "none");
               sessionStorage.setItem("productsInCartTest", JSON.stringify(productsInCart));

               goBack();


               //updateCartList();
             });

             returnVAR.addEventListener("click", function(event) {


               sessionStorage.setItem("Pic", "none");
               sessionStorage.setItem("TableHolder2", "none");
               sessionStorage.setItem("Shopping-cart", "block");
               sessionStorage.setItem("TableHolder", "block");
               goBack();
               //productsInCart = sessionStorage.getItem("productsInCartF");

              //updateCartList();

             });
           }

           var addToCart = function(id) {
             var obj = products[id];

             // Check if item is already in the cart or not
             if(productsInCart.length === 0 || productFound(obj.id) === undefined) {
               productsInCart.push({product: obj, quantity: 1});
               sessionStorage.setItem("productsInCartTest", JSON.stringify(productsInCart));
               
               // Set the button to "In the Cart" as soon as product is added
               var targetbutton = document.getElementsByClassName("button add-to-cart")[obj.id];
               debug6VAR.innerHTML = JSON.stringify(obj.id);
               targetbutton.style.background= "rgb(70, 70, 70)";
               targetbutton.style.visibility = "hidden";
             } else {
               //productsInCart.forEach(function(item) {
                 //if(item.product.id === obj.id) {

                   //var targetbutton = document.getElementsByClassName("button add-to-cart")[obj.id];
                   //debug6VAR.innerHTML = JSON.stringify(obj.id);
                   //targetbutton.innerHTML = "In The Cart";
                   //targetbutton.style.background= "rgb(0, 33, 0)";


                 //}
               //});
             }

             updateCartList();
           }

           var removeFromCart = function(id) {
             var obj = products[id];

             productsInCart.forEach(function(item) {

               if (item.product.id == obj.id) {
                 if(document.getElementsByClassName("button add-to-cart")[obj.id].style.visibility == "hidden"){
                   var targetbutton2 = document.getElementsByClassName("button add-to-cart")[obj.id];
                   targetbutton2.style.visibility = "visible";
                   targetbutton2.style.background= " rgb(255, 33, 0)";
                 }
                 
                 var pos = productsInCart.indexOf(productFound(obj.id));
                 debugVAR.innerHTML = productsInCart.indexOf(productFound(obj.id));
                 productsInCart.splice(pos, 1);
               }
             });


             updateCartList();
           }
           var productFound = function(productId) {
             return productsInCart.find(function(item) {
               return item.product.id === productId;
             });
           }



           var init = function() {
             makeProductList();
             setupListeners();
           }

           return {
             init: init
           };

         })();

         ShoppingCart.init();
         function sortTable(n) {
           var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
           table = document.getElementById("myTable");
           switching = true;
           dir = "asc";

           while (switching) {
             switching = false;
             rows = table.rows;

             for (i = 1; i < (rows.length - 1); i++) {

               shouldSwitch = false;

               x = rows[i].getElementsByTagName("TD")[n];
               y = rows[i + 1].getElementsByTagName("TD")[n];


               if (n == 2){
                 if (dir == "asc") {
                   if (Number(x.innerHTML.replace('$','')) > Number(y.innerHTML.replace('$',''))) {

                     shouldSwitch= true;
                     break;
                   }
                 } else if (dir == "desc") {
                   if (Number(x.innerHTML.replace('$','')) < Number(y.innerHTML.replace('$',''))) {

                     shouldSwitch = true;
                     break;
                   }
                 }
               }
               else if (n != 2) {
                 if (dir == "asc") {
                   if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {

                     shouldSwitch= true;
                     break;
                   }
                 } else if (dir == "desc") {
                   if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {

                     shouldSwitch = true;
                     break;
                   }
                 }
               }
             }
             if (shouldSwitch) {

               rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
               switching = true;

               switchcount ++;
             } else {

               if (switchcount == 0 && dir == "asc") {
                 dir = "desc";
                 switching = true;
               }
             }
           }
         }

         function search() {
           var input1, filter1, td1, i, txtValue1, input2, filter2, tr, td2, txtValue2;
           input1 = document.getElementById("myInputname");
           filter1 = input1.value.toUpperCase();
           input2 = document.getElementById("myInputdepartment");
           filter2 = input2.value.toUpperCase();
           tr = document.getElementsByClassName("product");

           for (i = 0; i < tr.length; i++) {
             td1 = tr[i].getElementsByClassName("product-name")[0];
             td2 = tr[i].getElementsByClassName("product-department")[0];
             txtValue1 = td1.textContent || td1.innerText;

             txtValue2 = td2.textContent || td2.innerText;
             if (txtValue1.toUpperCase().indexOf(filter1) > -1 && txtValue2.toUpperCase().indexOf(filter2) > -1) {
               tr[i].style.display = "";
             } else {
               tr[i].style.display = "none";
             }
           }
         }





         </script>





        </html>
