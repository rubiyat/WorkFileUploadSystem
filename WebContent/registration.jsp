<%@ include file="includes/header.jsp"%>

<div class="container">
<br>
	 <div class="modal-dialog">
		<div class="modal-content">
			<form class="form" action="RegistrationControllerServlet"
				method="POST" onsubmit="myValidation()">

				<input type="hidden" name="command" value="ADD" />

				<p class="lead">Create Your Account</p>
				<div class="form-group">
					<input id="fn" type="text" placeholder="First Name" class="form-control" name="firstName" required>
				</div>
				<div class="form-group">
					<input id="ln" type="text" placeholder="Last Name" class="form-control" name="lastName" required>
				</div>
				<div class="form-group">
					<select class="form-control" name="occupation">
						<option value="do not select">Select Your Occupation</option>
						<option value="Teacher">Teacher</option>
						<option value="Student">Student</option>
					</select>
				</div>
				<div id="e" class="form-group">
					<input type="email" placeholder="Email Address"
						class="form-control" name="email" required>
				</div>
				<div id="p" class="form-group">
					<input type="text" placeholder="Phone Number" class="form-control" name="phone" required pattern="[01][0-9]{11}">
				</div>
				<div  class="form-group">
					<input type="password" placeholder="Password" class="form-control" id="password" required>
				</div>
				<div class="form-group">
					<input type="password" placeholder="Confirm Password" class="form-control" id="conformPassword" onkeyup="checkPass(); return false;"  name="password">
				</div>

					<button type="submit" class="btn btn-primary">Submit</button>
					
<%-- 					 <% if(request.getAttribute("err") != null){ %> --%>
<%--                 <%= request.getAttribute("err") %> --%>
<%--                 <% } %> --%>
				
			</form>
			<br />

		</div>
	</div>

</div>
<!-- /container -->

<%@ include file="includes/footer.jsp"%>