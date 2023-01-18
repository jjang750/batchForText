package com.example.batchprocessing.beans;

import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@ToString
public class InspectionMasterVo {

    private static final Logger log = LoggerFactory.getLogger(InspectionMasterVo.class);

    private String APTCD
            ,DONGHO
            ,BILLYM
            ,CUST_NO
            ,HOUSE_NO
            ,REGULATION_DAY
            ,TRANS_DATE
            ,USAGE_HOUSE
            ,USAGE_COMMON_A
            ,USAGE_COMMON_B
            ,PYONG
            ,PYONG_TYPE
            ,NUMBER_OF_HOUSE
            ,NUMBER_OF_HANDICAPPED
            ,REAL_USAGE
            ,FIRST_FARE
            ,USAGE_FARE
            ,USAGE_0_FARE
            ,WELFARE_DISCOUNT
            ,AUTO_DISCOUNT
            ,INTERNET_DISCOUNT
            ,ELECTRIC_FARE
            ,VAT
            ,ELECTRIC_FUND
            ,SUB_TOTAL
            ,TV_FARE
            ,DAN_SU
            ,CREATEDT
            ,RETURNDT
            ,MODIFYDT
            ,TRANS_STATE
            ,DONGHO_STATUS
            ,NUMBER_OF_LIFE
            ,NUMBER_OF_MERIT
            ,NUMBER_OF_FAMILY
            ,FAMILY_FARE
            ,SUPPORT_FARE
            ,TRANS_TYPE
            ,ELECTRIC_FUND_DISCOUNT
            ,FUEL_FARE
            ,MEDICAL_DISCOUNT
            ,DISABLED_DISCOUNT
            ,MERIT_DISCOUNT
            ,LOW_INCOME_DISCOUNT
            ,BASIC_LIFE_DISCOUNT
            ,PATRIOT_DISCOUNT
            ,SOCIAL_WELFARE
            ,PLAN_FARE
            ,LOWER_INCOME_DISCOUNT
            ,RESERVE_BASIC_FARE
            ,BLACKOUT_REWARD
            ,RW_ELEC_SUPPORT
            ,RW_TV_SUPPORT
            ,EXCESS_FARE
            ,TRANS_POWER_SUPPORT
            ,SUMMER_DISCOUNT
            ,BASIC_LIFE_DISCOUNT2
            ,NUMBER_OF_LIFE2
            ,NUMBER_OF_LOWER
            ,NUMBER_OF_LOWER2
            ,LOWER_INCOME_DISCOUNT2
            ,CURMONIND01
            ,NUMBER_OF_E_VOUCHER
            ,E_VOUCHER_DISCOUNT
            ,SUMMER_DISCOUNT_7
            ,SUMMER_DISCOUNT_8
            ,REAL_CURMONIND01
            ,CURMONIND01_TYPE
            ,MUST_USE_DISCOUNT
            ,BABY_DISCOUNT
            ,NUMBER_BABY
            ,CONSTATUS
            ,AUTOPUSH
            ,JUL_SUMMER_RETRO
            ,AUG_SUMMER_RETRO
            ,JUL_WELFARE_RETRO
            ,AUG_WELFARE_RETRO
            ,JUL_POWER_SAVE
            ,AUG_POWER_SAVE
            ,BABY_RETRO
            ,ULJIN_SUP_FARE
            ,BORYUNG_SUP_FARE
            ,CLAIM_FARE
            ,ENVIR_DISCOUNT
            ,CLIMATE_FARE
            ,FUEL_ADJ_FARE
            ,SOSANG_SUP_FARE
            ,BOKJI_ADD_DISC;

    public InspectionMasterVo(String line, int lineNumber) {
        log.debug("Line : " + line + ", LineNumber : " + lineNumber);

        this.setAPTCD(line.substring(	31	,	36	));
        this.setDONGHO(line.substring(	28	,	36	));

        this.setREGULATION_DAY(line.substring(	12	,	14	));
        this.setCUST_NO(line.substring(	18	,	28	));
        this.setHOUSE_NO(line.substring(	28	,	36	));
        this.setBILLYM(line.substring(	36	,	42	));
        this.setNUMBER_OF_LIFE(line.substring(	42	,	44	));
        this.setNUMBER_OF_HANDICAPPED(line.substring(	44	,	46	));
        this.setNUMBER_OF_MERIT(line.substring(	48	,	50	));
        this.setNUMBER_OF_FAMILY(line.substring(	50	,	52	));
        this.setREAL_USAGE(line.substring(	52	,	61	));
        this.setFIRST_FARE(line.substring(	61	,	72	));
        this.setUSAGE_FARE(line.substring(	72	,	83	));
        this.setUSAGE_0_FARE(line.substring(	83	,	90	));
        this.setELECTRIC_FARE(line.substring(	123	,	134	));
        this.setVAT(line.substring(	134	,	145	));
        this.setELECTRIC_FUND(line.substring(	145	,	154	));
        this.setSUB_TOTAL(line.substring(	154	,	165	));
        this.setTV_FARE(line.substring(	165	,	174	));
        this.setDAN_SU(line.substring(	174	,	179	));
        this.setSUMMER_DISCOUNT(line.substring(	350	,	360	));
        this.setLOWER_INCOME_DISCOUNT2(line.substring(	376	,	386	));
        this.setNUMBER_OF_E_VOUCHER(line.substring(	386	,	388	));
        this.setE_VOUCHER_DISCOUNT(line.substring(	388	,	398	));
        this.setSUMMER_DISCOUNT_7(line.substring(	489	,	499	));
        this.setSUMMER_DISCOUNT_8(line.substring(	499	,	509	));
        this.setBABY_RETRO(line.substring(	509	,	519	));
        this.setULJIN_SUP_FARE(line.substring(	519	,	529	));
        this.setBORYUNG_SUP_FARE(line.substring(	529	,	539	));
        this.setFUEL_ADJ_FARE(line.substring(	569	,	579	));
        this.setSOSANG_SUP_FARE(line.substring(	579	,	589	));
        this.setBOKJI_ADD_DISC(line.substring(	589	,	599	));
    }

}
