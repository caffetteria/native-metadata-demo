package io.github.caffetteria.nmd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String cognome;

    @Getter @Setter
    private List<Ruolo> ruoli;

}
