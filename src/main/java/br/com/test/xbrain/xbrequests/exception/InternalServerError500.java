package br.com.test.xbrain.xbrequests.exception;


@SuppressWarnings("serial")
public class InternalServerError500 extends RuntimeException {

    public InternalServerError500() {}

    public InternalServerError500(String message) {
        super(message);
    }
}