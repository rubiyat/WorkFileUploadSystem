<%@ include file="includes/header.jsp"%>

<div class="container">
	<p class="heading"><b>Welcome To Work File Upload System</b></p>
	 <div class="modal-dialog">
		<div class="modal-content">
		 <form class="form" action="LoginControllerServlet" method="POST">
		 <p class="lead">Please Login</p>
		 
		  <% if(request.getAttribute("err") != null){ %>
		  	<p class="bg-danger"><%= request.getAttribute("err") %></p>
           <% } %>
		 
			  <div class="form-group">
                <div class="icon-addon addon-lg">
                    <input type="email" placeholder="Your Email" class="form-control" required>
                    <label for="email" class="glyphicon glyphicon-user"></label>
                </div>
              </div>
			  <div class="form-group">
                <div class="icon-addon addon-lg">
                    <input type="password" placeholder="Password" class="form-control" required>
                    <label for="email" class="glyphicon glyphicon-lock"></label>
                </div>
              </div>
			  <div class="checkbox">
				<label>
				  <input type="checkbox"> Check me out
				  
				</label>
				<a class="pull-right" href="registration.jsp">Registration</a>
			  </div>
			 
			  <button type="submit" class="btn btn-primary">Submit</button>
		 </form>
		
		</div>
	 </div>
     
    </div> <!-- /container -->
<%@ include file="includes/footer.jsp"%>