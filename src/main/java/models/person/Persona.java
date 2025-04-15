package models.person;

import lombok.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona implements Serializable {

    protected String nombre;
    protected String rut;

}
