package com.fabrick.api.dto.shared;


import lombok.Data;

@Data
public class DtoTaxRelief {

    String taxReliefId;

    Boolean isCondoUpgrade;

    String creditorFiscalCode;

    String beneficiaryType;

    DtoNaturalPersonBeneficiary naturalPersonBeneficiary;

    DtoLegalPersonBeneficiary legalPersonBeneficiary;
}