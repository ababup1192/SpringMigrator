package org.ababup1192.sales.after;

import org.ababup1192.common.Environment;
import org.ababup1192.member.before.OldMember;
import org.ababup1192.member.before.OldMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    private final EntityManager entityManager;
    private final SalesRepository salesRepository;
    private final ClientRepository clientRepository;
    private final CommodityRepository commodityRepository;
    private final OrderFormRepository orderFormRepository;

    @Autowired
    public SalesServiceImpl(
            EntityManager entityManager,
            SalesRepository salesRepository,
            ClientRepository clientRepository,
            CommodityRepository commodityRepository,
            OrderFormRepository orderFormRepository) {
        this.entityManager = entityManager;
        this.salesRepository = salesRepository;
        this.clientRepository = clientRepository;
        this.commodityRepository = commodityRepository;
        this.orderFormRepository = orderFormRepository;
    }

    @Override
    public void truncate() {
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        clientRepository.truncate();
        commodityRepository.truncate();
        orderFormRepository.truncate();
        salesRepository.truncate();
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
    }

    @Override
    public void drop() {
        salesRepository.drop();
    }

    @Override
    public void save(Sales sales) {
        salesRepository.save(sales);
    }


}
