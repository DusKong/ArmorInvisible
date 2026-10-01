package com.github.duskong.armorinvisible;

import net.fabricmc.api.ClientModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmorInvisibleClient implements ClientModInitializer {
	public static final String MOD_ID = "armor_invisible";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitializeClient() {
	}
}
