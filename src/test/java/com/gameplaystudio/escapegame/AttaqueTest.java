package com.gameplaystudio.escapegame;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class AttaqueTest {
	@Test
	public void genereUnNombreAleatoire() {
		Assert.assertThat(new StrategieJAttaque().getCombinaison(), Matchers.notNullValue());
	}

	@Test
	public void nombreGenerePositif() {
		Assert.assertThat(new StrategieJAttaque().getCombinaison(), Matchers.greaterThanOrEqualTo(0));
	}

	@Test
	public void nombreParDefaut4digit() {
		Assert.assertThat(new StrategieJAttaque().getCombinaison(), Matchers.lessThanOrEqualTo(9999));
	}

	@Test
	public void propositionCorrecteExpectedEgale() {
		StrategieJAttaque attaque = new StrategieJAttaque();
		Assert.assertThat(attaque.verification(attaque.getCombinaison()), Matchers.equalTo("="));
	}

	@Test
	public void propositionSuperieureExpectedmoins() {
		StrategieJAttaque attaque = new StrategieJAttaque();
		Assert.assertThat(attaque.verification(attaque.getCombinaison() + 1), Matchers.equalTo("-"));
	}

	@Test
	public void propositionSuperieureExpectedplus() {
		StrategieJAttaque attaque = new StrategieJAttaque();
		Assert.assertThat(attaque.verification(attaque.getCombinaison() - 1), Matchers.equalTo("+"));
	}
}
