package pe.cibertec.dawi.model.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum EstadoEnum {

    INACTIVO(false, "Inactivo"),
    ACTIVO(true, "Activo")
    ;

    private Boolean code;
    private String label;

    EstadoEnum(Boolean code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<EstadoEnum> findAll() {
        List<EstadoEnum> list = new ArrayList<EstadoEnum>();

        for (EstadoEnum status : EstadoEnum.values()) {
            list.add(status);
        }
        return list;
    }

    public static EstadoEnum findByCode(Boolean code) {
        EstadoEnum result = INACTIVO;
        if (code) {
            return ACTIVO;
        }
        return result;
    }

    public static EstadoEnum findByLabel(String label) {
        if (StringUtils.isNotBlank(label)) {
            for (EstadoEnum status : EstadoEnum.values()) {
                if (status.toString().equalsIgnoreCase(label)) {
                    return status;
                }
            }
        }
        return null;
    }

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
