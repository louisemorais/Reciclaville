package br.senai.lab364.futurodev.reciclaville.services.Dashboard;
import br.senai.lab364.futurodev.reciclaville.repositories.DeclarationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DashboardService implements DashboardInterf {
    private final DeclarationRepository declarationRepository;

    @Override
    public String resultDashboard() {
        List<Object[]> datas = declarationRepository.dashboard();

        StringBuilder result = new StringBuilder();
        for (Object[] line : datas) {
            String materialName = (String) line[0];
            Double totalTons = (Double) line[1];
            result.append(materialName).append(":\t").append(totalTons).append("t\n");
        }

        return result.toString();
    }
}
