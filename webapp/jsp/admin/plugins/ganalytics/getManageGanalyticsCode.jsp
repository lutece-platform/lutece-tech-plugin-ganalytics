<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="ganalytics" scope="session" class="fr.paris.lutece.plugins.ganalytics.web.GanalyticsJspBean" />

<% ganalytics.init( request, ganalytics.RIGHT_MANAGE_GANALYTICS ); %>
<%= ganalytics.getManageGanalyticsCode ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>
