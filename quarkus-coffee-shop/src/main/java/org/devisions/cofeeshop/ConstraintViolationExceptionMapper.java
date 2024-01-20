package org.devisions.cofeeshop;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        var statusBuilder = Response.status(Response.Status.BAD_REQUEST);
        e.getConstraintViolations().forEach(
                v -> statusBuilder.header("x-validation-error",
                v.getPropertyPath() + " " + v.getMessage()));
        return statusBuilder.build();
    }

}
