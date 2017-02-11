package org.ababup1192.sales.after;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderFormService {
    void truncate();
    void drop();
    Optional<OrderForm> findByClientNameAndAddressAndDate(String clientName, String address, Date date);
}
