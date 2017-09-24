<%
    session.setAttribute("firstName",null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>