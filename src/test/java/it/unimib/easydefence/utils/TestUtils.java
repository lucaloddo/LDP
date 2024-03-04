package it.unimib.easydefence.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.nist.response.CveResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import it.unimib.easydefence.model.rapidapipassword.response.RapidApiPasswordResponse;
import it.unimib.easydefence.model.rapidapiwhois.Response;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import it.unimib.easydefence.model.virustotal.response.DataResp;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import org.springframework.mock.web.MockMultipartFile;

public class TestUtils {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static final String TEST_DETECT_USER_AGENT = "TEST_DETECT_USER_AGENT";
    public static final Integer TEST_LENGTH_PASSWORD = 5;
    public static final String TEST_RANDOM_PASSWORD = "TEST_RANDOM_PASSWORD";
    public static final String TEST_DEVICE = "TEST_DEVICE";
    public static final String TEST_OS = "Windows 10";
    public static final String TEST_PHONE_NUMBER = "3403827518";
    public static final String TEST_PREFIX = "+39";
    public static final String TEST_HASH_FILE_STRING = "8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85";
    public static final String TEST_DOMAIN = "TEST_DOMAIN";
    public static String mockDetectResponse = "{\n" +
            "    \"ua\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36\",\n" +
            "    \"type\": \"browser\",\n" +
            "    \"brand\": null,\n" +
            "    \"name\": null,\n" +
            "    \"url\": \"https://about.google/\",\n" +
            "    \"os\": {\n" +
            "        \"name\": \"Windows 10\",\n" +
            "        \"code\": \"windows_10\",\n" +
            "        \"url\": \"https://en.wikipedia.org/wiki/Windows_10\",\n" +
            "        \"family\": \"Windows\",\n" +
            "        \"family_code\": \"windows\",\n" +
            "        \"family_vendor\": \"Microsoft Corporation.\",\n" +
            "        \"icon\": \"https://assets.userstack.com/icon/os/windows10.png\",\n" +
            "        \"icon_large\": \"https://assets.userstack.com/icon/os/windows10_big.png\"\n" +
            "    },\n" +
            "    \"device\": {\n" +
            "        \"is_mobile_device\": false,\n" +
            "        \"type\": \"desktop\",\n" +
            "        \"brand\": null,\n" +
            "        \"brand_code\": null,\n" +
            "        \"brand_url\": null,\n" +
            "        \"name\": null\n" +
            "    },\n" +
            "    \"browser\": {\n" +
            "        \"name\": \"Chrome\",\n" +
            "        \"version\": \"118.0.0.0\",\n" +
            "        \"version_major\": \"118\",\n" +
            "        \"engine\": \"WebKit/Blink\"\n" +
            "    },\n" +
            "    \"crawler\": {\n" +
            "        \"is_crawler\": false,\n" +
            "        \"category\": null,\n" +
            "        \"last_seen\": null\n" +
            "    }\n" +
            "}";

