package com.yahoo.athenz.zcs;

import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

public final class PostAssertionConsumerServiceResult {

    PostAssertionConsumerServiceResult(ResourceContext context) {
    }

    public boolean isAsync() {
        return false;
    }

    public void done(int code, String entity, String location) {
        Response resp = Response.status(code).entity(entity)
            .header("Location", location)
            .build();
        throw new WebApplicationException(resp);
    }

    public void done(int code) {
        done(code, new ResourceError().code(code).message(ResourceException.codeToString(code)), "");
    }

    public void done(int code, String location) {
        done(code, new ResourceError().code(code).message(ResourceException.codeToString(code)), location);
    }

    public void done(int code, Object entity, String location) {
        //to do: check if the exception is declared, and that the entity is of the declared type
        WebApplicationException err = new WebApplicationException(Response.status(code).entity(entity)
            .header("Location", location)
          .build());
        throw err; //not optimal
    }

}
