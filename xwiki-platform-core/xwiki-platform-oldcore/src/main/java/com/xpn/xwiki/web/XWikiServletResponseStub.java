/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * This stub is intended to simulate a servlet request in a daemon context, in order to be able to create a custom XWiki
 * context. This trick is used in to give a daemon thread access to the XWiki api.
 * 
 * @version $Id$
 */
public class XWikiServletResponseStub implements XWikiResponse
{
    private OutputStream outputStream;

    private ServletOutputStream servletOutputStream = new ServletOutputStream()
    {
        @Override
        public void write(int b) throws IOException
        {
            outputStream.write(b);
        }
    };

    public void setOutpuStream(OutputStream outputStream)
    {
        this.outputStream = outputStream;
    }

    public HttpServletResponse getHttpServletResponse()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void setCharacterEncoding(String s)
    {
        // TODO Auto-generated method stub

    }

    public void removeCookie(String cookieName, XWikiRequest request)
    {
        // TODO Auto-generated method stub

    }

    public void addCookie(Cookie cookie)
    {
        // TODO Auto-generated method stub

    }

    public boolean containsHeader(String name)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public String encodeURL(String url)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public String encodeRedirectURL(String url)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public String encodeUrl(String url)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public String encodeRedirectUrl(String url)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void sendError(int sc, String msg) throws IOException
    {
        // TODO Auto-generated method stub

    }

    public void sendError(int sc) throws IOException
    {
        // TODO Auto-generated method stub

    }

    public void sendRedirect(String location) throws IOException
    {
        // TODO Auto-generated method stub

    }

    public void setDateHeader(String name, long date)
    {
        // TODO Auto-generated method stub

    }

    public void addDateHeader(String name, long date)
    {
        // TODO Auto-generated method stub

    }

    public void setHeader(String name, String value)
    {
        // TODO Auto-generated method stub

    }

    public void addHeader(String name, String value)
    {
        // TODO Auto-generated method stub

    }

    public void setIntHeader(String name, int value)
    {
        // TODO Auto-generated method stub

    }

    public void addIntHeader(String name, int value)
    {
        // TODO Auto-generated method stub

    }

    public void setStatus(int sc)
    {
        // TODO Auto-generated method stub

    }

    public void setStatus(int sc, String sm)
    {
        // TODO Auto-generated method stub

    }

    public String getCharacterEncoding()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public String getContentType()
    {
        // TODO Auto-generated method stub
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException
    {
        return servletOutputStream;
    }

    public PrintWriter getWriter() throws IOException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void setContentLength(int len)
    {
        // TODO Auto-generated method stub

    }

    public void setContentType(String type)
    {
        // TODO Auto-generated method stub

    }

    public void setBufferSize(int size)
    {
        // TODO Auto-generated method stub

    }

    public int getBufferSize()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public void flushBuffer() throws IOException
    {
        // TODO Auto-generated method stub

    }

    public void resetBuffer()
    {
        // TODO Auto-generated method stub

    }

    public boolean isCommitted()
    {
        // TODO Auto-generated method stub
        return false;
    }

    public void reset()
    {
        // TODO Auto-generated method stub

    }

    public void setLocale(Locale loc)
    {
        // TODO Auto-generated method stub

    }

    public Locale getLocale()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
