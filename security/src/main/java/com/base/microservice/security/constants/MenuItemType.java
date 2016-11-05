package com.base.microservice.security.constants;

import lombok.Getter;

@Getter
public enum MenuItemType {
	SECTION("SECTION"), WORDPRESS("WORDPRESS"), YOUTUBE("YOUTUBE"), RSS("RSS"), FACEBOOK("FACEBOOK"), INSTAGRAM(
			"INSTAGRAM"), TWITTER("TWITTER"), WEBVIEW("WEBVIEW"), TUMBLR(
					"TUMBLR"), RADIO("RADIO"), VIDEO("VIDEO"), SOUNDCLOUD("SOUNDCLOUD"), MAPS("MAPS"), INTENT("INTENT");

	private String value;

	private MenuItemType(String value) {
		this.value = value;
	}

}
