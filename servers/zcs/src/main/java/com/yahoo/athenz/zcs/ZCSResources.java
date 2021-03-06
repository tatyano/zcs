//
// This file generated by rdl 1.5.0. Do not modify!
//
package com.yahoo.athenz.zcs;

import com.yahoo.rdl.*;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

@Path("/v1")
public class ZCSResources {

    @GET
    @Path("/saml/login")
    @Produces(MediaType.APPLICATION_JSON)
    public void getSamlLogin(@QueryParam("url") String url) {
        try {
            ResourceContext context = this.delegate.newResourceContext(this.request, this.response);
            context.authenticate();
            GetSamlLoginResult result = new GetSamlLoginResult(context);
            this.delegate.getSamlLogin(context, url, result);
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.FORBIDDEN:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.TOO_MANY_REQUESTS:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception (" + code + ") for resource getSamlLogin");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }

    @GET
    @Path("/saml/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public void getSamlLogout(@QueryParam("url") String url) {
        try {
            ResourceContext context = this.delegate.newResourceContext(this.request, this.response);
            GetSamlLogoutResult result = new GetSamlLogoutResult(context);
            this.delegate.getSamlLogout(context, url, result);
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.FORBIDDEN:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.TOO_MANY_REQUESTS:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception (" + code + ") for resource getSamlLogout");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Status getStatus() {
        try {
            ResourceContext context = this.delegate.newResourceContext(this.request, this.response);
            Status e = this.delegate.getStatus(context);
            return e;
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            case ResourceException.BAD_REQUEST:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.NOT_FOUND:
                throw typedException(code, e, ResourceError.class);
            case ResourceException.UNAUTHORIZED:
                throw typedException(code, e, ResourceError.class);
            default:
                System.err.println("*** Warning: undeclared exception (" + code + ") for resource getStatus");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }

    @GET
    @Path("/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Schema getRdlSchema() {
        try {
            ResourceContext context = this.delegate.newResourceContext(this.request, this.response);
            context.authenticate();
            Schema e = this.delegate.getRdlSchema(context);
            return e;
        } catch (ResourceException e) {
            int code = e.getCode();
            switch (code) {
            default:
                System.err.println("*** Warning: undeclared exception (" + code + ") for resource getRdlSchema");
                throw typedException(code, e, ResourceError.class);
            }
        }
    }


    WebApplicationException typedException(int code, ResourceException e, Class<?> eClass) {
        Object data = e.getData();
        Object entity = eClass.isInstance(data) ? data : null;
        if (entity != null) {
            return new WebApplicationException(Response.status(code).entity(entity).build());
        } else {
            return new WebApplicationException(code);
        }
    }

    @Inject private ZCSHandler delegate;
    @Context private HttpServletRequest request;
    @Context private HttpServletResponse response;
    
}
