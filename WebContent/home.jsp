 <%
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
            response.setDateHeader("Expires", -1);
        %>
        
        <%
            if(session.getAttribute("firstName") != null && session.getAttribute("firstName") != ""){
                String user= session.getAttribute("firstName").toString();
            
        %>
        
		<h1>Welcome <%=user%></h1><br>
		<a href='logout.jsp'>Logout</a>
		   
		   
		  <% } %>
		
