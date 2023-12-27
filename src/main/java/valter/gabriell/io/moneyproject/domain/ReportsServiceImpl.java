package valter.gabriell.io.moneyproject.domain;

import valter.gabriell.io.moneyproject.dto.ReportDto;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.infra.entities.PaymentType;
import valter.gabriell.io.moneyproject.ports.IItemPersistencePort;
import valter.gabriell.io.moneyproject.ports.IReportServicePort;

import java.time.LocalDate;
import java.util.List;

public class ReportsServiceImpl implements IReportServicePort {
    private final IItemPersistencePort itemPersistencePort;

    public ReportsServiceImpl(valter.gabriell.io.moneyproject.ports.IItemPersistencePort iItemPersistencePort) {
        itemPersistencePort = iItemPersistencePort;
    }

    @Override
    public ReportDto generateReportForLastMonth() {
        List<ItemEntity> listLastMonth = itemPersistencePort
                .findAll()
                .stream()
                .filter(current -> current.getDate().getMonthValue() == getLastMonth())
                .toList();

        Category categoryMostFrequency = getCategoryCount(listLastMonth);
        PaymentType paymentTypeMostFrequency = getPaymentCount(listLastMonth);

        return  new ReportDto(
                "Seus maiores gastos do mês foram com: ",
                categoryMostFrequency,
                paymentTypeMostFrequency,
                listLastMonth
        );
    }

    private static Category getCategoryCount(List<ItemEntity> listLastMonth) {
        GetFieldCount<Category> getFieldCount = new GetFieldCount<>();
        return getFieldCount.getCount(listLastMonth);
    }

    private static PaymentType getPaymentCount(List<ItemEntity> listLastMonth) {
        GetFieldCount<PaymentType> getFieldCount = new GetFieldCount<>();
        return getFieldCount.getCount(listLastMonth);
    }


    private int getLastMonth() {
        return LocalDate.now().minusMonths(1).getMonthValue();
    }
}
