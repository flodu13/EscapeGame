package com.gameplaystudio.escapegame;

import java.util.Random;

import org.apache.log4j.Logger;

public class StrategieJAttaque {
	private static Logger LOGGER = Logger.getLogger(StrategieJAttaque.class);
	private int combinaison;

	public StrategieJAttaque() {
		this.combinaison = new Random().nextInt(10000);
		LOGGER.debug("(Combinaison secrète : " + this.combinaison + ")");
	}

	public int getCombinaison() {
		return combinaison;
	}

	public String verification(int proposition) {
		if (proposition == combinaison) {
			return "=";
		} else if (proposition > combinaison) {
			return "-";
		} else {
			return "+";
		}
	}

}
