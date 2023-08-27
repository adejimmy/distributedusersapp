package com.taxapplication.distributedusers.exception;

public class OrganizationServiceException extends RuntimeException{

    private static final long serialVersionUID = 1348771109171435607L;

    public OrganizationServiceException(String message)
    {
        super(message);
    }
}
