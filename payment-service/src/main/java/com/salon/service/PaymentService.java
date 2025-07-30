package com.salon.service;

import com.razorpay.PaymentLink;
import com.salon.domain.PaymentMethod;
import com.salon.domain.PaymentOrderStatus;
import com.salon.modal.PaymentOrder;
import com.salon.payload.dto.BookingDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.payload.response.PaymentLinkResponse;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO user,
                                    BookingDTO booking,
                                    PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id);

    PaymentOrder getPaymentOderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO user,
                                          Long amount,
                                          Long orderId);

    String createStripePaymentLink(UserDTO user,
                                   Long amount,
                                   Long orderId);

}
