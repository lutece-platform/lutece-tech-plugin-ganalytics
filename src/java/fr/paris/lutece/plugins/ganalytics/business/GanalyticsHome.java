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
package fr.paris.lutece.plugins.ganalytics.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.spring.SpringContextService;


/**
 * This class provides instances management methods (find, update, include,..) for Ganalytics objects
 */
public class GanalyticsHome
{
    // Static variable pointed at the DAO instance
    private static IGanalyticsDAO _dao = (IGanalyticsDAO) SpringContextService.getPluginBean( "ganalytics",
            "ganalyticsDAO" );

    /**
     * Return an instance of ganalytics whose identifier is specified in parameter
     * @param plugin The plugin
     * @return an instance of ganalytics
     */
    public static Ganalytics findCode( Plugin plugin )
    {
        return _dao.load( plugin );
    }

    /**
     * Update of the ganalytics which is specified in parameter
     * @param ganalytics The instance of the ganalytics which contains the data to store
     * @param plugin The plugin object
     */
    public static void update( Ganalytics ganalytics, Plugin plugin )
    {
        _dao.store( ganalytics, plugin );
    }

    /**
     * Return an instance of ganalytics whose identifier is specified in parameter
     * @param plugin The plugin
     * @return an instance of ganalytics
     */
    public static Ganalytics include( Plugin plugin )
    {
        return _dao.load( plugin );
    }
}
