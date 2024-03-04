package it.unimib.easydefence.model.virustotal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LastAnalysisResults {
    @JsonProperty("Bkav")
    BaseObject bkav;
    @JsonProperty("Lionic")
    BaseObject lionic;
    @JsonProperty("tehtris")
    BaseObject tehtris;
    @JsonProperty("ClamAV")
    BaseObject clamAV;
    @JsonProperty("FireEye")
    BaseObject fireEye;
    @JsonProperty("CAT-QuickHeal")
    BaseObject catQuickHeal;
    @JsonProperty("Skyhigh")
    BaseObject skyhigh;
    @JsonProperty("McAfee")
    BaseObject mcAfee;
    @JsonProperty("Malwarebytes")
    BaseObject malwarebytes;
    @JsonProperty("Zillya")
    BaseObject zillya;
    @JsonProperty("Sangfor")
    BaseObject sangfor;
    @JsonProperty("Trustlook")
    BaseObject trustlook;
    @JsonProperty("Alibaba")
    BaseObject alibaba;
    @JsonProperty("K7GW")
    BaseObject k7GW;
    @JsonProperty("K7AntiVirus")
    BaseObject k7AntiVirus;
    @JsonProperty("Arcabit")
    BaseObject arcabit;
    @JsonProperty("BitDefenderTheta")
    BaseObject bitDefenderTheta;
    @JsonProperty("VirIT")
    BaseObject virIT;
    @JsonProperty("SymantecMobileInsight")
    BaseObject symantecMobileInsight;
    @JsonProperty("Symantec")
    BaseObject symantec;
    @JsonProperty("Elastic")
    BaseObject elastic;
    @JsonProperty("ESET-NOD32")
    BaseObject esetNOD32;
    @JsonProperty("APEX")
    BaseObject aPEX;
    @JsonProperty("TrendMicro-HouseCall")
    BaseObject trendMicroHouseCall;
    @JsonProperty("Avast")
    BaseObject avast;
    @JsonProperty("Cynet")
    BaseObject cynet;
    @JsonProperty("Kaspersky")
    BaseObject kaspersky;
    @JsonProperty("BitDefender")
    BaseObject bitDefender;
    @JsonProperty("NANO-Antivirus")
    BaseObject nanoAntivirus;
    @JsonProperty("SUPERAntiSpyware")
    BaseObject sUPERAntiSpyware;
    @JsonProperty("MicroWorld-eScan")
    BaseObject microWorldEScan;
    @JsonProperty("Tencent")
    BaseObject tencent;
    @JsonProperty("Emsisoft")
    BaseObject emsisoft;
    @JsonProperty("Baidu")
    BaseObject baidu;
    @JsonProperty("F-Secure")
    BaseObject fSecure;
    @JsonProperty("DrWeb")
    BaseObject drWeb;
    @JsonProperty("VIPRE")
    BaseObject vIPRE;
    @JsonProperty("TrendMicro")
    BaseObject trendMicro;
    @JsonProperty("SentinelOne")
    BaseObject sentinelOne;
    @JsonProperty("Trapmine")
    BaseObject trapmine;
    @JsonProperty("CMC")
    BaseObject cMC;
    @JsonProperty("Sophos")
    BaseObject sophos;
    @JsonProperty("Paloalto")
    BaseObject paloalto;
    @JsonProperty("Avast-Mobile")
    BaseObject avastMobile;
    @JsonProperty("Jiangmin")
    BaseObject jiangmin;
    @JsonProperty("Webroot")
    BaseObject webroot;
    @JsonProperty("Varist")
    BaseObject varist;
    @JsonProperty("Avira")
    BaseObject avira;
    @JsonProperty("MAX")
    BaseObject mAX;
    @JsonProperty("Antiy-AVL")
    BaseObject antiyAVL;
    @JsonProperty("Kingsoft")
    BaseObject kingsoft;
    @JsonProperty("Gridinsoft")
    BaseObject gridinsoft;
    @JsonProperty("Xcitium")
    BaseObject xcitium;
    @JsonProperty("Microsoft")
    BaseObject microsoft;
    @JsonProperty("ViRobot")
    BaseObject viRobot;
    @JsonProperty("ZoneAlarm")
    BaseObject zoneAlarm;
    @JsonProperty("GData")
    BaseObject gData;
    @JsonProperty("Google")
    BaseObject google;
    @JsonProperty("BitDefenderFalx")
    BaseObject bitDefenderFalx;
    @JsonProperty("AhnLab-V3")
    BaseObject ahnLabV3;
    @JsonProperty("Acronis")
    BaseObject acronis;
    @JsonProperty("VBA32")
    BaseObject vBA32;
    @JsonProperty("ALYac")
    BaseObject aLYac;
    @JsonProperty("TACHYON")
    BaseObject tACHYON;
    @JsonProperty("DeepInstinct")
    BaseObject deepInstinct;
    @JsonProperty("Cylance")
    BaseObject cylance;
    @JsonProperty("Zoner")
    BaseObject zoner;
    @JsonProperty("Rising")
    BaseObject rising;
    @JsonProperty("Yandex")
    BaseObject yandex;
    @JsonProperty("Ikarus")
    BaseObject ikarus;
    @JsonProperty("MaxSecure")
    BaseObject maxSecure;
    @JsonProperty("Fortinet")
    BaseObject fortinet;
    @JsonProperty("AVG")
    BaseObject aVG;
    @JsonProperty("Cybereason")
    BaseObject cybereason;
    @JsonProperty("Panda")
    BaseObject panda;
    @JsonProperty("CrowdStrike")
    BaseObject crowdStrike;
}
