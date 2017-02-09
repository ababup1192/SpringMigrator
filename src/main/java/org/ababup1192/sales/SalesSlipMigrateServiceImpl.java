package org.ababup1192.sales;

import org.ababup1192.sales.after.*;
import org.ababup1192.sales.before.SalesSlipRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class SalesSlipMigrateServiceImpl implements SalesSlipMigrateService {
    private SalesSlipRepository salesSlipRepository;
    private SalesRepository salesRepository;
    private SalesService salesService;

    private ClientRepository clientRepository;

    @Inject
    public SalesSlipMigrateServiceImpl(
            SalesSlipRepository salesSlipRepository,
            SalesRepository salesRepository,
            ClientRepository clientRepository
    ) {
        this.salesSlipRepository = salesSlipRepository;
        this.salesRepository = salesRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public void migrate() {
        salesService.truncate();

        salesSlipRepository.findAll().forEach((salesSlip) -> {
            OrderForm orderForm
            salesService.save(new Sales(salesSlip.getQuantity()));
        });
    }

    private OrderForm createOrderForm(String clientName, String address, Date date) {
        Client client = createClient(clientName, address);
    }

    private Client createClient(String name, String address) {
        return clientRepository.findByNameAndAddress(name, address)
                .stream().findFirst().orElseGet(() -> new Client(name, address));
    }

}
