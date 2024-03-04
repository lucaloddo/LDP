package it.unimib.easydefence.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.model.dto.DeviceDTO;
import it.unimib.easydefence.model.dto.FileDTO;
import it.unimib.easydefence.model.dto.PhoneDTO;
import it.unimib.easydefence.model.dto.UrlDTO;
import it.unimib.easydefence.model.rapidapiwhois.Response;

public class Mock {

    private Mock() {

    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String mockFileDTO = "{\n" +
            "    \"votes\": {\n" +
            "        \"harmless\": 681,\n" +
            "        \"malicious\": 995\n" +
            "    },\n" +
            "    \"filenameDistributions\": [\n" +
            "        \"temp.zip\",\n" +
            "        \"logArchive_2023-12-18_02-03-40.zip\",\n" +
            "        \"zipnew.dat\",\n" +
            "        \"ECED.bin\",\n" +
            "        \"10F7.bin\",\n" +
            "        \"empty-0.1.jar\",\n" +
            "        \"logArchive_2023-12-18_01-59-45.zip\",\n" +
            "        \"logArchive_2023-12-18_01-52-17.zip\",\n" +
            "        \"logArchive_2023-12-18_01-40-48.zip\",\n" +
            "        \"temp.zip~RFc2de70.TMP\",\n" +
            "        \"A1C3.tmp.zip\",\n" +
            "        \"fc90d44b-5222-4541-b2ef-67a8a283d4f4.tmp\",\n" +
            "        \"d9e00b8b-ab00-4209-b2f8-98bda260d504.tmp\",\n" +
            "        \"logArchive_2023-12-18_00-25-20.zip\",\n" +
            "        \"temp.zip~RF154d5e6.TMP\",\n" +
            "        \"temp.zip~RF8bb5cd.TMP\",\n" +
            "        \"091b0c89-3c0c-4384-af1a-107238c3d38d.tmp\",\n" +
            "        \"899220-001.zip\",\n" +
            "        \"logArchive_2023-12-17_22-39-54.zip\",\n" +
            "        \"drive.(2011).por.1cd.(8943304).zip\",\n" +
            "        \"46e52352-2213-4d5c-b032-116a9ad048b4.tmp\",\n" +
            "        \"logArchive_2023-12-17_20-36-13.zip\",\n" +
            "        \"mymacro.zip\",\n" +
            "        \"hylogs-Dec-11-202308-48-34.zip\",\n" +
            "        \"hylogs-Dec-17-202320-26-05.zip\",\n" +
            "        \"hylogs-Dec-17-202318-12-44.zip\",\n" +
            "        \"temp.zip~RFfbbd1f.TMP\",\n" +
            "        \"temp.zip~RF22c482b.TMP\",\n" +
            "        \"temp.zip~RF13e496e.TMP\",\n" +
            "        \"FilterKeysSetter_1.0.zip\",\n" +
            "        \"iletken-direnci-ve-gerilim-dusumu-hesaplama-programi.zip\",\n" +
            "        \"Архив ZIP - WinRAR.zip\",\n" +
            "        \"Vseigru-Browser-Web-Setup.zip\",\n" +
            "        \"files.zip\",\n" +
            "        \"warcraft-iii-the-frozen-throne.zip\",\n" +
            "        \"translation.zip (copy)\"\n" +
            "    ],\n" +
            "    \"tags\": [\n" +
            "        \"nsrl\",\n" +
            "        \"sets-process-name\",\n" +
            "        \"zip\",\n" +
            "        \"detect-debug-environment\",\n" +
            "        \"attachment\",\n" +
            "        \"via-tor\",\n" +
            "        \"known-distributor\",\n" +
            "        \"trusted\",\n" +
            "        \"software-collection\"\n" +
            "    ],\n" +
            "    \"analysisStats\": {\n" +
            "        \"harmless\": 0,\n" +
            "        \"type-unsupported\": 15,\n" +
            "        \"suspicious\": 0,\n" +
            "        \"confirmed-timeout\": 0,\n" +
            "        \"timeout\": 0,\n" +
            "        \"failure\": 0,\n" +
            "        \"malicious\": 0,\n" +
            "        \"undetected\": 61\n" +
            "    },\n" +
            "    \"zenbox\": {\n" +
            "        \"tactics\": [\n" +
            "            {\n" +
            "                \"description\": \"The adversary is trying to maintain their foothold.\\n\\nPersistence consists of techniques that adversaries use to keep access to systems across restarts, changed credentials, and other interruptions that could cut off their access. Techniques used for persistence include any access, action, or configuration changes that let them maintain their foothold on systems, such as replacing or hijacking legitimate code or adding startup code. \",\n" +
            "                \"techniques\": [\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                        \"id\": \"T1543.002\",\n" +
            "                        \"name\": \"Systemd Service\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"link\": \"https://attack.mitre.org/tactics/TA0003/\",\n" +
            "                \"id\": \"TA0003\",\n" +
            "                \"name\": \"Persistence\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"description\": \"The adversary is trying to run malicious code.\\n\\nExecution consists of techniques that result in adversary-controlled code running on a local or remote system. Techniques that run malicious code are often paired with techniques from all other tactics to achieve broader goals, like exploring a network or stealing data. For example, an adversary might use a remote access tool to run a PowerShell script that does Remote System Discovery. \",\n" +
            "                \"techniques\": [\n" +
            "                    {\n" +
            "                        \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                        \"id\": \"T1064\",\n" +
            "                        \"name\": \"Scripting\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may abuse command and script interpreters to execute commands, scripts, or binaries. These interfaces and languages provide ways of interacting with computer systems and are a common feature across many different platforms. Most systems come with some built-in command-line interface and scripting capabilities, for example, macOS and Linux distributions include some flavor of Unix Shell while Windows installations include the Windows Command Shell and PowerShell.\\nThere are also cross-platform interpreters such as Python, as well as those commonly associated with client applications such as JavaScript and Visual Basic.\\nAdversaries may abuse these technologies in various ways as a means of executing arbitrary commands. Commands and scripts can be embedded in Initial Access payloads delivered to victims as lure documents or as secondary payloads downloaded from an existing C2. Adversaries may also execute commands through interactive terminals/shells, as well as utilize various Remote Services in order to achieve remote Execution.\",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Executes the \\\"sed\\\" command used to modify input streams (typically from files or pipes)\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1059/\",\n" +
            "                        \"id\": \"T1059\",\n" +
            "                        \"name\": \"Command and Scripting Interpreter\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"link\": \"https://attack.mitre.org/tactics/TA0002/\",\n" +
            "                \"id\": \"TA0002\",\n" +
            "                \"name\": \"Execution\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"description\": \"The adversary is trying to figure out your environment.\\n\\nDiscovery consists of techniques an adversary may use to gain knowledge about the system and internal network. These techniques help adversaries observe the environment and orient themselves before deciding how to act. They also allow adversaries to explore what they can control and what’s around their entry point in order to discover how it could benefit their current objective. Native operating system tools are often used toward this post-compromise information-gathering objective. \",\n" +
            "                \"techniques\": [\n" +
            "                    {\n" +
            "                        \"description\": \"An adversary may attempt to get detailed information about the operating system and hardware, including version, patches, hotfixes, service packs, and architecture. Adversaries may use the information from System Information Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nTools such as Systeminfo can be used to gather detailed system information. If running with privileged access, a breakdown of system data can be gathered through the systemsetup configuration tool on macOS. As an example, adversaries with user-level access can execute the df -aH command to obtain currently mounted disks and associated freely available space. Adversaries may also leverage a Network Device CLI on network devices to gather detailed system information (e.g. show version). System Information Discovery combined with information gathered from other forms of discovery and reconnaissance can drive payload development and concealment.\\nInfrastructure as a Service (IaaS) cloud providers such as AWS, GCP, and Azure allow access to instance and virtual machine information via APIs. Successful authenticated API calls can return data such as the operating system platform and status of a particular instance or the model view of a virtual machine.\",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Reads system information from the proc file system\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Reads CPU information from /sys indicative of miner or evasive malware\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1082/\",\n" +
            "                        \"id\": \"T1082\",\n" +
            "                        \"name\": \"System Information Discovery\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may enumerate files and directories or may search in specific locations of a host or network share for certain information within a file system. Adversaries may use the information from File and Directory Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nMany command shell utilities can be used to obtain this information. Examples include dir, tree, ls, find, and locate. Custom tools may also be used to gather file and directory information and interact with the Native API. Adversaries may also leverage a Network Device CLI on network devices to gather file and directory information (e.g. dir, show flash, and/or nvram).\",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"LOW\",\n" +
            "                                \"description\": \"Sample reads /proc/mounts (often used for finding a writable filesystem)\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1083/\",\n" +
            "                        \"id\": \"T1083\",\n" +
            "                        \"name\": \"File and Directory Discovery\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may attempt to get a listing of security software, configurations, defensive tools, and sensors that are installed on a system or in a cloud environment. This may include things such as firewall rules and anti-virus. Adversaries may use the information from Security Software Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.\\nExample commands that can be used to obtain security software information are netsh, reg query with Reg, dir with cmd, and Tasklist, but other indicators of discovery behavior may be more specific to the type of software or security system the adversary is looking for. It is becoming more common to see macOS malware perform checks for LittleSnitch and KnockKnock software.\\nAdversaries may also utilize cloud APIs to discover the configurations of firewall rules within an environment. For example, the permitted IP ranges, ports or user accounts for the inbound/outbound rules of security groups, virtual firewalls established within AWS for EC2 and/or VPC instances, can be revealed by the DescribeSecurityGroups action with various request parameters. \",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Uses the \\\"uname\\\" system call to query kernel version information (possible evasion)\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1518/001/\",\n" +
            "                        \"id\": \"T1518.001\",\n" +
            "                        \"name\": \"Security Software Discovery\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"link\": \"https://attack.mitre.org/tactics/TA0007/\",\n" +
            "                \"id\": \"TA0007\",\n" +
            "                \"name\": \"Discovery\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"description\": \"The adversary is trying to avoid being detected.\\n\\nDefense Evasion consists of techniques that adversaries use to avoid detection throughout their compromise. Techniques used for defense evasion include uninstalling/disabling security software or obfuscating/encrypting data and scripts. Adversaries also leverage and abuse trusted processes to hide and masquerade their malware. Other tactics’ techniques are cross-listed here when those techniques include the added benefit of subverting defenses. \",\n" +
            "                \"techniques\": [\n" +
            "                    {\n" +
            "                        \"description\": \"This technique has been deprecated. Please use Command and Scripting Interpreter where appropriate.\\nAdversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts.\\nScripts can be embedded inside Office documents as macros that can be set to execute when files used in Spearphishing Attachment and other types of spearphishing are opened. Malicious embedded macros are an alternative means of execution than software exploitation through Exploitation for Client Execution, where adversaries will rely on macros being allowed or that the user will accept to activate them.\\nMany popular offensive frameworks exist which use forms of scripting for security testers and adversaries alike. Metasploit , Veil , and PowerSploit  are three examples that are popular among penetration testers for exploit and post-compromise operations and include many features for evading defenses. Some adversaries are known to use PowerShell. \",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Executes commands using a shell command-line interpreter\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1064/\",\n" +
            "                        \"id\": \"T1064\",\n" +
            "                        \"name\": \"Scripting\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may set files and directories to be hidden to evade detection mechanisms. To prevent normal users from accidentally changing special files on a system, most operating systems have the concept of a ‘hidden’ file. These files don’t show up when a user browses the file system with a GUI or when using normal commands on the command line. Users must explicitly ask to show the hidden files either via a series of Graphical User Interface (GUI) prompts or with command line switches (dir /a for Windows and ls –a for Linux and macOS).\\nOn Linux and Mac, users can mark specific files as hidden simply by putting a “.” as the first character in the file or folder name   . Files and folders that start with a period, ‘.’, are by default hidden from being viewed in the Finder application and standard command-line utilities like “ls”. Users must specifically change settings to have these files viewable.\\nFiles on macOS can also be marked with the UF_HIDDEN flag which prevents them from being seen in Finder.app, but still allows them to be seen in Terminal.app . On Windows, users can mark specific files as hidden by using the attrib.exe binary. Many applications create these hidden files and folders to store information so that it doesn’t clutter up the user’s workspace. For example, SSH utilities create a .ssh folder that’s hidden and contains the user’s known hosts and keys.\\nAdversaries can use this to their advantage to hide files and folders anywhere on the system and evading a typical user or system analysis that does not incorporate investigation of hidden files.\",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Creates hidden files, links and/or directories\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1564/001/\",\n" +
            "                        \"id\": \"T1564.001\",\n" +
            "                        \"name\": \"Hidden Files and Directories\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"link\": \"https://attack.mitre.org/tactics/TA0005/\",\n" +
            "                \"id\": \"TA0005\",\n" +
            "                \"name\": \"Defense Evasion\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"description\": \"The adversary is trying to gain higher-level permissions.\\n\\nPrivilege Escalation consists of techniques that adversaries use to gain higher-level permissions on a system or network. Adversaries can often enter and explore a network with unprivileged access but require elevated permissions to follow through on their objectives. Common approaches are to take advantage of system weaknesses, misconfigurations, and vulnerabilities. Examples of elevated access include: \\n\\n* SYSTEM/root level\\n* local administrator\\n* user account with admin-like access \\n* user accounts with access to specific system or perform specific function\\n\\nThese techniques often overlap with Persistence techniques, as OS features that let an adversary persist can execute in an elevated context.  \",\n" +
            "                \"techniques\": [\n" +
            "                    {\n" +
            "                        \"description\": \"Adversaries may create or modify systemd services to repeatedly execute malicious payloads as part of persistence. Systemd is a system and service manager commonly used for managing background daemon processes (also known as services) and other system resources. Systemd is the default initialization (init) system on many Linux distributions replacing legacy init systems, including SysVinit and Upstart, while remaining backwards compatible.  \\nSystemd utilizes unit configuration files with the .service file extension to encode information about a service's process. By default, system level unit files are stored in the /systemd/system directory of the root owned directories (/). User level unit files are stored in the /systemd/user directories of the user owned directories ($HOME). \\nInside the .service unit files, the following directives are used to execute commands:  \\n\\nExecStart, ExecStartPre, and ExecStartPost directives execute when a service is started manually by systemctl or on system start if the service is set to automatically start.\\nExecReload directive executes when a service restarts. \\nExecStop, ExecStopPre, and ExecStopPost directives execute when a service is stopped.  \\n\\nAdversaries have created new service files, altered the commands a .service file’s directive executes, and modified the user directive a .service file executes as, which could result in privilege escalation. Adversaries may also place symbolic links in these directories, enabling systemd to find these payloads regardless of where they reside on the filesystem. \",\n" +
            "                        \"signatures\": [\n" +
            "                            {\n" +
            "                                \"severity\": \"INFO\",\n" +
            "                                \"description\": \"Executes the \\\"systemctl\\\" command used for controlling the systemd system and service manager\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"link\": \"https://attack.mitre.org/techniques/T1543/002/\",\n" +
            "                        \"id\": \"T1543.002\",\n" +
            "                        \"name\": \"Systemd Service\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"link\": \"https://attack.mitre.org/tactics/TA0004/\",\n" +
            "                \"id\": \"TA0004\",\n" +
            "                \"name\": \"Privilege Escalation\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";
    private static final String mockDeviceDTO = "{\n" +
            "    \"vulnerabilities\": [\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in macOS Catalina 10.15. An application may be able to execute arbitrary code with system privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8701\",\n" +
            "            \"severity\": 7.2\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved validation. This issue is fixed in macOS Catalina 10.15, tvOS 13. Processing a maliciously crafted movie may result in the disclosure of process memory.\",\n" +
            "            \"cveId\": \"CVE-2019-8705\",\n" +
            "            \"severity\": 4.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in macOS Catalina 10.15, tvOS 13. An application may be able to execute arbitrary code with kernel privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8717\",\n" +
            "            \"severity\": 7.2\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"The contents of locked notes sometimes appeared in search results. This issue was addressed with improved data cleanup. This issue is fixed in macOS Catalina 10.15. A local user may be able to view a user’s locked notes.\",\n" +
            "            \"cveId\": \"CVE-2019-8730\",\n" +
            "            \"severity\": 2.1\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A buffer overflow was addressed with improved bounds checking. This issue is fixed in macOS Catalina 10.15, tvOS 13, iTunes for Windows 12.10.1, iCloud for Windows 10.7, iCloud for Windows 7.14. Processing a maliciously crafted text file may lead to arbitrary code execution.\",\n" +
            "            \"cveId\": \"CVE-2019-8745\",\n" +
            "            \"severity\": 6.8\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in macOS Catalina 10.15. An application may be able to execute arbitrary code with kernel privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8748\",\n" +
            "            \"severity\": 7.2\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A logic issue was addressed with improved restrictions. This issue is fixed in macOS Catalina 10.15. A malicious application may be able to determine kernel memory layout.\",\n" +
            "            \"cveId\": \"CVE-2019-8755\",\n" +
            "            \"severity\": 7.2\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A race condition existed when reading and writing user preferences. This was addressed with improved state handling. This issue is fixed in macOS Catalina 10.15. The \\\"Share Mac Analytics\\\" setting may not be disabled when a user deselects the switch to share analytics.\",\n" +
            "            \"cveId\": \"CVE-2019-8757\",\n" +
            "            \"severity\": 1.9\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in macOS Catalina 10.15. An application may be able to execute arbitrary code with system privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8758\",\n" +
            "            \"severity\": 7.2\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"\\\"Clear History and Website Data\\\" did not clear the history. The issue was addressed with improved data deletion. This issue is fixed in macOS Catalina 10.15. A user may be unable to delete browsing history items.\",\n" +
            "            \"cveId\": \"CVE-2019-8768\",\n" +
            "            \"severity\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"An issue existed in the drawing of web page elements. The issue was addressed with improved logic. This issue is fixed in iOS 13.1 and iPadOS 13.1, macOS Catalina 10.15. Visiting a maliciously crafted website may reveal browsing history.\",\n" +
            "            \"cveId\": \"CVE-2019-8769\",\n" +
            "            \"severity\": 4.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"The issue was addressed with improved permissions logic. This issue is fixed in macOS Catalina 10.15. A malicious application may be able to access recent documents.\",\n" +
            "            \"cveId\": \"CVE-2019-8770\",\n" +
            "            \"severity\": 4.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"An issue existed in the handling of links in encrypted PDFs. This issue was addressed by adding a confirmation prompt. This issue is fixed in macOS Catalina 10.15. An attacker may be able to exfiltrate the contents of an encrypted PDF.\",\n" +
            "            \"cveId\": \"CVE-2019-8772\",\n" +
            "            \"severity\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved state management. This issue is fixed in macOS Catalina 10.15. An application may be able to execute arbitrary code with kernel privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8781\",\n" +
            "            \"severity\": 9.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1, iTunes for Windows 12.10.2, iCloud for Windows 11.0, iCloud for Windows 7.15. An application may be able to execute arbitrary code with system privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8784\",\n" +
            "            \"severity\": 9.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1, tvOS 13.2, watchOS 6.1. An application may be able to execute arbitrary code with system privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8785\",\n" +
            "            \"severity\": 9.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A memory corruption issue was addressed with improved memory handling. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1, tvOS 13.2, watchOS 6.1. An application may be able to execute arbitrary code with kernel privileges.\",\n" +
            "            \"cveId\": \"CVE-2019-8786\",\n" +
            "            \"severity\": 9.3\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"An out-of-bounds read was addressed with improved input validation. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1, tvOS 13.2, watchOS 6.1. A remote attacker may be able to leak memory.\",\n" +
            "            \"cveId\": \"CVE-2019-8787\",\n" +
            "            \"severity\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"An issue existed in the parsing of URLs. This issue was addressed with improved input validation. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1. Improper URL processing may lead to data exfiltration.\",\n" +
            "            \"cveId\": \"CVE-2019-8788\",\n" +
            "            \"severity\": 5.0\n" +
            "        },\n" +
            "        {\n" +
            "            \"description\": \"A validation issue existed in the handling of symlinks. This issue was addressed with improved validation of symlinks. This issue is fixed in iOS 13.2 and iPadOS 13.2, macOS Catalina 10.15.1. Parsing a maliciously crafted iBooks file may lead to disclosure of user information.\",\n" +
            "            \"cveId\": \"CVE-2019-8789\",\n" +
            "            \"severity\": 4.3\n" +
            "        }\n" +
            "    ],\n" +
            "    \"severitiesAverage\": 6.06,\n" +
            "    \"os\": \"macOS 10.15 Catalina\",\n" +
            "    \"browser\": {\n" +
            "        \"nome\": \"Chrome\",\n" +
            "        \"versione\": \"120.0.0.0\"\n" +
            "    }\n" +
            "}";
    private static final String mockPhoneDTO = "{\n" +
            "    \"valid\": true,\n" +
            "    \"country\": \"\",\n" +
            "    \"countryLoc\": \"\",\n" +
            "    \"nationalFormat\": \"342 126 8257\",\n" +
            "    \"timezones\": [\n" +
            "        \"Europe/Rome\",\n" +
            "        \"Europe/Vatican\"\n" +
            "    ],\n" +
            "    \"riskRating\": \"possible\",\n" +
            "    \"riskLevel\": 57\n" +
            "}";
    private static final String mockUrlDTO = "{\n" +
            "    \"votes\": {\n" +
            "        \"harmless\": 0,\n" +
            "        \"malicious\": 0\n" +
            "    },\n" +
            "    \"filenameDistributions\": null,\n" +
            "    \"tags\": [],\n" +
            "    \"analysisStats\": {\n" +
            "        \"harmless\": 65,\n" +
            "        \"type-unsupported\": 0,\n" +
            "        \"suspicious\": 0,\n" +
            "        \"confirmed-timeout\": 0,\n" +
            "        \"timeout\": 0,\n" +
            "        \"failure\": 0,\n" +
            "        \"malicious\": 0,\n" +
            "        \"undetected\": 24\n" +
            "    }\n" +
            "}";
    private static final String mockDomain = "{\n" +
            "    \"server\": \"Zeta\",\n" +
            "    \"name\": \"unimib.it\",\n" +
            "    \"idnName\": \"unimib.it\",\n" +
            "    \"nameserver\": [\n" +
            "        \"alpha.si.unimib.it\",\n" +
            "        \"ns1.garr.net\",\n" +
            "        \"caronte.si.unimib.it\"\n" +
            "    ],\n" +
            "    \"ips\": \"www.elearning.unimib.it\",\n" +
            "    \"created\": \"24/02/1999\",\n" +
            "    \"changed\": \"12/03/2023\",\n" +
            "    \"expires\": \"24/02/2024\",\n" +
            "    \"registered\": true,\n" +
            "    \"dnssec\": null,\n" +
            "    \"whoisserver\": \"whois.nic.it\",\n" +
            "    \"contacts\": {\n" +
            "        \"owner\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": null,\n" +
            "                \"organization\": \"Universita' degli Studi di Milano - Bicocca\",\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"Via Cozzi, 53\",\n" +
            "                \"zipcode\": \"20125\",\n" +
            "                \"city\": \"Milano\",\n" +
            "                \"state\": \"MI\",\n" +
            "                \"country\": \"IT\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": \"01/03/2007\",\n" +
            "                \"changed\": \"24/03/2011\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"admin\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": \"hidden\",\n" +
            "                \"organization\": \"hidden\",\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"\",\n" +
            "                \"zipcode\": \"\",\n" +
            "                \"city\": \"\",\n" +
            "                \"state\": \"\",\n" +
            "                \"country\": \"\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": null,\n" +
            "                \"changed\": null\n" +
            "            }\n" +
            "        ],\n" +
            "        \"tech\": [\n" +
            "            {\n" +
            "                \"handle\": null,\n" +
            "                \"type\": null,\n" +
            "                \"name\": \"Stefano Moroni\",\n" +
            "                \"organization\": null,\n" +
            "                \"email\": null,\n" +
            "                \"address\": \"Universita' degli Studi di Milano - Bicocca\",\n" +
            "                \"zipcode\": \"Milano\",\n" +
            "                \"city\": \"Via Cozzi, 53\",\n" +
            "                \"state\": \"20125\",\n" +
            "                \"country\": \"MI\",\n" +
            "                \"phone\": null,\n" +
            "                \"fax\": null,\n" +
            "                \"created\": \"25/09/2003\",\n" +
            "                \"changed\": \"24/03/2011\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"registrar\": {\n" +
            "        \"id\": \"GARR-REG\",\n" +
            "        \"name\": \"Consortium GARR\"\n" +
            "    },\n" +
            "    \"rawdata\": [\n" +
            "        \"\\n\\n*********************************************************************\\n* Please note that the following result could be a subgroup of      *\\n* the data contained in the database.                               *\\n*                                                                   *\\n* Additional information can be visualized at:                      *\\n* http://web-whois.nic.it                                           *\\n*********************************************************************\\n\\nDomain:             unimib.it\\nStatus:             ok\\nSigned:             no\\nCreated:            1999-02-24 00:00:00\\nLast Update:        2023-03-12 00:56:42\\nExpire Date:        2024-02-24\\n\\nRegistrant\\n  Organization:     Universita' degli Studi di Milano - Bicocca\\n  Address:          Via Cozzi, 53\\n                    Milano\\n                    20125\\n                    MI\\n                    IT\\n  Created:          2007-03-01 10:50:13\\n  Last Update:      2011-03-24 11:01:07\\n\\nAdmin Contact\\n  Name:             hidden\\n  Organization:     hidden\\n\\nTechnical Contacts\\n  Name:             Stefano Moroni\\n  Address:          Universita' degli Studi di Milano - Bicocca\\n                    Via Cozzi, 53\\n                    Milano\\n                    20125\\n                    MI\\n                    IT\\n  Created:          2003-09-25 00:00:00\\n  Last Update:      2011-03-24 11:01:09\\n\\nRegistrar\\n  Organization:     Consortium GARR\\n  Name:             GARR-REG\\n  Web:              http://www.garr.it\\n  DNSSEC:           no\\n\\n\\nNameservers\\n  alpha.si.unimib.it\\n  ns1.garr.net\\n  caronte.si.unimib.it\\n\\n\"\n" +
            "    ],\n" +
            "    \"network\": null,\n" +
            "    \"exception\": null,\n" +
            "    \"parsedContacts\": true,\n" +
            "    \"template\": {},\n" +
            "    \"ask_whois\": null\n" +
            "}";
    private static final String mockPwd = "[*WG%&X[F>yAf";

    public static FileDTO buildFileDTO() {
        try {
            return objectMapper.readValue(mockFileDTO, FileDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static DeviceDTO buildDeviceDTO() {
        try {
            return objectMapper.readValue(mockDeviceDTO, DeviceDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static PhoneDTO buildPhoneDTO() {
        try {
            return objectMapper.readValue(mockPhoneDTO, PhoneDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static UrlDTO buildUrlDTO() {
        try {
            return objectMapper.readValue(mockUrlDTO, UrlDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response buildDomain() {
        try {
            return objectMapper.readValue(mockDomain, Response.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String buildPwd() {
        return mockPwd;
    }
}
