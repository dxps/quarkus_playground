package org.devisions.cofeeshop;

import jakarta.json.Json;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalErrorMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {

        var cause = e.getCause() != null ? e.getCause().getMessage() : "";
        System.err.printf("[GlobalErrorMapper] [dbg] Got the exception type='%s' with message='%s' and its root cause (message)='%s'.\n",
                e.getClass().getName(), e.getMessage(), cause);

        if (e instanceof JsonbException) {
            var obj = Json.createObjectBuilder()
                    .add("error", e.getCause().getMessage()).build();
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(obj)
                    .build();
        }

        return Response.serverError().build();
    }

}
