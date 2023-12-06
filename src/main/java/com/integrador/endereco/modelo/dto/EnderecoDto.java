package com.integrador.endereco.modelo.dto;

import com.integrador.endereco.modelo.entity.EnderecoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EnderecoDto {

    private Long codigo_end;
    private String cep_end;
    private String uf_end;
    private String cidade_end;
    private String rua_end;
}
