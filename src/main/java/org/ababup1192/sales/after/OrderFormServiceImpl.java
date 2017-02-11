package org.ababup1192.sales.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    private final EntityManager entityManager;
    private final OrderFormRepository orderFormRepository;

    @Autowired
    public OrderFormServiceImpl(EntityManager entityManager, OrderFormRepository orderFormRepository) {
        this.entityManager = entityManager;
        this.orderFormRepository = orderFormRepository;
    }

    @Override
    public void truncate() {
        orderFormRepository.truncate();
    }

    @Override
    public void drop() {
        orderFormRepository.drop();
    }

    @Override
    public Optional<OrderForm> findByClientNameAndAddressAndDate(String clientName, String address, Date date) {
        final String jpql = "SELECT DISTINCT o FROM OrderForm o INNER JOIN FETCH o.client AS c " +
                "WHERE c.name = :clientName AND c.address = :address AND o.date = :date";
        TypedQuery<OrderForm> query = entityManager.createQuery(jpql, OrderForm.class);
        query.setParameter("clientName", clientName);
        query.setParameter("address", address);
        query.setParameter("date", date);

        return query.getResultList().stream().findFirst();
    }
}
