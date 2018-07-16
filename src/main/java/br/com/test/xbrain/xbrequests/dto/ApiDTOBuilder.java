package br.com.test.xbrain.xbrequests.dto;

import br.com.test.xbrain.xbrequests.entity.Delivery;
import br.com.test.xbrain.xbrequests.entity.Product;
import br.com.test.xbrain.xbrequests.entity.Request;

public class ApiDTOBuilder {

    // Request

    public static RequestDTO requestToRequestDTO(Request request) {
        return new RequestDTO(
                request.getRequestId(), request.getClientCode(),
                request.getDeliveryAdress(), request.getValue(),
                request.getProducts()
        );
    }

    public static Request requestDTOToRequest(RequestDTO request) {
        return new Request(
                request.getClientCode(), request.getDeliveryAdress(),
                request.getValue(), request.getProducts()
        );
    }

    // Delivery

    public static DeliveryDTO deliveryToDeliveryDTO(Delivery delivery) {
        return new DeliveryDTO(
                delivery.getDeliveryId(), delivery.getRequestId(),
                delivery.getDeliveryAdress()
        );
    }

    public static Delivery deliveryDTOToDelivery(DeliveryDTO delivery) {
        return new Delivery(
                delivery.getRequestId(), delivery.getDeliveryAdress()
        );
    }

}
