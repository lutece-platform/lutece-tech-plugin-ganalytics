<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="ganalytics" scope="session" class="fr.paris.lutece.plugins.ganalytics.web.GanalyticsJspBean" />

<%
    ganalytics.init( request, ganalytics.RIGHT_MANAGE_GANALYTICS );
    response.sendRedirect( ganalytics.doManageGanalyticsCode( request ) );
%>