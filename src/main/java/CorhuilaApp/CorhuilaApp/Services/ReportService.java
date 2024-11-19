package CorhuilaApp.CorhuilaApp.Services;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import CorhuilaApp.auxClass.AcademicWorkDTO;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public byte[] generateAcademicWorkReportAsExcel(List<AcademicWorkDTO> works) throws Exception {
        // Cargar el archivo .jrxml desde resources
        InputStream reportStream = new ClassPathResource("Agendaa.jrxml").getInputStream();
        
        // Compilar el archivo .jrxml para generar un JasperReport
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Crear una fuente de datos usando la lista de trabajos académicos
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(works);

        // Parámetros adicionales del reporte (opcional)
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("REPORT_TITLE", "Reporte de Actividades Académicas");

        // Llenar el reporte con los datos y parámetros
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Configurar el exportador para Excel
        JRXlsxExporter exporter = new JRXlsxExporter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));

        // Configurar propiedades para el archivo Excel
        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setDetectCellType(true); // Detectar el tipo de celda para el formato adecuado
        config.setCollapseRowSpan(false); // Colapsar filas si es necesario
        config.setOnePagePerSheet(false);
        config.setRemoveEmptySpaceBetweenRows(true);
        exporter.setConfiguration(config);

        // Exportar a Excel
        exporter.exportReport();
        
        return out.toByteArray(); // Devolver el archivo Excel como array de bytes
    }
}