    public static String mockCveResponse = "{\n" +
            "    \"resultsPerPage\": 20,\n" +
            "    \"startIndex\": 0,\n" +
            "    \"totalResults\": 2300,\n" +
            "    \"format\": \"NVD_CVE\",\n" +
            "    \"version\": \"2.0\",\n" +
            "    \"timestamp\": \"2023-10-23T19:55:12.717\",\n" +
            "    \"vulnerabilities\": [\n" +
            "        {\n" +
            "            \"cve\": {\n" +
            "                \"id\": \"CVE-1999-1133\",\n" +
            "                \"sourceIdentifier\": \"cve@mitre.org\",\n" +
            "                \"published\": \"1997-09-01T04:00:00.000\",\n" +
            "                \"lastModified\": \"2017-12-19T02:29:02.533\",\n" +
            "                \"vulnStatus\": \"Modified\",\n" +
            "                \"descriptions\": [\n" +
            "                    {\n" +
            "                        \"lang\": \"en\",\n" +
            "                        \"value\": \"HP-UX 9.x and 10.x running X windows may allow local attackers to gain privileges via (1) vuefile, (2) vuepad, (3) dtfile, or (4) dtpad, which do not authenticate users.\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"metrics\": {\n" +
            "                    \"cvssMetricV31\": null,\n" +
            "                    \"cvssMetricV2\": [\n" +
            "                        {\n" +
            "                            \"source\": \"nvd@nist.gov\",\n" +
            "                            \"type\": \"Primary\",\n" +
            "                            \"cvssData\": {\n" +
            "                                \"version\": \"2.0\",\n" +
            "                                \"vectorString\": \"AV:L/AC:L/Au:N/C:P/I:P/A:P\",\n" +
            "                                \"accessVector\": \"LOCAL\",\n" +
            "                                \"accessComplexity\": \"LOW\",\n" +
            "                                \"authentication\": \"NONE\",\n" +
            "                                \"confidentialityImpact\": \"PARTIAL\",\n" +
            "                                \"integrityImpact\": \"PARTIAL\",\n" +
            "                                \"availabilityImpact\": \"PARTIAL\",\n" +
            "                                \"baseScore\": 4.6\n" +
            "                            },\n" +
            "                            \"baseSeverity\": \"MEDIUM\",\n" +
            "                            \"exploitabilityScore\": 3.9,\n" +
            "                            \"impactScore\": 6.4,\n" +
            "                            \"acInsufInfo\": false,\n" +
            "                            \"obtainAllPrivilege\": false,\n" +
            "                            \"obtainUserPrivilege\": false,\n" +
            "                            \"obtainOtherPrivilege\": true,\n" +
            "                            \"userInteractionRequired\": false\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                \"weaknesses\": [\n" +
            "                    {\n" +
            "                        \"source\": \"nvd@nist.gov\",\n" +
            "                        \"type\": \"Primary\",\n" +
            "                        \"description\": [\n" +
            "                            {\n" +
            "                                \"lang\": \"en\",\n" +
            "                                \"value\": \"NVD-CWE-Other\"\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"configurations\": [\n" +
            "                    {\n" +
            "                        \"nodes\": [\n" +
            "                            {\n" +
            "                                \"operator\": \"OR\",\n" +
            "                                \"negate\": false,\n" +
            "                                \"cpeMatch\": [\n" +
            "                                    {\n" +
            "                                        \"vulnerable\": true,\n" +
            "                                        \"criteria\": \"cpe:2.3:o:hp:hp-ux:9:*:*:*:*:*:*:*\",\n" +
            "                                        \"matchCriteriaId\": \"5E54D276-792B-40D2-B39B-5050028DE988\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"vulnerable\": true,\n" +
            "                                        \"criteria\": \"cpe:2.3:o:hp:hp-ux:10:*:*:*:*:*:*:*\",\n" +
            "                                        \"matchCriteriaId\": \"CC96D014-7CE2-4F61-BBAF-507829C542EA\"\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ]\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"references\": [\n" +
            "                    {\n" +
            "                        \"url\": \"http://marc.info/?l=bugtraq&m=87602880019776&w=2\",\n" +
            "                        \"source\": \"cve@mitre.org\",\n" +
            "                        \"tags\": null\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"url\": \"https://exchange.xforce.ibmcloud.com/vulnerabilities/499\",\n" +
            "                        \"source\": \"cve@mitre.org\",\n" +
            "                        \"tags\": null\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    public static String mockRapidApiPasswordResponse = "{\n" +
            "    \"password\": \"[*WG%&X[F>yAf\"\n" +
            "}";
    public static String mockPhoneResponse = "{\n" +
            "    \"is_valid\": true,\n" +
            "    \"is_formatted_properly\": true,\n" +
            "    \"country\": \"\",\n" +
            "    \"location\": \"\",\n" +
            "    \"timezones\": [\n" +
            "        \"Europe/Rome\",\n" +
            "        \"Europe/Vatican\"\n" +
            "    ],\n" +
            "    \"format_national\": \"340 382 7518\",\n" +
            "    \"format_international\": \"+39 340 382 7518\",\n" +
            "    \"format_e164\": \"+393403827518\",\n" +
            "    \"country_code\": 39\n" +
            "}";
    public static String mockRapidApiResponse = "{\n" +
            "    \"dialcode_e164\": \"+16502530000\",\n" +
            "    \"timezone\": \"America/Los_Angeles\",\n" +
            "    \"timezone_short\": \"PDT\",\n" +
            "    \"timezone_utc_offset\": \"-08:00\",\n" +
            "    \"region\": \"West\",\n" +
            "    \"sub_region\": \"Pacific\",\n" +
            "    \"administrative_area_level_3\": null,\n" +
            "    \"administrative_area_level_2\": \"SanFranciscoCounty\",\n" +
            "    \"administrative_area_level_1\": \"California\",\n" +
            "    \"administrative_area_level_1_short\": \"CA\",\n" +
            "    \"locality\": \"SanFrancisco\",\n" +
            "    \"sublocality_level_1\": null,\n" +
            "    \"point_of_interest\": null,\n" +
            "    \"neighborhood\": null,\n" +
            "    \"clli\": \"SNFCCASY\",\n" +
            "    \"switch_assignment_date\": \"2005-12-28T00:00:00.000Z\",\n" +
            "    \"country\": \"UnitedStates\",\n" +
            "    \"country_short\": \"US\",\n" +
            "    \"postal_code\": \"94108\",\n" +
            "    \"operating_company_name\": \"Twilio\",\n" +
            "    \"operating_company_type\": \"clec\",\n" +
            "    \"lata\": \"722\",\n" +
            "    \"ocn\": \"8826\",\n" +
            "    \"line_type\": \"voip\",\n" +
            "    \"location_routing_number\": \"+14159686199\",\n" +
            "    \"ported\": true,\n" +
            "    \"risk_rating\": \"highly_likely\",\n" +
            "    \"risk_level\": 94,\n" +
            "    \"ported_date\": null,\n" +
            "    \"dialcode_invalid\": false,\n" +
            "    \"dialcode_impossible\": false,\n" +
            "    \"notes\": \"Emailusatsupport@icehook.comwithanyinquiries.\"\n" +
            "}";

    public static String mockRapidApiHash = "{\n" +
            "    \"hashHexString\": \"8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\",\n" +
            "    \"hashBase64String\": \"hznHbmgfkAkjuQDJ3w73XPQh05yrtUZQxLmtGbanbYU=\",\n" +
            "    \"result\": \"Success\"\n" +
            "}";

    public static String mockFileResponse = "{\n" +
            "    \"data\": {\n" +
            "        \"attributes\": {\n" +
            "            \"type_description\": \"ZIP\",\n" +
            "            \"tlsh\": \"TNULL\",\n" +
            "            \"type_tags\": [\n" +
            "                \"compressed\",\n" +
            "                \"zip\"\n" +
            "            ],\n" +
            "            \"nsrl_info\": {\n" +
            "                \"products\": [\n" +
            "                    \"Master Hacker Internet Terrorism (Core Publishing Inc.)\",\n" +
            "                    \"Read Rabbits Math Ages 6-9 (Smart Saver)\",\n" +
            "                    \"Neverwinter Nights Gold (Atari)\",\n" +
            "                    \"Limited Edition Print Workshop 2004 (ValuSoft)\",\n" +
            "                    \"Crysis (Electronic Arts Inc.)\"\n" +
            "                ],\n" +
            "                \"filenames\": [\n" +
            "                    \"WINDOWS DIALUP.ZIP\",\n" +
            "                    \"kemsetup.ZIP\",\n" +
            "                    \"Data_Linux.zip\",\n" +
            "                    \"2003.zip\",\n" +
            "                    \"_6A271FB199E041FC82F4D282E68B01D6\"\n" +
            "                ]\n" +
            "            },\n" +
            "            \"names\": [\n" +
            "                \"logArchive_2023-12-11_13-32-23.zip\",\n" +
            "                \"temp.zip\",\n" +
            "                \"zipnew.dat\",\n" +
            "                \"ac3plug.zip\",\n" +
            "                \"infographics_for_drones.zip\",\n" +
            "                \"My New Album.zip\",\n" +
            "                \"HxDSetup.zip\",\n" +
            "                \"$R1XROXL.zip\",\n" +
            "                \"Cookie.Clicker.v2.052.zip\",\n" +
            "                \"config.zip\",\n" +
            "                \"visualboyadvance-m-Win-x86_64.zip\",\n" +
            "                \"se_crashdump_subzip_7824_7828_5322265.zip\",\n" +
            "                \"717fdb45-f9ae-48b1-9f1e-ed628cd87dd4.tmp\",\n" +
            "                \"Luna-Logged-user.zip\",\n" +
            "                \"oaofX.zip\",\n" +
            "                \"cs16kurv2017_oyunyoneticisi.zip\",\n" +
            "                \"Browser data.zip\",\n" +
            "                \"translation.zip (copy)\",\n" +
            "                \"3e772937-a1b5-4e5c-9dcd-136e350bf42b.tmp\",\n" +
            "                \"1cc09979-7c0a-43b6-9ee9-079991d1ff2d.tmp\",\n" +
            "                \"FierroLoader.zip\",\n" +
            "                \"Lilydale VIC 3140 OC No. 816796 PDF.zip\",\n" +
            "                \"FierroLoader (1).zip\",\n" +
            "                \"d7dbe547-6ce5-45ea-b793-2524e0d8eb46.tmp\",\n" +
            "                \"NeuShield-DBGINFO-226546-20231211-063940313.zip\",\n" +
            "                \"kgg.zip\",\n" +
            "                \"temp.zip~RF1c290a8.TMP\",\n" +
            "                \"temp.zip~RF11e13e4.TMP\",\n" +
            "                \"da31574c-86cd-46b1-9a72-87847c1748ff.tmp\",\n" +
            "                \"rusifikator-dlya-dyi_EV14ShrZ9A.zip\",\n" +
            "                \"WindowsCloudClean_1.0.42.5976bbd57b.zip (copy)\",\n" +
            "                \"logArchive_2023-12-11_03-49-04.zip\",\n" +
            "                \"logArchive_2023-12-11_04-23-07.zip\",\n" +
            "                \"_FRAMEWORK.7z\",\n" +
            "                \"logArchive_2023-12-11_03-21-13.zip\",\n" +
            "                \"071226bb-179f-490c-8ace-e403bfdfd636.tmp\",\n" +
            "                \"2c8212ab-91ac-4f92-b14c-3d56cbd134bb.tmp\",\n" +
            "                \"9d996c06-4719-4c17-8cf2-2e151ba4ccc3.tmp\",\n" +
            "                \"logArchive_2023-12-11_02-19-17.zip\",\n" +
            "                \"a18579cd-caee-415d-b3c2-1acc111b0fcf.tmp\",\n" +
            "                \"empty.zip (copy)\",\n" +
            "                \"temp.zip~RFc2640f.TMP\",\n" +
            "                \"temp.zip~RF11ea324.TMP\",\n" +
            "                \"7d3991c8-4af9-4eff-8a27-6cc45bfd9b39.tmp\",\n" +
            "                \"temp.zip~RF20dbceb.TMP\",\n" +
            "                \"CMLiteV4Installer.zip\",\n" +
            "                \"temp.zip~RFe2c780.TMP\",\n" +
            "                \"modest-menu_v0.9.10_[kiddionsmodmenu.com]_.zip\",\n" +
            "                \"1dc8cd59-eb86-4c64-ac22-c477131c2e7a.tmp\",\n" +
            "                \"5ed09f36-c667-4dbb-aa80-0665e44544f6.tmp\",\n" +
            "                \"temp.zip~RF307a3e.TMP\",\n" +
            "                \"temp.zip~RF18c913b.TMP\",\n" +
            "                \"temp.zip~RF21eb160.TMP\",\n" +
            "                \"temp.zip~RFe725fa.TMP\",\n" +
            "                \"temp.zip~RF19e848b.TMP\",\n" +
            "                \"a8f5cc94-6e72-4fa6-8b85-1eca31dbf54a.tmp\",\n" +
            "                \"50bbfc81-3820-467d-8c5d-0b4b35e5f2de.tmp\",\n" +
            "                \"temp.zip~RF432f5b.TMP\",\n" +
            "                \"Roblox%20Script%202023.zip%29.zip\",\n" +
            "                \"output.222727695.txt\",\n" +
            "                \"GW1OB.zip\",\n" +
            "                \"winwlogs.zip\",\n" +
            "                \"5198cc1c-e39e-420a-a751-4733e2afb304.tmp\",\n" +
            "                \"HatchfulExport-All.zip\",\n" +
            "                \"036efbf9-c592-441d-a5e7-445562c863d7.tmp\",\n" +
            "                \"MSI-Center.zip\",\n" +
            "                \"MSIAfterburnerSetup.zip\",\n" +
            "                \"350658e9-a61c-43ca-838c-d2b7e1679726.tmp\",\n" +
            "                \"wallets.zip\",\n" +
            "                \"Zup! 6.zip\",\n" +
            "                \"8b6a7fe1-1973-488f-baf5-5f6affdf56bd.tmp\",\n" +
            "                \"1dc712de-47e7-4eb4-87c8-ae62332c75e0.tmp\",\n" +
            "                \"429e3246-e233-4a57-917f-979b478a426b.tmp\",\n" +
            "                \"temp.zip~RF1b09217.TMP\",\n" +
            "                \"d802650d-896d-4bc6-8b59-bd36a79c2256.tmp\",\n" +
            "                \"1e9d534f-4862-46f1-bc4e-1b5c832ebc03.tmp\",\n" +
            "                \"translation.zip\",\n" +
            "                \"56ccbf43-d002-4644-928c-aa9cc043e69a.tmp\",\n" +
            "                \"Paint the Town Red Free Download (v1.3.4).zip\",\n" +
            "                \"logArchive_2023-12-10_11-40-35.zip\",\n" +
            "                \"Wfw4T.zip\",\n" +
            "                \"empty-0.1.jar\",\n" +
            "                \"logArchive_2023-12-10_11-05-08.zip\",\n" +
            "                \"logArchive_2023-12-10_11-26-32.zip\",\n" +
            "                \"logArchive_2023-12-10_10-24-23.zip\",\n" +
            "                \"browser.zip\",\n" +
            "                \"2538b754-d80a-41dc-964a-475b0c124d1e.tmp\",\n" +
            "                \"user.zip\",\n" +
            "                \"logArchive_2023-12-10_09-10-35.zip\",\n" +
            "                \"logArchive_2023-12-10_09-33-41.zip\"\n" +
            "            ],\n" +
            "            \"last_modification_date\": 1702326024,\n" +
            "            \"type_tag\": \"zip\",\n" +
            "            \"times_submitted\": 235497,\n" +
            "            \"total_votes\": {\n" +
            "                \"harmless\": 680,\n" +
            "                \"malicious\": 995\n" +
            "            },\n" +
            "            \"size\": 22,\n" +
            "            \"type_extension\": \"zip\",\n" +
            "            \"last_submission_date\": 1702324788,\n" +
            "            \"known_distributors\": {\n" +
            "                \"filenames\": [\n" +
            "                    \"SpeechBr.pak\",\n" +
            "                    \"New Text Document.zip\",\n" +
            "                    \"lprn_spotlightstory_015.zip\",\n" +
            "                    \"MacmillanEducationAlturaDev-win32-x64-1.0.0.728.exe.zip\",\n" +
            "                    \"DDR_Asphalt_variety.zip\"\n" +
            "                ],\n" +
            "                \"products\": [\n" +
            "                    \"Dying Light\",\n" +
            "                    \"OMSI 2: Steam Edition\"\n" +
            "                ],\n" +
            "                \"distributors\": [\n" +
            "                    \"Microsoft\",\n" +
            "                    \"MR-Software GbR\",\n" +
            "                    \"Google\"\n" +
            "                ],\n" +
            "                \"links\": [\n" +
            "                    \"https://dl.google.com/dl/spotlight/test/lprn_spotlightstory/9/lprn_spotlightstory_015.zip\"\n" +
            "                ],\n" +
            "                \"data_sources\": [\n" +
            "                    \"Microsoft Corporation\",\n" +
            "                    \"National Software Reference Library (NSRL)\",\n" +
            "                    \"Google\"\n" +
            "                ]\n" +
            "            },\n" +
            "            \"last_analysis_results\": {\n" +
            "                \"Bkav\": {\n" +
            "                    \"category\": \"failure\",\n" +
            "                    \"engine_name\": \"Bkav\",\n" +
            "                    \"engine_version\": \"2.0.0.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"Lionic\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Lionic\",\n" +
            "                    \"engine_version\": \"7.5\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"tehtris\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"tehtris\",\n" +
            "                    \"engine_version\": null,\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"ClamAV\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"ClamAV\",\n" +
            "                    \"engine_version\": \"1.2.1.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"FireEye\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"FireEye\",\n" +
            "                    \"engine_version\": \"35.24.1.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"CAT-QuickHeal\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"CAT-QuickHeal\",\n" +
            "                    \"engine_version\": \"22.00\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"Skyhigh\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Skyhigh\",\n" +
            "                    \"engine_version\": \"v2021.2.0+4045\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"McAfee\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"McAfee\",\n" +
            "                    \"engine_version\": \"6.0.6.653\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Malwarebytes\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Malwarebytes\",\n" +
            "                    \"engine_version\": \"4.5.5.54\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Zillya\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Zillya\",\n" +
            "                    \"engine_version\": \"2.0.0.5010\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231208\"\n" +
            "                },\n" +
            "                \"Sangfor\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Sangfor\",\n" +
            "                    \"engine_version\": \"2.23.0.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231122\"\n" +
            "                },\n" +
            "                \"Trustlook\": {\n" +
            "                    \"category\": \"failure\",\n" +
            "                    \"engine_name\": \"Trustlook\",\n" +
            "                    \"engine_version\": \"1.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Alibaba\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Alibaba\",\n" +
            "                    \"engine_version\": \"0.3.0.5\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20190527\"\n" +
            "                },\n" +
            "                \"K7GW\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"K7GW\",\n" +
            "                    \"engine_version\": \"12.130.50390\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231204\"\n" +
            "                },\n" +
            "                \"K7AntiVirus\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"K7AntiVirus\",\n" +
            "                    \"engine_version\": \"12.130.50390\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231204\"\n" +
            "                },\n" +
            "                \"Arcabit\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Arcabit\",\n" +
            "                    \"engine_version\": \"2022.0.0.18\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"BitDefenderTheta\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"BitDefenderTheta\",\n" +
            "                    \"engine_version\": \"7.2.37796.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231127\"\n" +
            "                },\n" +
            "                \"VirIT\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"VirIT\",\n" +
            "                    \"engine_version\": \"9.5.595\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231207\"\n" +
            "                },\n" +
            "                \"SymantecMobileInsight\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"SymantecMobileInsight\",\n" +
            "                    \"engine_version\": \"2.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20230119\"\n" +
            "                },\n" +
            "                \"Symantec\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Symantec\",\n" +
            "                    \"engine_version\": \"1.21.0.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"Elastic\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Elastic\",\n" +
            "                    \"engine_version\": \"4.0.121\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231208\"\n" +
            "                },\n" +
            "                \"ESET-NOD32\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"ESET-NOD32\",\n" +
            "                    \"engine_version\": \"28381\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"APEX\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"APEX\",\n" +
            "                    \"engine_version\": \"6.478\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231128\"\n" +
            "                },\n" +
            "                \"TrendMicro-HouseCall\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"TrendMicro-HouseCall\",\n" +
            "                    \"engine_version\": \"10.0.0.1040\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Avast\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Avast\",\n" +
            "                    \"engine_version\": \"23.9.8494.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Cynet\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Cynet\",\n" +
            "                    \"engine_version\": \"4.0.0.28\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Kaspersky\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Kaspersky\",\n" +
            "                    \"engine_version\": \"22.0.1.28\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"BitDefender\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"BitDefender\",\n" +
            "                    \"engine_version\": \"7.2\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"NANO-Antivirus\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"NANO-Antivirus\",\n" +
            "                    \"engine_version\": \"1.0.146.25796\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"SUPERAntiSpyware\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"SUPERAntiSpyware\",\n" +
            "                    \"engine_version\": \"5.6.0.1032\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"MicroWorld-eScan\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"MicroWorld-eScan\",\n" +
            "                    \"engine_version\": \"14.0.409.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Tencent\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Tencent\",\n" +
            "                    \"engine_version\": \"1.0.0.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Emsisoft\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Emsisoft\",\n" +
            "                    \"engine_version\": \"2022.6.0.32461\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Baidu\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Baidu\",\n" +
            "                    \"engine_version\": \"1.0.0.2\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20190318\"\n" +
            "                },\n" +
            "                \"F-Secure\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"F-Secure\",\n" +
            "                    \"engine_version\": \"18.10.1547.307\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"DrWeb\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"DrWeb\",\n" +
            "                    \"engine_version\": \"7.0.61.8090\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"VIPRE\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"VIPRE\",\n" +
            "                    \"engine_version\": \"6.0.0.35\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"TrendMicro\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"TrendMicro\",\n" +
            "                    \"engine_version\": \"11.0.0.1006\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"SentinelOne\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"SentinelOne\",\n" +
            "                    \"engine_version\": \"23.4.2.3\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231119\"\n" +
            "                },\n" +
            "                \"Trapmine\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Trapmine\",\n" +
            "                    \"engine_version\": \"4.0.14.97\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231106\"\n" +
            "                },\n" +
            "                \"CMC\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"CMC\",\n" +
            "                    \"engine_version\": \"2.4.2022.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20230822\"\n" +
            "                },\n" +
            "                \"Sophos\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Sophos\",\n" +
            "                    \"engine_version\": \"2.4.3.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Paloalto\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Paloalto\",\n" +
            "                    \"engine_version\": \"0.9.0.1003\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Avast-Mobile\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Avast-Mobile\",\n" +
            "                    \"engine_version\": \"231210-02\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"Jiangmin\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Jiangmin\",\n" +
            "                    \"engine_version\": \"16.0.100\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"Webroot\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Webroot\",\n" +
            "                    \"engine_version\": \"1.0.0.403\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Varist\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Varist\",\n" +
            "                    \"engine_version\": \"6.5.1.2\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Avira\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Avira\",\n" +
            "                    \"engine_version\": \"8.3.3.16\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"MAX\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"MAX\",\n" +
            "                    \"engine_version\": \"2023.1.4.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Antiy-AVL\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Antiy-AVL\",\n" +
            "                    \"engine_version\": \"3.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Kingsoft\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Kingsoft\",\n" +
            "                    \"engine_version\": \"None\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20230906\"\n" +
            "                },\n" +
            "                \"Gridinsoft\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Gridinsoft\",\n" +
            "                    \"engine_version\": \"1.0.151.174\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Xcitium\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Xcitium\",\n" +
            "                    \"engine_version\": \"36251\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Microsoft\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Microsoft\",\n" +
            "                    \"engine_version\": \"1.1.23110.2\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"ViRobot\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"ViRobot\",\n" +
            "                    \"engine_version\": \"2014.3.20.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"ZoneAlarm\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"ZoneAlarm\",\n" +
            "                    \"engine_version\": \"1.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"GData\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"GData\",\n" +
            "                    \"engine_version\": \"A:25.36959B:27.34167\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Google\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Google\",\n" +
            "                    \"engine_version\": \"1702283432\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"BitDefenderFalx\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"BitDefenderFalx\",\n" +
            "                    \"engine_version\": \"2.0.936\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231121\"\n" +
            "                },\n" +
            "                \"AhnLab-V3\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"AhnLab-V3\",\n" +
            "                    \"engine_version\": \"3.25.0.10459\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Acronis\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Acronis\",\n" +
            "                    \"engine_version\": \"1.2.0.121\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20230828\"\n" +
            "                },\n" +
            "                \"VBA32\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"VBA32\",\n" +
            "                    \"engine_version\": \"5.0.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"ALYac\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"ALYac\",\n" +
            "                    \"engine_version\": \"1.1.3.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"TACHYON\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"TACHYON\",\n" +
            "                    \"engine_version\": \"2023-12-11.02\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"DeepInstinct\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"DeepInstinct\",\n" +
            "                    \"engine_version\": \"3.1.0.15\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231207\"\n" +
            "                },\n" +
            "                \"Cylance\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Cylance\",\n" +
            "                    \"engine_version\": \"2.0.0.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231108\"\n" +
            "                },\n" +
            "                \"Zoner\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Zoner\",\n" +
            "                    \"engine_version\": \"2.2.2.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Rising\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Rising\",\n" +
            "                    \"engine_version\": \"25.0.0.27\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Yandex\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Yandex\",\n" +
            "                    \"engine_version\": \"5.5.2.24\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Ikarus\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Ikarus\",\n" +
            "                    \"engine_version\": \"6.2.4.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"MaxSecure\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"MaxSecure\",\n" +
            "                    \"engine_version\": \"1.0.0.1\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Fortinet\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Fortinet\",\n" +
            "                    \"engine_version\": \"None\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"AVG\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"AVG\",\n" +
            "                    \"engine_version\": \"23.9.8494.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231211\"\n" +
            "                },\n" +
            "                \"Cybereason\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"Cybereason\",\n" +
            "                    \"engine_version\": \"1.2.449\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231102\"\n" +
            "                },\n" +
            "                \"Panda\": {\n" +
            "                    \"category\": \"undetected\",\n" +
            "                    \"engine_name\": \"Panda\",\n" +
            "                    \"engine_version\": \"4.6.4.2\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": \"20231210\"\n" +
            "                },\n" +
            "                \"CrowdStrike\": {\n" +
            "                    \"category\": \"type-unsupported\",\n" +
            "                    \"engine_name\": \"CrowdStrike\",\n" +
            "                    \"engine_version\": \"1.0\",\n" +
            "                    \"result\": null,\n" +
            "                    \"method\": \"blacklist\",\n" +
            "                    \"engine_update\": null\n" +
            "                }\n" +
            "            },\n" +
            "            \"trid\": [\n" +
            "                {\n" +
            "                    \"file_type\": \"ZIP compressed archive (empty)\",\n" +
            "                    \"probability\": 80\n" +
            "                },\n" +
            "                {\n" +
            "                    \"file_type\": \"PrintFox/Pagefox bitmap (640x800)\",\n" +
            "                    \"probability\": 20\n" +
            "                }\n" +
            "            ],\n" +
            "            \"sandbox_verdicts\": {\n" +
            "                \"Zenbox Linux\": {\n" +
            "                    \"category\": \"harmless\",\n" +
            "                    \"confidence\": 1,\n" +
            "                    \"sandbox_name\": \"Zenbox Linux\",\n" +
            "                    \"malware_classification\": [\n" +
            "                        \"CLEAN\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            \"sha256\": \"8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\",\n" +
            "            \"wireshark\": {\n" +
            "                \"pcap\": {\n" +
            "                    \"File encapsulation\": \"\",\n" +
            "                    \"File type\": \"\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"trusted_verdict\": {\n" +
            "                \"link\": \"https://dl.google.com/dl/spotlight/test/lprn_spotlightstory/9/lprn_spotlightstory_015.zip\",\n" +
            "                \"organization\": \"Google\",\n" +
            "                \"verdict\": \"goodware\",\n" +
            "                \"filename\": \"lprn_spotlightstory_015.zip\"\n" +
            "            },\n" +
            "            \"tags\": [\n" +
            "                \"nsrl\",\n" +
            "                \"sets-process-name\",\n" +
            "                \"zip\",\n" +
            "                \"detect-debug-environment\",\n" +
            "                \"attachment\",\n" +
            "                \"via-tor\",\n" +
            "                \"known-distributor\",\n" +
            "                \"trusted\",\n" +
            "                \"software-collection\"\n" +
            "            ],\n" +
            "            \"last_analysis_date\": 1702285219,\n" +
            "            \"unique_sources\": 3609,\n" +
            "            \"first_submission_date\": 1170892383,\n" +
            "            \"ssdeep\": \"3:pjt/l:Nt\",\n" +
            "            \"md5\": \"76cdb2bad9582d23c1f6f4d868218d6c\",\n" +
            "            \"sha1\": \"b04f3ee8f5e43fa3b162981b50bb72fe1acabb33\",\n" +
            "            \"magic\": \"Zip archive data (empty)\",\n" +
            "            \"last_analysis_stats\": {\n" +
            "                \"harmless\": 0,\n" +
            "                \"type-unsupported\": 15,\n" +
            "                \"suspicious\": 0,\n" +
            "                \"confirmed-timeout\": 0,\n" +
            "                \"timeout\": 0,\n" +
            "                \"failure\": 2,\n" +
            "                \"malicious\": 0,\n" +
            "                \"undetected\": 59\n" +
            "            },\n" +
            "            \"meaningful_name\": \"lprn_spotlightstory_015.zip\",\n" +
            "            \"reputation\": -896,\n" +
            "            \"first_seen_itw_date\": 1235525277\n" +
            "        },\n" +
            "        \"type\": \"file\",\n" +
            "        \"id\": \"8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\",\n" +
            "        \"links\": {\n" +
            "            \"self\": \"https://www.virustotal.com/api/v3/files/8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static String mockMitreZenboxLinux = "{\n" +
            "    \"data\": {\n" +
            "        \"Zenbox Linux\": {\n" +
            "            \"tactics\": [\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to maintain their foothold.\\n\\nPersistence consists of techniques that adversaries use to keep access to systems across restarts, changed credentials, and other interruptions that could cut off their access. Techniques used for persistence include any access, action, or configuration changes that let them maintain their foothold on systems, such as replacing or hijacking legitimate code or adding startup code. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                            \"id\": \"T1543.002\",\n" +
            "                            \"name\": \"Systemd Service\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0003/\",\n" +
            "                    \"id\": \"TA0003\",\n" +
            "                    \"name\": \"Persistence\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to run malicious code.\\n\\nExecution consists of techniques that result in adversary-controlled code running on a local or remote system. Techniques that run malicious code are often paired with techniques from all other tactics to achieve broader goals, like exploring a network or stealing data. For example, an adversary might use a remote access tool to run a PowerShell script that does Remote System Discovery. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                            \"id\": \"T1064\",\n" +
            "                            \"name\": \"Scripting\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may abuse command and script interpreters to execute commands, scripts, or binaries. These interfaces and languages provide ways of interacting with computer systems and are a common feature across many different platforms. Most systems come with some built-in command-line interface and scripting capabilities, for example, macOS and Linux distributions include some flavor of Unix Shell while Windows installations include the Windows Command Shell and PowerShell.\\nThere are also cross-platform interpreters such as Python, as well as those commonly associated with client applications such as JavaScript and Visual Basic.\\nAdversaries may abuse these technologies in various ways as a means of executing arbitrary commands. Commands and scripts can be embedded in Initial Access payloads delivered to victims as lure documents or as secondary payloads downloaded from an existing C2. Adversaries may also execute commands through interactive terminals/shells, as well as utilize various Remote Services in order to achieve remote Execution.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"sed\\\" command used to modify input streams (typically from files or pipes)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1059/\",\n" +
            "                            \"id\": \"T1059\",\n" +
            "                            \"name\": \"Command and Scripting Interpreter\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0002/\",\n" +
            "                    \"id\": \"TA0002\",\n" +
            "                    \"name\": \"Execution\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to figure out your environment.\\n\\nDiscovery consists of techniques an adversary may use to gain knowledge about the system and internal network. These techniques help adversaries observe the environment and orient themselves before deciding how to act. They also allow adversaries to explore what they can control and what’s around their entry point in order to discover how it could benefit their current objective. Native operating system tools are often used toward this post-compromise information-gathering objective. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"An adversary may attempt to get detailed information about the operating system and hardware, including version, patches, hotfixes, service packs, and architecture. Adversaries may use the information from System Information Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nTools such as Systeminfo can be used to gather detailed system information. If running with privileged access, a breakdown of system data can be gathered through the systemsetup configuration tool on macOS. As an example, adversaries with user-level access can execute the df -aH command to obtain currently mounted disks and associated freely available space. Adversaries may also leverage a Network Device CLI on network devices to gather detailed system information (e.g. show version). System Information Discovery combined with information gathered from other forms of discovery and reconnaissance can drive payload development and concealment.\\nInfrastructure as a Service (IaaS) cloud providers such as AWS, GCP, and Azure allow access to instance and virtual machine information via APIs. Successful authenticated API calls can return data such as the operating system platform and status of a particular instance or the model view of a virtual machine.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Reads system information from the proc file system\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Reads CPU information from /sys indicative of miner or evasive malware\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1082/\",\n" +
            "                            \"id\": \"T1082\",\n" +
            "                            \"name\": \"System Information Discovery\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may enumerate files and directories or may search in specific locations of a host or network share for certain information within a file system. Adversaries may use the information from File and Directory Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nMany command shell utilities can be used to obtain this information. Examples include dir, tree, ls, find, and locate. Custom tools may also be used to gather file and directory information and interact with the Native API. Adversaries may also leverage a Network Device CLI on network devices to gather file and directory information (e.g. dir, show flash, and/or nvram).\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"LOW\",\n" +
            "                                    \"description\": \"Sample reads /proc/mounts (often used for finding a writable filesystem)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1083/\",\n" +
            "                            \"id\": \"T1083\",\n" +
            "                            \"name\": \"File and Directory Discovery\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may attempt to get a listing of security software, configurations, defensive tools, and sensors that are installed on a system or in a cloud environment. This may include things such as firewall rules and anti-virus. Adversaries may use the information from Security Software Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nExample commands that can be used to obtain security software information are netsh, reg query with Reg, dir with cmd, and Tasklist, but other indicators of discovery behavior may be more specific to the type of software or security system the adversary is looking for. It is becoming more common to see macOS malware perform checks for LittleSnitch and KnockKnock software.\\nAdversaries may also utilize cloud APIs to discover the configurations of firewall rules within an environment. For example, the permitted IP ranges, ports or user accounts for the inbound/outbound rules of security groups, virtual firewalls established within AWS for EC2 and/or VPC instances, can be revealed by the DescribeSecurityGroups action with various request parameters. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Uses the \\\"uname\\\" system call to query kernel version information (possible evasion)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1518/001/\",\n" +
            "                            \"id\": \"T1518.001\",\n" +
            "                            \"name\": \"Security Software Discovery\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0007/\",\n" +
            "                    \"id\": \"TA0007\",\n" +
            "                    \"name\": \"Discovery\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to avoid being detected.\\n\\nDefense Evasion consists of techniques that adversaries use to avoid detection throughout their compromise. Techniques used for defense evasion include uninstalling/disabling security software or obfuscating/encrypting data and scripts. Adversaries also leverage and abuse trusted processes to hide and masquerade their malware. Other tactics’ techniques are cross-listed here when those techniques include the added benefit of subverting defenses. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                            \"id\": \"T1064\",\n" +
            "                            \"name\": \"Scripting\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may set files and directories to be hidden to evade detection mechanisms. To prevent normal users from accidentally changing special files on a system, most operating systems have the concept of a ‘hidden’ file. These files don’t show up when a user browses the file system with a GUI or when using normal commands on the command line. Users must explicitly ask to show the hidden files either via a series of Graphical User Interface (GUI) prompts or with command line switches (dir /a for Windows and ls –a for Linux and macOS).\\nOn Linux and Mac, users can mark specific files as hidden simply by putting a “.” as the first character in the file or folder name   . Files and folders that start with a period, ‘.’, are by default hidden from being viewed in the Finder application and standard command-line utilities like “ls”. Users must specifically change settings to have these files viewable.\\nFiles on macOS can also be marked with the UF_HIDDEN flag which prevents them from being seen in Finder.app, but still allows them to be seen in Terminal.app . On Windows, users can mark specific files as hidden by using the attrib.exe binary. Many applications create these hidden files and folders to store information so that it doesn’t clutter up the user’s workspace. For example, SSH utilities create a .ssh folder that’s hidden and contains the user’s known hosts and keys.\\nAdversaries can use this to their advantage to hide files and folders anywhere on the system and evading a typical user or system analysis that does not incorporate investigation of hidden files.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Creates hidden files, links and/or directories\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1564/001/\",\n" +
            "                            \"id\": \"T1564.001\",\n" +
            "                            \"name\": \"Hidden Files and Directories\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0005/\",\n" +
            "                    \"id\": \"TA0005\",\n" +
            "                    \"name\": \"Defense Evasion\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to gain higher-level permissions.\\n\\nPrivilege Escalation consists of techniques that adversaries use to gain higher-level permissions on a system or network. Adversaries can often enter and explore a network with unprivileged access but require elevated permissions to follow through on their objectives. Common approaches are to take advantage of system weaknesses, misconfigurations, and vulnerabilities. Examples of elevated access include: \\n\\n* SYSTEM/root level\\n* local administrator\\n* user account with admin-like access \\n* user accounts with access to specific system or perform specific function\\n\\nThese techniques often overlap with Persistence techniques, as OS features that let an adversary persist can execute in an elevated context.  \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                            \"id\": \"T1543.002\",\n" +
            "                            \"name\": \"Systemd Service\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0004/\",\n" +
            "                    \"id\": \"TA0004\",\n" +
            "                    \"name\": \"Privilege Escalation\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    },\n" +
            "    \"links\": {\n" +
            "        \"self\": \"https://www.virustotal.com/api/v3/files/8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85/behaviour_mitre_trees\"\n" +
            "    }\n" +
            "}";

    public static String mockMitreZenbox = "{\n" +
            "    \"data\": {\n" +
            "        \"VirusTotal Observer\": null,\n" +
            "        \"Zenbox\": {\n" +
            "            \"tactics\": [\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to maintain their foothold.\\n\\nPersistence consists of techniques that adversaries use to keep access to systems across restarts, changed credentials, and other interruptions that could cut off their access. Techniques used for persistence include any access, action, or configuration changes that let them maintain their foothold on systems, such as replacing or hijacking legitimate code or adding startup code. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                            \"id\": \"T1543.002\",\n" +
            "                            \"name\": \"Systemd Service\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0003/\",\n" +
            "                    \"id\": \"TA0003\",\n" +
            "                    \"name\": \"Persistence\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to run malicious code.\\n\\nExecution consists of techniques that result in adversary-controlled code running on a local or remote system. Techniques that run malicious code are often paired with techniques from all other tactics to achieve broader goals, like exploring a network or stealing data. For example, an adversary might use a remote access tool to run a PowerShell script that does Remote System Discovery. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                            \"id\": \"T1064\",\n" +
            "                            \"name\": \"Scripting\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may abuse command and script interpreters to execute commands, scripts, or binaries. These interfaces and languages provide ways of interacting with computer systems and are a common feature across many different platforms. Most systems come with some built-in command-line interface and scripting capabilities, for example, macOS and Linux distributions include some flavor of Unix Shell while Windows installations include the Windows Command Shell and PowerShell.\\nThere are also cross-platform interpreters such as Python, as well as those commonly associated with client applications such as JavaScript and Visual Basic.\\nAdversaries may abuse these technologies in various ways as a means of executing arbitrary commands. Commands and scripts can be embedded in Initial Access payloads delivered to victims as lure documents or as secondary payloads downloaded from an existing C2. Adversaries may also execute commands through interactive terminals/shells, as well as utilize various Remote Services in order to achieve remote Execution.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"sed\\\" command used to modify input streams (typically from files or pipes)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1059/\",\n" +
            "                            \"id\": \"T1059\",\n" +
            "                            \"name\": \"Command and Scripting Interpreter\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0002/\",\n" +
            "                    \"id\": \"TA0002\",\n" +
            "                    \"name\": \"Execution\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to figure out your environment.\\n\\nDiscovery consists of techniques an adversary may use to gain knowledge about the system and internal network. These techniques help adversaries observe the environment and orient themselves before deciding how to act. They also allow adversaries to explore what they can control and what’s around their entry point in order to discover how it could benefit their current objective. Native operating system tools are often used toward this post-compromise information-gathering objective. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"An adversary may attempt to get detailed information about the operating system and hardware, including version, patches, hotfixes, service packs, and architecture. Adversaries may use the information from System Information Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nTools such as Systeminfo can be used to gather detailed system information. If running with privileged access, a breakdown of system data can be gathered through the systemsetup configuration tool on macOS. As an example, adversaries with user-level access can execute the df -aH command to obtain currently mounted disks and associated freely available space. Adversaries may also leverage a Network Device CLI on network devices to gather detailed system information (e.g. show version). System Information Discovery combined with information gathered from other forms of discovery and reconnaissance can drive payload development and concealment.\\nInfrastructure as a Service (IaaS) cloud providers such as AWS, GCP, and Azure allow access to instance and virtual machine information via APIs. Successful authenticated API calls can return data such as the operating system platform and status of a particular instance or the model view of a virtual machine.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Reads system information from the proc file system\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Reads CPU information from /sys indicative of miner or evasive malware\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1082/\",\n" +
            "                            \"id\": \"T1082\",\n" +
            "                            \"name\": \"System Information Discovery\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may enumerate files and directories or may search in specific locations of a host or network share for certain information within a file system. Adversaries may use the information from File and Directory Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nMany command shell utilities can be used to obtain this information. Examples include dir, tree, ls, find, and locate. Custom tools may also be used to gather file and directory information and interact with the Native API. Adversaries may also leverage a Network Device CLI on network devices to gather file and directory information (e.g. dir, show flash, and/or nvram).\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"LOW\",\n" +
            "                                    \"description\": \"Sample reads /proc/mounts (often used for finding a writable filesystem)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1083/\",\n" +
            "                            \"id\": \"T1083\",\n" +
            "                            \"name\": \"File and Directory Discovery\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may attempt to get a listing of security software, configurations, defensive tools, and sensors that are installed on a system or in a cloud environment. This may include things such as firewall rules and anti-virus. Adversaries may use the information from Security Software Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nExample commands that can be used to obtain security software information are netsh, reg query with Reg, dir with cmd, and Tasklist, but other indicators of discovery behavior may be more specific to the type of software or security system the adversary is looking for. It is becoming more common to see macOS malware perform checks for LittleSnitch and KnockKnock software.\\nAdversaries may also utilize cloud APIs to discover the configurations of firewall rules within an environment. For example, the permitted IP ranges, ports or user accounts for the inbound/outbound rules of security groups, virtual firewalls established within AWS for EC2 and/or VPC instances, can be revealed by the DescribeSecurityGroups action with various request parameters. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Uses the \\\"uname\\\" system call to query kernel version information (possible evasion)\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1518/001/\",\n" +
            "                            \"id\": \"T1518.001\",\n" +
            "                            \"name\": \"Security Software Discovery\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0007/\",\n" +
            "                    \"id\": \"TA0007\",\n" +
            "                    \"name\": \"Discovery\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to avoid being detected.\\n\\nDefense Evasion consists of techniques that adversaries use to avoid detection throughout their compromise. Techniques used for defense evasion include uninstalling/disabling security software or obfuscating/encrypting data and scripts. Adversaries also leverage and abuse trusted processes to hide and masquerade their malware. Other tactics’ techniques are cross-listed here when those techniques include the added benefit of subverting defenses. \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                            \"id\": \"T1064\",\n" +
            "                            \"name\": \"Scripting\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may set files and directories to be hidden to evade detection mechanisms. To prevent normal users from accidentally changing special files on a system, most operating systems have the concept of a ‘hidden’ file. These files don’t show up when a user browses the file system with a GUI or when using normal commands on the command line. Users must explicitly ask to show the hidden files either via a series of Graphical User Interface (GUI) prompts or with command line switches (dir /a for Windows and ls –a for Linux and macOS).\\nOn Linux and Mac, users can mark specific files as hidden simply by putting a “.” as the first character in the file or folder name   . Files and folders that start with a period, ‘.’, are by default hidden from being viewed in the Finder application and standard command-line utilities like “ls”. Users must specifically change settings to have these files viewable.\\nFiles on macOS can also be marked with the UF_HIDDEN flag which prevents them from being seen in Finder.app, but still allows them to be seen in Terminal.app . On Windows, users can mark specific files as hidden by using the attrib.exe binary. Many applications create these hidden files and folders to store information so that it doesn’t clutter up the user’s workspace. For example, SSH utilities create a .ssh folder that’s hidden and contains the user’s known hosts and keys.\\nAdversaries can use this to their advantage to hide files and folders anywhere on the system and evading a typical user or system analysis that does not incorporate investigation of hidden files.\",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Creates hidden files, links and/or directories\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1564/001/\",\n" +
            "                            \"id\": \"T1564.001\",\n" +
            "                            \"name\": \"Hidden Files and Directories\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0005/\",\n" +
            "                    \"id\": \"TA0005\",\n" +
            "                    \"name\": \"Defense Evasion\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"description\": \"The adversary is trying to gain higher-level permissions.\\n\\nPrivilege Escalation consists of techniques that adversaries use to gain higher-level permissions on a system or network. Adversaries can often enter and explore a network with unprivileged access but require elevated permissions to follow through on their objectives. Common approaches are to take advantage of system weaknesses, misconfigurations, and vulnerabilities. Examples of elevated access include: \\n\\n* SYSTEM/root level\\n* local administrator\\n* user account with admin-like access \\n* user accounts with access to specific system or perform specific function\\n\\nThese techniques often overlap with Persistence techniques, as OS features that let an adversary persist can execute in an elevated context.  \",\n" +
            "                    \"techniques\": [\n" +
            "                        {\n" +
            "                            \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                            \"signatures\": [\n" +
            "                                {\n" +
            "                                    \"severity\": \"INFO\",\n" +
            "                                    \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                            \"id\": \"T1543.002\",\n" +
            "                            \"name\": \"Systemd Service\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"link\": \"https://attack.mitre.org/tactics/TA0004/\",\n" +
            "                    \"id\": \"TA0004\",\n" +
            "                    \"name\": \"Privilege Escalation\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        \"Zenbox Linux\": null,\n" +
            "        \"VirusTotal Jujubox\": null\n" +
            "    },\n" +
            "    \"links\": {\n" +
            "        \"self\": \"https://www.virustotal.com/api/v3/files/8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85/behaviour_mitre_trees\"\n" +
            "    }\n" +
            "}";

    public static String mockWhoisDomainResponse = "{\n" +
            "    \"server\": \"Iota\",\n" +
            "    \"name\": \"google.it\",\n" +
            "    \"idnName\": \"google.it\",\n" +
            "    \"nameserver\": [\n" +
            "        \"ns1.google.com\",\n" +
            "        \"ns2.google.com\",\n" +
            "        \"ns3.google.com\",\n" +
            "        \"ns4.google.com\"\n" +
            "    ],\n" +
            "    \"ips\": \"142.251.179.94\",\n" +
            "    \"created\": \"1999-12-10 00:00:00\",\n" +
            "    \"changed\": \"2023-05-07 01:01:19\",\n" +
            "    \"expires\": \"2024-04-21 00:00:00\",\n" +
            "    \"registered\": true,\n" +
            "    \"dnssec\": null,\n" +
            "    \"whoisserver\": \"whois.nic.it\",\n" +
            "    \"contacts\": {\n" +
            "        \"owner\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": null,\n" +
            "                \"organization\": \"Google Ireland Holdings Unlimited Company\",\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"70 Sir John Rogerson's Quay\",\n" +
            "                \"zipcode\": \"2\",\n" +
            "                \"city\": \"Dublin\",\n" +
            "                \"state\": \"Dublin\",\n" +
            "                \"country\": \"IE\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": \"2018-03-02 19:04:02\",\n" +
            "                \"changed\": \"2018-03-02 19:04:02\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"admin\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": \"Rajiv Prasad\",\n" +
            "                \"organization\": \"Google LLC\",\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"1600 Amphitheatre Parkway\",\n" +
            "                \"zipcode\": \"94043\",\n" +
            "                \"city\": \"Mountain View\",\n" +
            "                \"state\": \"CA\",\n" +
            "                \"country\": \"US\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": \"2022-05-18 21:12:35\",\n" +
            "                \"changed\": \"2022-05-18 21:12:35\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"tech\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": \"Domain Administrator\",\n" +
            "                \"organization\": \"Google LLC\",\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"1600 Amphitheatre Parkway\",\n" +
            "                \"zipcode\": \"94043\",\n" +
            "                \"city\": \"Mountain View\",\n" +
            "                \"state\": \"CA\",\n" +
            "                \"country\": \"US\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": \"2017-12-21 19:54:04\",\n" +
            "                \"changed\": \"2017-12-21 19:54:04\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"registrar\": {\n" +
            "        \"id\": \"MARKMONITOR-REG\",\n" +
            "        \"name\": \"MarkMonitor International Limited\",\n" +
            "        \"email\": null,\n" +
            "        \"url\": null,\n" +
            "        \"phone\": null\n" +
            "    },\n" +
            "    \"rawdata\": [\n" +
            "        \"\\n\\n*********************************************************************\\n* Please note that the following result could be a subgroup of      *\\n* the data contained in the database.                               *\\n*                                                                   *\\n* Additional information can be visualized at:                      *\\n* http://web-whois.nic.it                                           *\\n*********************************************************************\\n\\nDomain:             google.it\\nStatus:             ok\\nSigned:             no\\nCreated:            1999-12-10 00:00:00\\nLast Update:        2023-05-07 01:01:19\\nExpire Date:        2024-04-21\\n\\nRegistrant\\n  Organization:     Google Ireland Holdings Unlimited Company\\n  Address:          70 Sir John Rogerson's Quay\\n                    Dublin\\n                    2\\n                    Dublin\\n                    IE\\n  Created:          2018-03-02 19:04:02\\n  Last Update:      2018-03-02 19:04:02\\n\\nAdmin Contact\\n  Name:             Rajiv Prasad\\n  Organization:     Google LLC\\n  Address:          1600 Amphitheatre Parkway\\n                    Mountain View\\n                    94043\\n                    CA\\n                    US\\n  Created:          2022-05-18 21:12:35\\n  Last Update:      2022-05-18 21:12:35\\n\\nTechnical Contacts\\n  Name:             Domain Administrator\\n  Organization:     Google LLC\\n  Address:          1600 Amphitheatre Parkway\\n                    Mountain View\\n                    94043\\n                    CA\\n                    US\\n  Created:          2017-12-21 19:54:04\\n  Last Update:      2017-12-21 19:54:04\\n\\nRegistrar\\n  Organization:     MarkMonitor International Limited\\n  Name:             MARKMONITOR-REG\\n  Web:              https://www.markmonitor.com/\\n  DNSSEC:           no\\n\\n\\nNameservers\\n  ns1.google.com\\n  ns2.google.com\\n  ns3.google.com\\n  ns4.google.com\\n\\n\"\n" +
            "    ],\n" +
            "    \"network\": null,\n" +
            "    \"exception\": null,\n" +
            "    \"parsedContacts\": true,\n" +
            "    \"template\": null,\n" +
            "    \"ask_whois\": null\n" +
            "}";

    public static String mockDataResp = "{\n" +
            "    \"attributes\": {\n" +
            "        \"type_description\": \"ZIP\",\n" +
            "        \"tlsh\": \"TNULL\",\n" +
            "        \"type_tags\": [\n" +
            "            \"compressed\",\n" +
            "            \"zip\"\n" +
            "        ],\n" +
            "        \"nsrl_info\": {\n" +
            "            \"products\": [\n" +
            "                \"Master Hacker Internet Terrorism (Core Publishing Inc.)\",\n" +
            "                \"Read Rabbits Math Ages 6-9 (Smart Saver)\",\n" +
            "                \"Neverwinter Nights Gold (Atari)\",\n" +
            "                \"Limited Edition Print Workshop 2004 (ValuSoft)\",\n" +
            "                \"Crysis (Electronic Arts Inc.)\"\n" +
            "            ],\n" +
            "            \"filenames\": [\n" +
            "                \"WINDOWS DIALUP.ZIP\",\n" +
            "                \"kemsetup.ZIP\",\n" +
            "                \"Data_Linux.zip\",\n" +
            "                \"2003.zip\",\n" +
            "                \"_6A271FB199E041FC82F4D282E68B01D6\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"names\": [\n" +
            "            \"temp.zip\",\n" +
            "            \"release.zip\",\n" +
            "            \"files.zip\",\n" +
            "            \"Raft-BossDrops.zip\",\n" +
            "            \"zipnew.dat\",\n" +
            "            \"6b905e85-ae9b-44f7-a108-b9ca0c1364df.tmp\",\n" +
            "            \"a2407ef2-9a39-4e5e-a63a-cd5dc054fd2c.tmp\",\n" +
            "            \"8c2df6dd-73bc-457c-aa45-1326fd54c12a.tmp\",\n" +
            "            \"ac3plug.zip\",\n" +
            "            \"534d7dd6-6b74-42e7-b094-7182924d9f4a.tmp\",\n" +
            "            \"Fireworks.Mania.Gamdie.com.zip\",\n" +
            "            \"Alex_13 (1).zip\",\n" +
            "            \"43f93f87-d84f-4b42-a504-ecfa63b3ace7.tmp\",\n" +
            "            \"Dqietwasyfedru.zip\",\n" +
            "            \"translation.zip (copy)\",\n" +
            "            \"translation.zip\",\n" +
            "            \"R3nzSkin.zip\",\n" +
            "            \"oko3y.zip\",\n" +
            "            \"New Compressed (zipped) Folder.zip\",\n" +
            "            \"winwlogs.zip\",\n" +
            "            \"tw7yb-c65w7.zip\",\n" +
            "            \"mymacro.zip\",\n" +
            "            \"Efoarpeu.zip\",\n" +
            "            \"Kirby - Nightmare in Dream Land (Europe) (En,Fr,De,Es,It) (1).zip\",\n" +
            "            \"[indexsubtitle.cc]_the-nun-ii_english_3185438.zip\",\n" +
            "            \"EZfrags.co.uk_csgo_multi_public.zip\"\n" +
            "        ],\n" +
            "        \"last_modification_date\": 1703426933,\n" +
            "        \"type_tag\": \"zip\",\n" +
            "        \"times_submitted\": 235820,\n" +
            "        \"total_votes\": {\n" +
            "            \"harmless\": 681,\n" +
            "            \"malicious\": 995\n" +
            "        },\n" +
            "        \"size\": 22,\n" +
            "        \"type_extension\": \"zip\",\n" +
            "        \"last_submission_date\": 1703425083,\n" +
            "        \"known_distributors\": {\n" +
            "            \"filenames\": [\n" +
            "                \"SpeechBr.pak\",\n" +
            "                \"New Text Document.zip\",\n" +
            "                \"lprn_spotlightstory_015.zip\",\n" +
            "                \"MacmillanEducationAlturaDev-win32-x64-1.0.0.728.exe.zip\",\n" +
            "                \"DDR_Asphalt_variety.zip\"\n" +
            "            ],\n" +
            "            \"products\": [\n" +
            "                \"Dying Light\",\n" +
            "                \"OMSI 2: Steam Edition\"\n" +
            "            ],\n" +
            "            \"distributors\": [\n" +
            "                \"Microsoft\",\n" +
            "                \"MR-Software GbR\",\n" +
            "                \"Google\"\n" +
            "            ],\n" +
            "            \"links\": [\n" +
            "                \"https://dl.google.com/dl/spotlight/test/lprn_spotlightstory/9/lprn_spotlightstory_015.zip\"\n" +
            "            ],\n" +
            "            \"data_sources\": [\n" +
            "                \"Microsoft Corporation\",\n" +
            "                \"National Software Reference Library (NSRL)\",\n" +
            "                \"Google\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"last_analysis_results\": {\n" +
            "            \"Bkav\": {\n" +
            "                \"category\": \"failure\",\n" +
            "                \"engine_name\": \"Bkav\",\n" +
            "                \"engine_version\": \"2.0.0.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Lionic\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Lionic\",\n" +
            "                \"engine_version\": \"7.5\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"tehtris\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"tehtris\",\n" +
            "                \"engine_version\": null,\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"ClamAV\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"ClamAV\",\n" +
            "                \"engine_version\": \"1.2.1.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"FireEye\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"FireEye\",\n" +
            "                \"engine_version\": \"35.24.1.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"CAT-QuickHeal\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"CAT-QuickHeal\",\n" +
            "                \"engine_version\": \"22.00\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Skyhigh\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Skyhigh\",\n" +
            "                \"engine_version\": \"v2021.2.0+4045\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"McAfee\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"McAfee\",\n" +
            "                \"engine_version\": \"6.0.6.653\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Malwarebytes\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Malwarebytes\",\n" +
            "                \"engine_version\": \"4.5.5.54\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Zillya\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Zillya\",\n" +
            "                \"engine_version\": \"2.0.0.5019\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Sangfor\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Sangfor\",\n" +
            "                \"engine_version\": \"2.23.0.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231219\"\n" +
            "            },\n" +
            "            \"Trustlook\": {\n" +
            "                \"category\": \"failure\",\n" +
            "                \"engine_name\": \"Trustlook\",\n" +
            "                \"engine_version\": \"1.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Alibaba\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Alibaba\",\n" +
            "                \"engine_version\": \"0.3.0.5\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20190527\"\n" +
            "            },\n" +
            "            \"K7GW\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"K7GW\",\n" +
            "                \"engine_version\": \"12.131.50511\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"K7AntiVirus\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"K7AntiVirus\",\n" +
            "                \"engine_version\": \"12.131.50511\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Arcabit\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Arcabit\",\n" +
            "                \"engine_version\": \"2022.0.0.18\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"BitDefenderTheta\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"BitDefenderTheta\",\n" +
            "                \"engine_version\": \"7.2.37796.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231127\"\n" +
            "            },\n" +
            "            \"VirIT\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"VirIT\",\n" +
            "                \"engine_version\": \"9.5.605\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231222\"\n" +
            "            },\n" +
            "            \"SymantecMobileInsight\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"SymantecMobileInsight\",\n" +
            "                \"engine_version\": \"2.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20230119\"\n" +
            "            },\n" +
            "            \"Symantec\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Symantec\",\n" +
            "                \"engine_version\": \"1.21.0.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Elastic\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Elastic\",\n" +
            "                \"engine_version\": \"4.0.121\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231208\"\n" +
            "            },\n" +
            "            \"ESET-NOD32\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"ESET-NOD32\",\n" +
            "                \"engine_version\": \"28452\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"APEX\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"APEX\",\n" +
            "                \"engine_version\": \"6.481\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231222\"\n" +
            "            },\n" +
            "            \"TrendMicro-HouseCall\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"TrendMicro-HouseCall\",\n" +
            "                \"engine_version\": \"10.0.0.1040\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Avast\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Avast\",\n" +
            "                \"engine_version\": \"23.9.8494.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Cynet\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Cynet\",\n" +
            "                \"engine_version\": \"4.0.0.28\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Kaspersky\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Kaspersky\",\n" +
            "                \"engine_version\": \"22.0.1.28\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"BitDefender\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"BitDefender\",\n" +
            "                \"engine_version\": \"7.2\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"NANO-Antivirus\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"NANO-Antivirus\",\n" +
            "                \"engine_version\": \"1.0.146.25796\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"SUPERAntiSpyware\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"SUPERAntiSpyware\",\n" +
            "                \"engine_version\": \"5.6.0.1032\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"MicroWorld-eScan\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"MicroWorld-eScan\",\n" +
            "                \"engine_version\": \"14.0.409.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Tencent\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Tencent\",\n" +
            "                \"engine_version\": \"1.0.0.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Emsisoft\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Emsisoft\",\n" +
            "                \"engine_version\": \"2022.6.0.32461\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Baidu\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Baidu\",\n" +
            "                \"engine_version\": \"1.0.0.2\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20190318\"\n" +
            "            },\n" +
            "            \"F-Secure\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"F-Secure\",\n" +
            "                \"engine_version\": \"18.10.1547.307\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"DrWeb\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"DrWeb\",\n" +
            "                \"engine_version\": \"7.0.61.8090\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"VIPRE\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"VIPRE\",\n" +
            "                \"engine_version\": \"6.0.0.35\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"TrendMicro\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"TrendMicro\",\n" +
            "                \"engine_version\": \"11.0.0.1006\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"SentinelOne\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"SentinelOne\",\n" +
            "                \"engine_version\": \"23.4.2.3\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231119\"\n" +
            "            },\n" +
            "            \"Trapmine\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Trapmine\",\n" +
            "                \"engine_version\": \"4.0.14.97\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231106\"\n" +
            "            },\n" +
            "            \"CMC\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"CMC\",\n" +
            "                \"engine_version\": \"2.4.2022.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20230822\"\n" +
            "            },\n" +
            "            \"Sophos\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Sophos\",\n" +
            "                \"engine_version\": \"2.4.3.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Paloalto\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Paloalto\",\n" +
            "                \"engine_version\": \"0.9.0.1003\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Avast-Mobile\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Avast-Mobile\",\n" +
            "                \"engine_version\": \"231223-00\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Jiangmin\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Jiangmin\",\n" +
            "                \"engine_version\": \"16.0.100\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Webroot\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Webroot\",\n" +
            "                \"engine_version\": \"1.0.0.403\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Varist\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Varist\",\n" +
            "                \"engine_version\": \"6.5.1.2\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Avira\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Avira\",\n" +
            "                \"engine_version\": \"8.3.3.16\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"MAX\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"MAX\",\n" +
            "                \"engine_version\": \"2023.1.4.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Antiy-AVL\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Antiy-AVL\",\n" +
            "                \"engine_version\": \"3.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Kingsoft\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Kingsoft\",\n" +
            "                \"engine_version\": \"None\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20230906\"\n" +
            "            },\n" +
            "            \"Gridinsoft\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Gridinsoft\",\n" +
            "                \"engine_version\": \"1.0.152.174\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Xcitium\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Xcitium\",\n" +
            "                \"engine_version\": \"36285\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Microsoft\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Microsoft\",\n" +
            "                \"engine_version\": \"1.1.23110.2\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"ViRobot\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"ViRobot\",\n" +
            "                \"engine_version\": \"2014.3.20.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"ZoneAlarm\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"ZoneAlarm\",\n" +
            "                \"engine_version\": \"1.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"GData\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"GData\",\n" +
            "                \"engine_version\": \"A:25.37031B:27.34306\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Google\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Google\",\n" +
            "                \"engine_version\": \"1703381423\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"BitDefenderFalx\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"BitDefenderFalx\",\n" +
            "                \"engine_version\": \"2.0.936\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231121\"\n" +
            "            },\n" +
            "            \"AhnLab-V3\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"AhnLab-V3\",\n" +
            "                \"engine_version\": \"3.25.0.10459\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Acronis\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Acronis\",\n" +
            "                \"engine_version\": \"1.2.0.121\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20230828\"\n" +
            "            },\n" +
            "            \"VBA32\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"VBA32\",\n" +
            "                \"engine_version\": \"5.0.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231222\"\n" +
            "            },\n" +
            "            \"ALYac\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"ALYac\",\n" +
            "                \"engine_version\": \"1.1.3.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"TACHYON\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"TACHYON\",\n" +
            "                \"engine_version\": \"2023-12-24.01\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"DeepInstinct\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"DeepInstinct\",\n" +
            "                \"engine_version\": \"3.1.0.15\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231221\"\n" +
            "            },\n" +
            "            \"Cylance\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Cylance\",\n" +
            "                \"engine_version\": \"2.0.0.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231108\"\n" +
            "            },\n" +
            "            \"Zoner\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Zoner\",\n" +
            "                \"engine_version\": \"2.2.2.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Rising\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Rising\",\n" +
            "                \"engine_version\": \"25.0.0.27\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Yandex\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Yandex\",\n" +
            "                \"engine_version\": \"5.5.2.24\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Ikarus\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Ikarus\",\n" +
            "                \"engine_version\": \"6.2.4.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"MaxSecure\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"MaxSecure\",\n" +
            "                \"engine_version\": \"1.0.0.1\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"Fortinet\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Fortinet\",\n" +
            "                \"engine_version\": \"None\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"AVG\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"AVG\",\n" +
            "                \"engine_version\": \"23.9.8494.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231224\"\n" +
            "            },\n" +
            "            \"Cybereason\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"Cybereason\",\n" +
            "                \"engine_version\": \"1.2.449\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231102\"\n" +
            "            },\n" +
            "            \"Panda\": {\n" +
            "                \"category\": \"undetected\",\n" +
            "                \"engine_name\": \"Panda\",\n" +
            "                \"engine_version\": \"4.6.4.2\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": \"20231223\"\n" +
            "            },\n" +
            "            \"CrowdStrike\": {\n" +
            "                \"category\": \"type-unsupported\",\n" +
            "                \"engine_name\": \"CrowdStrike\",\n" +
            "                \"engine_version\": \"1.0\",\n" +
            "                \"result\": null,\n" +
            "                \"method\": \"blacklist\",\n" +
            "                \"engine_update\": null\n" +
            "            }\n" +
            "        },\n" +
            "        \"trid\": [\n" +
            "            {\n" +
            "                \"file_type\": \"ZIP compressed archive (empty)\",\n" +
            "                \"probability\": 80\n" +
            "            },\n" +
            "            {\n" +
            "                \"file_type\": \"PrintFox/Pagefox bitmap (640x800)\",\n" +
            "                \"probability\": 20\n" +
            "            }\n" +
            "        ],\n" +
            "        \"sandbox_verdicts\": {\n" +
            "            \"Zenbox Linux\": {\n" +
            "                \"category\": \"harmless\",\n" +
            "                \"confidence\": 1,\n" +
            "                \"sandbox_name\": \"Zenbox Linux\",\n" +
            "                \"malware_classification\": [\n" +
            "                    \"CLEAN\"\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        \"sha256\": \"8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\",\n" +
            "        \"wireshark\": {\n" +
            "            \"pcap\": {\n" +
            "                \"File encapsulation\": \"\",\n" +
            "                \"File type\": \"\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"trusted_verdict\": {\n" +
            "            \"link\": \"https://dl.google.com/dl/spotlight/test/lprn_spotlightstory/9/lprn_spotlightstory_015.zip\",\n" +
            "            \"organization\": \"Google\",\n" +
            "            \"verdict\": \"goodware\",\n" +
            "            \"filename\": \"lprn_spotlightstory_015.zip\"\n" +
            "        },\n" +
            "        \"tags\": [\n" +
            "            \"nsrl\",\n" +
            "            \"sets-process-name\",\n" +
            "            \"zip\",\n" +
            "            \"detect-debug-environment\",\n" +
            "            \"attachment\",\n" +
            "            \"via-tor\",\n" +
            "            \"known-distributor\",\n" +
            "            \"trusted\",\n" +
            "            \"software-collection\"\n" +
            "        ],\n" +
            "        \"last_analysis_date\": 1703387881,\n" +
            "        \"unique_sources\": 3609,\n" +
            "        \"first_submission_date\": 1170892383,\n" +
            "        \"ssdeep\": \"3:pjt/l:Nt\",\n" +
            "        \"md5\": \"76cdb2bad9582d23c1f6f4d868218d6c\",\n" +
            "        \"sha1\": \"b04f3ee8f5e43fa3b162981b50bb72fe1acabb33\",\n" +
            "        \"magic\": \"Zip archive data (empty)\",\n" +
            "        \"last_analysis_stats\": {\n" +
            "            \"harmless\": 0,\n" +
            "            \"type-unsupported\": 15,\n" +
            "            \"suspicious\": 0,\n" +
            "            \"confirmed-timeout\": 0,\n" +
            "            \"timeout\": 0,\n" +
            "            \"failure\": 2,\n" +
            "            \"malicious\": 0,\n" +
            "            \"undetected\": 59\n" +
            "        },\n" +
            "        \"meaningful_name\": \"lprn_spotlightstory_015.zip\",\n" +
            "        \"reputation\": -895,\n" +
            "        \"first_seen_itw_date\": 1235525277\n" +
            "    },\n" +
            "    \"type\": \"file\",\n" +
            "    \"id\": \"8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\",\n" +
            "    \"links\": {\n" +
            "        \"self\": \"https://www.virustotal.com/api/v3/files/8739c76e681f900923b900c9df0ef75cf421d39cabb54650c4b9ad19b6a76d85\"\n" +
            "    }\n" +
            "}";

    public static Response buildWhoisDomainResponse() {
        try {
            return objectMapper.readValue(mockWhoisDomainResponse, Response.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static DetectResponse buildDetectResponse() {
        try {
            return objectMapper.readValue(mockDetectResponse, DetectResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static CveResponse buildCveResponse() {
        try {
            return objectMapper.readValue(mockCveResponse, CveResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static RapidApiPasswordResponse buildRapidApiPasswordResponse() {
        try {
            return objectMapper.readValue(mockRapidApiPasswordResponse, RapidApiPasswordResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static PhoneResponse buildPhoneResponse() {
        try {
            return objectMapper.readValue(mockPhoneResponse, PhoneResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static RapidApi buildRapidApiResponse() {
        try {
            return objectMapper.readValue(mockRapidApiResponse, RapidApi.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static RapidApiHash buildRapidApiHashResponse() {
        try {
            return objectMapper.readValue(mockRapidApiHash, RapidApiHash.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileResponse buildFileResponse() {
        try {
            return objectMapper.readValue(mockFileResponse, FileResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Mitre buildMitreZenboxLinux() {
        try {
            return objectMapper.readValue(mockMitreZenboxLinux, Mitre.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Mitre buildMitreZenbox() {
        try {
            return objectMapper.readValue(mockMitreZenbox, Mitre.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static MockMultipartFile buildMultipartZipFile(byte[] fileContent) {
        return new MockMultipartFile(
                "file",
                "eicar_com.zip",
                "application/zip",
                fileContent
        );
    }

    public static MockMultipartFile buildMultipartTextFile() {
        return new MockMultipartFile(
                "file",
                "",
                "text/plain",
                new byte[0]
        );
    }

    public static DataResp buildDataResp() {
        try {
            return objectMapper.readValue(mockDataResp, DataResp.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
