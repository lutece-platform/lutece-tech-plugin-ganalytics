/*
 * Copyright (c) 2002-2012, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the description of 'Mairie de Paris' nor 'Lutece' nor the descriptions of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.ganalytics.web;

import fr.paris.lutece.plugins.ganalytics.business.Ganalytics;
import fr.paris.lutece.plugins.ganalytics.business.GanalyticsHome;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;
import fr.paris.lutece.portal.web.constants.Messages;
import fr.paris.lutece.util.html.HtmlTemplate;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * Management of ganalytics
 */
public class GanalyticsJspBean extends PluginAdminPageJspBean
{
    ////////////////////////////////////////////////////////////////////////////
    // Constants

    // Right
    public static final String RIGHT_MANAGE_GANALYTICS = "GANALYTICS_MANAGEMENT";

    // Titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE = "ganalytics.manage_ganalytics.pageTitle";

    // Templates
    private static final String TEMPLATE_MANAGE_GANALYTICS = "/admin/plugins/ganalytics/manage_ganalytics.html";

    // Markers
    private static final String MARK_GOOGLE_ANALYTICS_CODE = "ganalytics_code";

    // Jsp definitions
    private static final String JSP_REDIRECT_TO_MANAGE_CODE = "getManageGanalyticsCode.jsp";

    // parameters
    private static final String PARAMETER_GANALYTICS_CODE = "code_google";

    /**
     * returns the template of the Ganalytics management
     * @param request The HttpRequest
     * @return template of management
     */
    public String getManageGanalyticsCode( HttpServletRequest request )
    {
        setPageTitleProperty( PROPERTY_PAGE_TITLE_MANAGE );

        Map<String, Object> model = new HashMap<String, Object>(  );
        Ganalytics ganalyticsCode = GanalyticsHome.findCode( getPlugin(  ) );
        model.put( MARK_GOOGLE_ANALYTICS_CODE, ganalyticsCode );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_MANAGE_GANALYTICS, getLocale(  ), model );

        return getAdminPage( template.getHtml(  ) );
    }

    /**
     * Returns the form to create/update a ganalytics
     * @param request The Http request
     * @return the ganalytics code of the ganalytics form
     */
    public String doManageGanalyticsCode( HttpServletRequest request )
    {
        String strCode = request.getParameter( PARAMETER_GANALYTICS_CODE );

        if ( strCode.equals( "" ) )
        {
            return AdminMessageService.getMessageUrl( request, Messages.MANDATORY_FIELDS, AdminMessage.TYPE_STOP );
        }

        Ganalytics ganalytics = GanalyticsHome.findCode( getPlugin(  ) );
        ganalytics.setCode( request.getParameter( PARAMETER_GANALYTICS_CODE ) );

        GanalyticsHome.update( ganalytics, getPlugin(  ) );

        // Redirect
        return JSP_REDIRECT_TO_MANAGE_CODE;
    }
}
