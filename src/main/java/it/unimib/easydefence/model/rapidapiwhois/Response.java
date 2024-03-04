package it.unimib.easydefence.model.rapidapiwhois;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty("server")
    public String server;
    @JsonProperty("name")
    public String name;
    @JsonProperty("idnName")
    public String idnName;
    @JsonProperty("nameserver")
    public List<String> nameserver;
    @JsonProperty("ips")
    public String ips;
    @JsonProperty("created")
    public String created;
    @JsonProperty("changed")
    public String changed;
    @JsonProperty("expires")
    public String expires;
    @JsonProperty("registered")
    public Boolean registered;
    @JsonProperty("dnssec")
    public String dnssec;
    @JsonProperty("whoisserver")
    public String whoisserver;
    @JsonProperty("contacts")
    public Contacts contacts;
    @JsonProperty("registrar")
    public Registrar registrar;
    @JsonProperty("rawdata")
    public List<String> rawdata;
    @JsonProperty("network")
    public Object network;
    @JsonProperty("exception")
    public Object exception;
    @JsonProperty("parsedContacts")
    public Boolean parsedContacts;
    @JsonProperty("template")
    public Template template;
    @JsonProperty("ask_whois")
    public String askWhois;
    @JsonProperty("status")
    public String status;
    @JsonProperty("message")
    public String message;

}
