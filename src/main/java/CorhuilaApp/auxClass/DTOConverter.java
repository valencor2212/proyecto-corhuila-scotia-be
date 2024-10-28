package CorhuilaApp.auxClass;

import CorhuilaApp.CorhuilaApp.Entity.AcademicWork;
import CorhuilaApp.CorhuilaApp.Entity.Producto;

import java.util.List;
import java.util.stream.Collectors;

public class DTOConverter {

    public static AcademicWorkDTO toAcademicWorkDTO(AcademicWork academicWork) {
        AcademicWorkDTO dto = new AcademicWorkDTO();
        dto.setId(academicWork.getId());
        dto.setName(academicWork.getName());
        dto.setEstimatedWeeklyTime(academicWork.getEstimatedWeeklyTime());
        dto.setEstimatedSemiannualTime(academicWork.getEstimatedSemiannualTime());

        List<ProductoDTO> productos = academicWork.getProductos()
                .stream()
                .map(DTOConverter::toProductoDTO)
                .collect(Collectors.toList());

        dto.setProductos(productos);

        return dto;
    }

    public static ProductoDTO toProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setAcademicWorkId(producto.getAcademicWork().getId());
        return dto;
    }

    public static List<AcademicWorkDTO> toAcademicWorkDTOList(List<AcademicWork> works) {
        return works.stream()
                .map(DTOConverter::toAcademicWorkDTO)
                .collect(Collectors.toList());
    }
}
