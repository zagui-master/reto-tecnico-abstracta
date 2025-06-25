package generateReport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;

public class GenerateReport {
    public static void main(String[] args) {

        File reportOutputDirectory = new File("build/cucumber-reports/cucumber-html-reports");

        if (reportOutputDirectory.exists()) {
            deleteDirectory(reportOutputDirectory);
        }
        boolean created = reportOutputDirectory.mkdirs();
        if (!created) {
            System.out.println("No se pudo crear la carpeta del reporte: " + reportOutputDirectory.getAbsolutePath());
            return;
        }

        String jsonFile = "build/cucumber-reports/Cucumber.json";

        Configuration configuration = new Configuration(reportOutputDirectory, "Mi Proyecto");

        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList(jsonFile), configuration);
        reportBuilder.generateReports();

        System.out.println("Reporte generado en: " + reportOutputDirectory.getAbsolutePath());
    }

    private static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }
}
