package valter.gabriell.io.moneyproject.ports;

import valter.gabriell.io.moneyproject.dto.ReportDto;

public interface IReportServicePort {
    ReportDto generateReportForLastMonth();
}
