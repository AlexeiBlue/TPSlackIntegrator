package com.swl.tp_slack_integrater;

import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@ToString
@JsonIgnoreProperties
public class Template {
	@JsonProperty String text;
	@JsonProperty String username;
	@JsonProperty String color;
	@JsonProperty String webhook;
}
