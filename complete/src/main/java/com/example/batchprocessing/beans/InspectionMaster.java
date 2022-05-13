package com.example.batchprocessing.beans;

import com.example.batchprocessing.InspectionMasterBatchConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InspectionMaster {

    private static final Logger log = LoggerFactory.getLogger(InspectionMaster.class);

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

    public InspectionMaster(String line, int lineNumber) {
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

    public String getAPTCD() {
        return APTCD;
    }

    public void setAPTCD(String APTCD) {
        this.APTCD = APTCD;
    }

    public String getDONGHO() {
        return DONGHO;
    }

    public void setDONGHO(String DONGHO) {
        this.DONGHO = DONGHO;
    }

    public String getBILLYM() {
        return BILLYM;
    }

    public void setBILLYM(String BILLYM) {
        this.BILLYM = BILLYM;
    }

    public String getCUST_NO() {
        return CUST_NO;
    }

    public void setCUST_NO(String CUST_NO) {
        this.CUST_NO = CUST_NO;
    }

    public String getHOUSE_NO() {
        return HOUSE_NO;
    }

    public void setHOUSE_NO(String HOUSE_NO) {
        this.HOUSE_NO = HOUSE_NO;
    }

    public String getREGULATION_DAY() {
        return REGULATION_DAY;
    }

    public void setREGULATION_DAY(String REGULATION_DAY) {
        this.REGULATION_DAY = REGULATION_DAY;
    }

    public String getTRANS_DATE() {
        return TRANS_DATE;
    }

    public void setTRANS_DATE(String TRANS_DATE) {
        this.TRANS_DATE = TRANS_DATE;
    }

    public String getUSAGE_HOUSE() {
        return USAGE_HOUSE;
    }

    public void setUSAGE_HOUSE(String USAGE_HOUSE) {
        this.USAGE_HOUSE = USAGE_HOUSE;
    }

    public String getUSAGE_COMMON_A() {
        return USAGE_COMMON_A;
    }

    public void setUSAGE_COMMON_A(String USAGE_COMMON_A) {
        this.USAGE_COMMON_A = USAGE_COMMON_A;
    }

    public String getUSAGE_COMMON_B() {
        return USAGE_COMMON_B;
    }

    public void setUSAGE_COMMON_B(String USAGE_COMMON_B) {
        this.USAGE_COMMON_B = USAGE_COMMON_B;
    }

    public String getPYONG() {
        return PYONG;
    }

    public void setPYONG(String PYONG) {
        this.PYONG = PYONG;
    }

    public String getPYONG_TYPE() {
        return PYONG_TYPE;
    }

    public void setPYONG_TYPE(String PYONG_TYPE) {
        this.PYONG_TYPE = PYONG_TYPE;
    }

    public String getNUMBER_OF_HOUSE() {
        return NUMBER_OF_HOUSE;
    }

    public void setNUMBER_OF_HOUSE(String NUMBER_OF_HOUSE) {
        this.NUMBER_OF_HOUSE = NUMBER_OF_HOUSE;
    }

    public String getNUMBER_OF_HANDICAPPED() {
        return NUMBER_OF_HANDICAPPED;
    }

    public void setNUMBER_OF_HANDICAPPED(String NUMBER_OF_HANDICAPPED) {
        this.NUMBER_OF_HANDICAPPED = NUMBER_OF_HANDICAPPED;
    }

    public String getREAL_USAGE() {
        return REAL_USAGE;
    }

    public void setREAL_USAGE(String REAL_USAGE) {
        this.REAL_USAGE = REAL_USAGE;
    }

    public String getFIRST_FARE() {
        return FIRST_FARE;
    }

    public void setFIRST_FARE(String FIRST_FARE) {
        this.FIRST_FARE = FIRST_FARE;
    }

    public String getUSAGE_FARE() {
        return USAGE_FARE;
    }

    public void setUSAGE_FARE(String USAGE_FARE) {
        this.USAGE_FARE = USAGE_FARE;
    }

    public String getUSAGE_0_FARE() {
        return USAGE_0_FARE;
    }

    public void setUSAGE_0_FARE(String USAGE_0_FARE) {
        this.USAGE_0_FARE = USAGE_0_FARE;
    }

    public String getWELFARE_DISCOUNT() {
        return WELFARE_DISCOUNT;
    }

    public void setWELFARE_DISCOUNT(String WELFARE_DISCOUNT) {
        this.WELFARE_DISCOUNT = WELFARE_DISCOUNT;
    }

    public String getAUTO_DISCOUNT() {
        return AUTO_DISCOUNT;
    }

    public void setAUTO_DISCOUNT(String AUTO_DISCOUNT) {
        this.AUTO_DISCOUNT = AUTO_DISCOUNT;
    }

    public String getINTERNET_DISCOUNT() {
        return INTERNET_DISCOUNT;
    }

    public void setINTERNET_DISCOUNT(String INTERNET_DISCOUNT) {
        this.INTERNET_DISCOUNT = INTERNET_DISCOUNT;
    }

    public String getELECTRIC_FARE() {
        return ELECTRIC_FARE;
    }

    public void setELECTRIC_FARE(String ELECTRIC_FARE) {
        this.ELECTRIC_FARE = ELECTRIC_FARE;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getELECTRIC_FUND() {
        return ELECTRIC_FUND;
    }

    public void setELECTRIC_FUND(String ELECTRIC_FUND) {
        this.ELECTRIC_FUND = ELECTRIC_FUND;
    }

    public String getSUB_TOTAL() {
        return SUB_TOTAL;
    }

    public void setSUB_TOTAL(String SUB_TOTAL) {
        this.SUB_TOTAL = SUB_TOTAL;
    }

    public String getTV_FARE() {
        return TV_FARE;
    }

    public void setTV_FARE(String TV_FARE) {
        this.TV_FARE = TV_FARE;
    }

    public String getDAN_SU() {
        return DAN_SU;
    }

    public void setDAN_SU(String DAN_SU) {
        this.DAN_SU = DAN_SU;
    }

    public String getCREATEDT() {
        return CREATEDT;
    }

    public void setCREATEDT(String CREATEDT) {
        this.CREATEDT = CREATEDT;
    }

    public String getRETURNDT() {
        return RETURNDT;
    }

    public void setRETURNDT(String RETURNDT) {
        this.RETURNDT = RETURNDT;
    }

    public String getMODIFYDT() {
        return MODIFYDT;
    }

    public void setMODIFYDT(String MODIFYDT) {
        this.MODIFYDT = MODIFYDT;
    }

    public String getTRANS_STATE() {
        return TRANS_STATE;
    }

    public void setTRANS_STATE(String TRANS_STATE) {
        this.TRANS_STATE = TRANS_STATE;
    }

    public String getDONGHO_STATUS() {
        return DONGHO_STATUS;
    }

    public void setDONGHO_STATUS(String DONGHO_STATUS) {
        this.DONGHO_STATUS = DONGHO_STATUS;
    }

    public String getNUMBER_OF_LIFE() {
        return NUMBER_OF_LIFE;
    }

    public void setNUMBER_OF_LIFE(String NUMBER_OF_LIFE) {
        this.NUMBER_OF_LIFE = NUMBER_OF_LIFE;
    }

    public String getNUMBER_OF_MERIT() {
        return NUMBER_OF_MERIT;
    }

    public void setNUMBER_OF_MERIT(String NUMBER_OF_MERIT) {
        this.NUMBER_OF_MERIT = NUMBER_OF_MERIT;
    }

    public String getNUMBER_OF_FAMILY() {
        return NUMBER_OF_FAMILY;
    }

    public void setNUMBER_OF_FAMILY(String NUMBER_OF_FAMILY) {
        this.NUMBER_OF_FAMILY = NUMBER_OF_FAMILY;
    }

    public String getFAMILY_FARE() {
        return FAMILY_FARE;
    }

    public void setFAMILY_FARE(String FAMILY_FARE) {
        this.FAMILY_FARE = FAMILY_FARE;
    }

    public String getSUPPORT_FARE() {
        return SUPPORT_FARE;
    }

    public void setSUPPORT_FARE(String SUPPORT_FARE) {
        this.SUPPORT_FARE = SUPPORT_FARE;
    }

    public String getTRANS_TYPE() {
        return TRANS_TYPE;
    }

    public void setTRANS_TYPE(String TRANS_TYPE) {
        this.TRANS_TYPE = TRANS_TYPE;
    }

    public String getELECTRIC_FUND_DISCOUNT() {
        return ELECTRIC_FUND_DISCOUNT;
    }

    public void setELECTRIC_FUND_DISCOUNT(String ELECTRIC_FUND_DISCOUNT) {
        this.ELECTRIC_FUND_DISCOUNT = ELECTRIC_FUND_DISCOUNT;
    }

    public String getFUEL_FARE() {
        return FUEL_FARE;
    }

    public void setFUEL_FARE(String FUEL_FARE) {
        this.FUEL_FARE = FUEL_FARE;
    }

    public String getMEDICAL_DISCOUNT() {
        return MEDICAL_DISCOUNT;
    }

    public void setMEDICAL_DISCOUNT(String MEDICAL_DISCOUNT) {
        this.MEDICAL_DISCOUNT = MEDICAL_DISCOUNT;
    }

    public String getDISABLED_DISCOUNT() {
        return DISABLED_DISCOUNT;
    }

    public void setDISABLED_DISCOUNT(String DISABLED_DISCOUNT) {
        this.DISABLED_DISCOUNT = DISABLED_DISCOUNT;
    }

    public String getMERIT_DISCOUNT() {
        return MERIT_DISCOUNT;
    }

    public void setMERIT_DISCOUNT(String MERIT_DISCOUNT) {
        this.MERIT_DISCOUNT = MERIT_DISCOUNT;
    }

    public String getLOW_INCOME_DISCOUNT() {
        return LOW_INCOME_DISCOUNT;
    }

    public void setLOW_INCOME_DISCOUNT(String LOW_INCOME_DISCOUNT) {
        this.LOW_INCOME_DISCOUNT = LOW_INCOME_DISCOUNT;
    }

    public String getBASIC_LIFE_DISCOUNT() {
        return BASIC_LIFE_DISCOUNT;
    }

    public void setBASIC_LIFE_DISCOUNT(String BASIC_LIFE_DISCOUNT) {
        this.BASIC_LIFE_DISCOUNT = BASIC_LIFE_DISCOUNT;
    }

    public String getPATRIOT_DISCOUNT() {
        return PATRIOT_DISCOUNT;
    }

    public void setPATRIOT_DISCOUNT(String PATRIOT_DISCOUNT) {
        this.PATRIOT_DISCOUNT = PATRIOT_DISCOUNT;
    }

    public String getSOCIAL_WELFARE() {
        return SOCIAL_WELFARE;
    }

    public void setSOCIAL_WELFARE(String SOCIAL_WELFARE) {
        this.SOCIAL_WELFARE = SOCIAL_WELFARE;
    }

    public String getPLAN_FARE() {
        return PLAN_FARE;
    }

    public void setPLAN_FARE(String PLAN_FARE) {
        this.PLAN_FARE = PLAN_FARE;
    }

    public String getLOWER_INCOME_DISCOUNT() {
        return LOWER_INCOME_DISCOUNT;
    }

    public void setLOWER_INCOME_DISCOUNT(String LOWER_INCOME_DISCOUNT) {
        this.LOWER_INCOME_DISCOUNT = LOWER_INCOME_DISCOUNT;
    }

    public String getRESERVE_BASIC_FARE() {
        return RESERVE_BASIC_FARE;
    }

    public void setRESERVE_BASIC_FARE(String RESERVE_BASIC_FARE) {
        this.RESERVE_BASIC_FARE = RESERVE_BASIC_FARE;
    }

    public String getBLACKOUT_REWARD() {
        return BLACKOUT_REWARD;
    }

    public void setBLACKOUT_REWARD(String BLACKOUT_REWARD) {
        this.BLACKOUT_REWARD = BLACKOUT_REWARD;
    }

    public String getRW_ELEC_SUPPORT() {
        return RW_ELEC_SUPPORT;
    }

    public void setRW_ELEC_SUPPORT(String RW_ELEC_SUPPORT) {
        this.RW_ELEC_SUPPORT = RW_ELEC_SUPPORT;
    }

    public String getRW_TV_SUPPORT() {
        return RW_TV_SUPPORT;
    }

    public void setRW_TV_SUPPORT(String RW_TV_SUPPORT) {
        this.RW_TV_SUPPORT = RW_TV_SUPPORT;
    }

    public String getEXCESS_FARE() {
        return EXCESS_FARE;
    }

    public void setEXCESS_FARE(String EXCESS_FARE) {
        this.EXCESS_FARE = EXCESS_FARE;
    }

    public String getTRANS_POWER_SUPPORT() {
        return TRANS_POWER_SUPPORT;
    }

    public void setTRANS_POWER_SUPPORT(String TRANS_POWER_SUPPORT) {
        this.TRANS_POWER_SUPPORT = TRANS_POWER_SUPPORT;
    }

    public String getSUMMER_DISCOUNT() {
        return SUMMER_DISCOUNT;
    }

    public void setSUMMER_DISCOUNT(String SUMMER_DISCOUNT) {
        this.SUMMER_DISCOUNT = SUMMER_DISCOUNT;
    }

    public String getBASIC_LIFE_DISCOUNT2() {
        return BASIC_LIFE_DISCOUNT2;
    }

    public void setBASIC_LIFE_DISCOUNT2(String BASIC_LIFE_DISCOUNT2) {
        this.BASIC_LIFE_DISCOUNT2 = BASIC_LIFE_DISCOUNT2;
    }

    public String getNUMBER_OF_LIFE2() {
        return NUMBER_OF_LIFE2;
    }

    public void setNUMBER_OF_LIFE2(String NUMBER_OF_LIFE2) {
        this.NUMBER_OF_LIFE2 = NUMBER_OF_LIFE2;
    }

    public String getNUMBER_OF_LOWER() {
        return NUMBER_OF_LOWER;
    }

    public void setNUMBER_OF_LOWER(String NUMBER_OF_LOWER) {
        this.NUMBER_OF_LOWER = NUMBER_OF_LOWER;
    }

    public String getNUMBER_OF_LOWER2() {
        return NUMBER_OF_LOWER2;
    }

    public void setNUMBER_OF_LOWER2(String NUMBER_OF_LOWER2) {
        this.NUMBER_OF_LOWER2 = NUMBER_OF_LOWER2;
    }

    public String getLOWER_INCOME_DISCOUNT2() {
        return LOWER_INCOME_DISCOUNT2;
    }

    public void setLOWER_INCOME_DISCOUNT2(String LOWER_INCOME_DISCOUNT2) {
        this.LOWER_INCOME_DISCOUNT2 = LOWER_INCOME_DISCOUNT2;
    }

    public String getCURMONIND01() {
        return CURMONIND01;
    }

    public void setCURMONIND01(String CURMONIND01) {
        this.CURMONIND01 = CURMONIND01;
    }

    public String getNUMBER_OF_E_VOUCHER() {
        return NUMBER_OF_E_VOUCHER;
    }

    public void setNUMBER_OF_E_VOUCHER(String NUMBER_OF_E_VOUCHER) {
        this.NUMBER_OF_E_VOUCHER = NUMBER_OF_E_VOUCHER;
    }

    public String getE_VOUCHER_DISCOUNT() {
        return E_VOUCHER_DISCOUNT;
    }

    public void setE_VOUCHER_DISCOUNT(String e_VOUCHER_DISCOUNT) {
        E_VOUCHER_DISCOUNT = e_VOUCHER_DISCOUNT;
    }

    public String getSUMMER_DISCOUNT_7() {
        return SUMMER_DISCOUNT_7;
    }

    public void setSUMMER_DISCOUNT_7(String SUMMER_DISCOUNT_7) {
        this.SUMMER_DISCOUNT_7 = SUMMER_DISCOUNT_7;
    }

    public String getSUMMER_DISCOUNT_8() {
        return SUMMER_DISCOUNT_8;
    }

    public void setSUMMER_DISCOUNT_8(String SUMMER_DISCOUNT_8) {
        this.SUMMER_DISCOUNT_8 = SUMMER_DISCOUNT_8;
    }

    public String getREAL_CURMONIND01() {
        return REAL_CURMONIND01;
    }

    public void setREAL_CURMONIND01(String REAL_CURMONIND01) {
        this.REAL_CURMONIND01 = REAL_CURMONIND01;
    }

    public String getCURMONIND01_TYPE() {
        return CURMONIND01_TYPE;
    }

    public void setCURMONIND01_TYPE(String CURMONIND01_TYPE) {
        this.CURMONIND01_TYPE = CURMONIND01_TYPE;
    }

    public String getMUST_USE_DISCOUNT() {
        return MUST_USE_DISCOUNT;
    }

    public void setMUST_USE_DISCOUNT(String MUST_USE_DISCOUNT) {
        this.MUST_USE_DISCOUNT = MUST_USE_DISCOUNT;
    }

    public String getBABY_DISCOUNT() {
        return BABY_DISCOUNT;
    }

    public void setBABY_DISCOUNT(String BABY_DISCOUNT) {
        this.BABY_DISCOUNT = BABY_DISCOUNT;
    }

    public String getNUMBER_BABY() {
        return NUMBER_BABY;
    }

    public void setNUMBER_BABY(String NUMBER_BABY) {
        this.NUMBER_BABY = NUMBER_BABY;
    }

    public String getCONSTATUS() {
        return CONSTATUS;
    }

    public void setCONSTATUS(String CONSTATUS) {
        this.CONSTATUS = CONSTATUS;
    }

    public String getAUTOPUSH() {
        return AUTOPUSH;
    }

    public void setAUTOPUSH(String AUTOPUSH) {
        this.AUTOPUSH = AUTOPUSH;
    }

    public String getJUL_SUMMER_RETRO() {
        return JUL_SUMMER_RETRO;
    }

    public void setJUL_SUMMER_RETRO(String JUL_SUMMER_RETRO) {
        this.JUL_SUMMER_RETRO = JUL_SUMMER_RETRO;
    }

    public String getAUG_SUMMER_RETRO() {
        return AUG_SUMMER_RETRO;
    }

    public void setAUG_SUMMER_RETRO(String AUG_SUMMER_RETRO) {
        this.AUG_SUMMER_RETRO = AUG_SUMMER_RETRO;
    }

    public String getJUL_WELFARE_RETRO() {
        return JUL_WELFARE_RETRO;
    }

    public void setJUL_WELFARE_RETRO(String JUL_WELFARE_RETRO) {
        this.JUL_WELFARE_RETRO = JUL_WELFARE_RETRO;
    }

    public String getAUG_WELFARE_RETRO() {
        return AUG_WELFARE_RETRO;
    }

    public void setAUG_WELFARE_RETRO(String AUG_WELFARE_RETRO) {
        this.AUG_WELFARE_RETRO = AUG_WELFARE_RETRO;
    }

    public String getJUL_POWER_SAVE() {
        return JUL_POWER_SAVE;
    }

    public void setJUL_POWER_SAVE(String JUL_POWER_SAVE) {
        this.JUL_POWER_SAVE = JUL_POWER_SAVE;
    }

    public String getAUG_POWER_SAVE() {
        return AUG_POWER_SAVE;
    }

    public void setAUG_POWER_SAVE(String AUG_POWER_SAVE) {
        this.AUG_POWER_SAVE = AUG_POWER_SAVE;
    }

    public String getBABY_RETRO() {
        return BABY_RETRO;
    }

    public void setBABY_RETRO(String BABY_RETRO) {
        this.BABY_RETRO = BABY_RETRO;
    }

    public String getULJIN_SUP_FARE() {
        return ULJIN_SUP_FARE;
    }

    public void setULJIN_SUP_FARE(String ULJIN_SUP_FARE) {
        this.ULJIN_SUP_FARE = ULJIN_SUP_FARE;
    }

    public String getBORYUNG_SUP_FARE() {
        return BORYUNG_SUP_FARE;
    }

    public void setBORYUNG_SUP_FARE(String BORYUNG_SUP_FARE) {
        this.BORYUNG_SUP_FARE = BORYUNG_SUP_FARE;
    }

    public String getCLAIM_FARE() {
        return CLAIM_FARE;
    }

    public void setCLAIM_FARE(String CLAIM_FARE) {
        this.CLAIM_FARE = CLAIM_FARE;
    }

    public String getENVIR_DISCOUNT() {
        return ENVIR_DISCOUNT;
    }

    public void setENVIR_DISCOUNT(String ENVIR_DISCOUNT) {
        this.ENVIR_DISCOUNT = ENVIR_DISCOUNT;
    }

    public String getCLIMATE_FARE() {
        return CLIMATE_FARE;
    }

    public void setCLIMATE_FARE(String CLIMATE_FARE) {
        this.CLIMATE_FARE = CLIMATE_FARE;
    }

    public String getFUEL_ADJ_FARE() {
        return FUEL_ADJ_FARE;
    }

    public void setFUEL_ADJ_FARE(String FUEL_ADJ_FARE) {
        this.FUEL_ADJ_FARE = FUEL_ADJ_FARE;
    }

    public String getSOSANG_SUP_FARE() {
        return SOSANG_SUP_FARE;
    }

    public void setSOSANG_SUP_FARE(String SOSANG_SUP_FARE) {
        this.SOSANG_SUP_FARE = SOSANG_SUP_FARE;
    }

    public String getBOKJI_ADD_DISC() {
        return BOKJI_ADD_DISC;
    }

    public void setBOKJI_ADD_DISC(String BOKJI_ADD_DISC) {
        this.BOKJI_ADD_DISC = BOKJI_ADD_DISC;
    }

    @Override
    public String toString() {
        return "InspectionMaster{" +
                "APTCD='" + APTCD + '\'' +
                ", DONGHO='" + DONGHO + '\'' +
                ", BILLYM='" + BILLYM + '\'' +
                ", CUST_NO='" + CUST_NO + '\'' +
                ", HOUSE_NO='" + HOUSE_NO + '\'' +
                ", REGULATION_DAY='" + REGULATION_DAY + '\'' +
                ", TRANS_DATE='" + TRANS_DATE + '\'' +
                ", USAGE_HOUSE='" + USAGE_HOUSE + '\'' +
                ", USAGE_COMMON_A='" + USAGE_COMMON_A + '\'' +
                ", USAGE_COMMON_B='" + USAGE_COMMON_B + '\'' +
                ", PYONG='" + PYONG + '\'' +
                ", PYONG_TYPE='" + PYONG_TYPE + '\'' +
                ", NUMBER_OF_HOUSE='" + NUMBER_OF_HOUSE + '\'' +
                ", NUMBER_OF_HANDICAPPED='" + NUMBER_OF_HANDICAPPED + '\'' +
                ", REAL_USAGE='" + REAL_USAGE + '\'' +
                ", FIRST_FARE='" + FIRST_FARE + '\'' +
                ", USAGE_FARE='" + USAGE_FARE + '\'' +
                ", USAGE_0_FARE='" + USAGE_0_FARE + '\'' +
                ", WELFARE_DISCOUNT='" + WELFARE_DISCOUNT + '\'' +
                ", AUTO_DISCOUNT='" + AUTO_DISCOUNT + '\'' +
                ", INTERNET_DISCOUNT='" + INTERNET_DISCOUNT + '\'' +
                ", ELECTRIC_FARE='" + ELECTRIC_FARE + '\'' +
                ", VAT='" + VAT + '\'' +
                ", ELECTRIC_FUND='" + ELECTRIC_FUND + '\'' +
                ", SUB_TOTAL='" + SUB_TOTAL + '\'' +
                ", TV_FARE='" + TV_FARE + '\'' +
                ", DAN_SU='" + DAN_SU + '\'' +
                ", CREATEDT='" + CREATEDT + '\'' +
                ", RETURNDT='" + RETURNDT + '\'' +
                ", MODIFYDT='" + MODIFYDT + '\'' +
                ", TRANS_STATE='" + TRANS_STATE + '\'' +
                ", DONGHO_STATUS='" + DONGHO_STATUS + '\'' +
                ", NUMBER_OF_LIFE='" + NUMBER_OF_LIFE + '\'' +
                ", NUMBER_OF_MERIT='" + NUMBER_OF_MERIT + '\'' +
                ", NUMBER_OF_FAMILY='" + NUMBER_OF_FAMILY + '\'' +
                ", FAMILY_FARE='" + FAMILY_FARE + '\'' +
                ", SUPPORT_FARE='" + SUPPORT_FARE + '\'' +
                ", TRANS_TYPE='" + TRANS_TYPE + '\'' +
                ", ELECTRIC_FUND_DISCOUNT='" + ELECTRIC_FUND_DISCOUNT + '\'' +
                ", FUEL_FARE='" + FUEL_FARE + '\'' +
                ", MEDICAL_DISCOUNT='" + MEDICAL_DISCOUNT + '\'' +
                ", DISABLED_DISCOUNT='" + DISABLED_DISCOUNT + '\'' +
                ", MERIT_DISCOUNT='" + MERIT_DISCOUNT + '\'' +
                ", LOW_INCOME_DISCOUNT='" + LOW_INCOME_DISCOUNT + '\'' +
                ", BASIC_LIFE_DISCOUNT='" + BASIC_LIFE_DISCOUNT + '\'' +
                ", PATRIOT_DISCOUNT='" + PATRIOT_DISCOUNT + '\'' +
                ", SOCIAL_WELFARE='" + SOCIAL_WELFARE + '\'' +
                ", PLAN_FARE='" + PLAN_FARE + '\'' +
                ", LOWER_INCOME_DISCOUNT='" + LOWER_INCOME_DISCOUNT + '\'' +
                ", RESERVE_BASIC_FARE='" + RESERVE_BASIC_FARE + '\'' +
                ", BLACKOUT_REWARD='" + BLACKOUT_REWARD + '\'' +
                ", RW_ELEC_SUPPORT='" + RW_ELEC_SUPPORT + '\'' +
                ", RW_TV_SUPPORT='" + RW_TV_SUPPORT + '\'' +
                ", EXCESS_FARE='" + EXCESS_FARE + '\'' +
                ", TRANS_POWER_SUPPORT='" + TRANS_POWER_SUPPORT + '\'' +
                ", SUMMER_DISCOUNT='" + SUMMER_DISCOUNT + '\'' +
                ", BASIC_LIFE_DISCOUNT2='" + BASIC_LIFE_DISCOUNT2 + '\'' +
                ", NUMBER_OF_LIFE2='" + NUMBER_OF_LIFE2 + '\'' +
                ", NUMBER_OF_LOWER='" + NUMBER_OF_LOWER + '\'' +
                ", NUMBER_OF_LOWER2='" + NUMBER_OF_LOWER2 + '\'' +
                ", LOWER_INCOME_DISCOUNT2='" + LOWER_INCOME_DISCOUNT2 + '\'' +
                ", CURMONIND01='" + CURMONIND01 + '\'' +
                ", NUMBER_OF_E_VOUCHER='" + NUMBER_OF_E_VOUCHER + '\'' +
                ", E_VOUCHER_DISCOUNT='" + E_VOUCHER_DISCOUNT + '\'' +
                ", SUMMER_DISCOUNT_7='" + SUMMER_DISCOUNT_7 + '\'' +
                ", SUMMER_DISCOUNT_8='" + SUMMER_DISCOUNT_8 + '\'' +
                ", REAL_CURMONIND01='" + REAL_CURMONIND01 + '\'' +
                ", CURMONIND01_TYPE='" + CURMONIND01_TYPE + '\'' +
                ", MUST_USE_DISCOUNT='" + MUST_USE_DISCOUNT + '\'' +
                ", BABY_DISCOUNT='" + BABY_DISCOUNT + '\'' +
                ", NUMBER_BABY='" + NUMBER_BABY + '\'' +
                ", CONSTATUS='" + CONSTATUS + '\'' +
                ", AUTOPUSH='" + AUTOPUSH + '\'' +
                ", JUL_SUMMER_RETRO='" + JUL_SUMMER_RETRO + '\'' +
                ", AUG_SUMMER_RETRO='" + AUG_SUMMER_RETRO + '\'' +
                ", JUL_WELFARE_RETRO='" + JUL_WELFARE_RETRO + '\'' +
                ", AUG_WELFARE_RETRO='" + AUG_WELFARE_RETRO + '\'' +
                ", JUL_POWER_SAVE='" + JUL_POWER_SAVE + '\'' +
                ", AUG_POWER_SAVE='" + AUG_POWER_SAVE + '\'' +
                ", BABY_RETRO='" + BABY_RETRO + '\'' +
                ", ULJIN_SUP_FARE='" + ULJIN_SUP_FARE + '\'' +
                ", BORYUNG_SUP_FARE='" + BORYUNG_SUP_FARE + '\'' +
                ", CLAIM_FARE='" + CLAIM_FARE + '\'' +
                ", ENVIR_DISCOUNT='" + ENVIR_DISCOUNT + '\'' +
                ", CLIMATE_FARE='" + CLIMATE_FARE + '\'' +
                ", FUEL_ADJ_FARE='" + FUEL_ADJ_FARE + '\'' +
                ", SOSANG_SUP_FARE='" + SOSANG_SUP_FARE + '\'' +
                ", BOKJI_ADD_DISC='" + BOKJI_ADD_DISC + '\'' +
                '}';
    }
}
