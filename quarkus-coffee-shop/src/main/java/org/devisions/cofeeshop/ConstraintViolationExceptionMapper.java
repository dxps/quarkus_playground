package org.devisions.cofeeshop;

import jakarta.json.Json;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        var errors = Json.createArrayBuilder();
        e.getConstraintViolations().forEach(
                v -> errors.add(v.getPropertyPath() + " " + v.getMessage())
        );
        var obj = Json.createObjectBuilder().add("errors", errors.build()).build();

        return Response.status(Response.Status.BAD_REQUEST).entity(obj).build();
    }

}
