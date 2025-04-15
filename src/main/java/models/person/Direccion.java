package models.person;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Direccion implements Serializable {

    private String region;
    private String ciudad;
    private String poblacion;
    private String numeroCasa;

}
