package valter.gabriell.io.moneyproject.infra.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import valter.gabriell.io.moneyproject.dto.MessageInput;
import valter.gabriell.io.moneyproject.dto.ReportDto;
import valter.gabriell.io.moneyproject.ports.IQueueManager;
import valter.gabriell.io.moneyproject.ports.IReportServicePort;

import java.time.LocalDate;

@Component
@EnableScheduling
public class SendEmailAtEndOfMonth implements IEmail {

    private final IQueueManager queueManager;
    private final IReportServicePort iReportServicePort;

    @Value("${email.name}")
    private String from;
    @Value("${email.to}")
    private String to;

    private static final String TIME_ZONE = "America/Sao_Paulo";


    public SendEmailAtEndOfMonth(IQueueManager queueManager, IReportServicePort iReportServicePort) {
        this.queueManager = queueManager;
        this.iReportServicePort = iReportServicePort;
    }

    private MessageInput getDataForEmail() {
        ReportDto reportDto = iReportServicePort.generateReportForLastMonth();
        return new MessageInput(from, to,
                reportDto.toString(),
                "Relatório do mês " + LocalDate.now().minusMonths(1).getMonth());
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?", zone = TIME_ZONE)
    public void send() {
        //relatorio de gastos
        queueManager.send(getDataForEmail().toString());
    }
}