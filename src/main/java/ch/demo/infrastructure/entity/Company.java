package ch.demo.infrastructure.entity;

import ch.demo.domain.model.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Long id;
    private String code;
    private String name;

    public void from(CompanyDTO companyDTO){
        this.id = companyDTO.getId();
        this.code = companyDTO.getCode();
        this.name = companyDTO.getName();
    }
}
