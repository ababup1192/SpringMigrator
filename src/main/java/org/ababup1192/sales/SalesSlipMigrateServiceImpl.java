package org.ababup1192.sales;

import org.ababup1192.sales.after.*;
import org.ababup1192.sales.before.SalesSlipRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class SalesSlipMigrateServiceImpl implements SalesSlipMigrateService {
    private final SalesSlipRepository salesSlipRepository;
    private final SalesService salesService;

    private final ClientRepository clientRepository;
    private final OrderFormService orderFormService;
    private final CommodityRepository commodityRepository;

    @Inject
    public SalesSlipMigrateServiceImpl(
            SalesSlipRepository salesSlipRepository,
            SalesService salesService,
            ClientRepository clientRepository,
            OrderFormService orderFormService,
            CommodityRepository commodityRepository
    ) {
        this.salesSlipRepository = salesSlipRepository;
        this.salesService = salesService;
        this.clientRepository = clientRepository;
        this.orderFormService = orderFormService;
        this.commodityRepository = commodityRepository;
    }

    @Transactional
    @Override
    public void migrate() {
        salesService.truncate();

        salesSlipRepository.findAll().forEach((salesSlip) -> {
            OrderForm orderForm = createOrderForm(salesSlip.getClientName(), salesSlip.getAddress(), salesSlip.getDate());
            Commodity commodity = createCommodity(salesSlip.getCommodityName(), salesSlip.getUnitPrice());

            salesService.save(new Sales(orderForm, commodity, salesSlip.getQuantity()));
        });
    }

    private OrderForm createOrderForm(String clientName, String address, Date date) {
        Client client = createClient(clientName, address);

        return orderFormService.findByClientNameAndAddressAndDate(clientName, address, date).map(orderForm -> {
            orderForm.setClient(client);
            return orderForm;
        }).orElseGet(() -> new OrderForm(client, date));
    }

    private Client createClient(String name, String address) {
        return clientRepository.findByNameAndAddress(name, address)
                .stream().findFirst().orElseGet(() -> new Client(name, address));
    }

    private Commodity createCommodity(String name, Integer unitPrice) {
        return commodityRepository.findByNameAndUnitPrice(name, unitPrice)
                .stream().findFirst().orElseGet(() -> new Commodity(name, unitPrice));
    }

}
