package br.com.test.xbrain.xbrequests.exception;


@SuppressWarnings("serial")
public class BadRequest400 extends RuntimeException {

    public BadRequest400() {}

    public BadRequest400(String message) {
        super(message);
    }

}