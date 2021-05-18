package com.unitglo.foodscience;

public class BaseFruits {
	int images;
	String[] Title;
	String[] NutritionFactsLeft;
	String[] NutritionFactsRight;
	String[] Varieties;
	String[] HealthBenefits;
	public BaseFruits(int images, String[] Title, String[] NutritionFactsLeft,
			String[] NutritionFactsRight, String[] Varieties,
			String[] HealthBenefits) {
		this.images = images;
		this.Title = Title;
		this.NutritionFactsLeft = NutritionFactsLeft;
		this.NutritionFactsRight = NutritionFactsRight;
		this.Varieties = Varieties;
		this.HealthBenefits = HealthBenefits;
	}

	public int getImages() {
		return images;
	}

	public void setImages(int images) {
		this.images = images;
	}

	public String[] getTitle() {
		return Title;
	}

	public void setTitle(String[] title) {
		Title = title;
	}

	public String[] getNutritionFactsLeft() {
		return NutritionFactsLeft;
	}

	public void setNutritionFactsLeft(String[] nutritionFactsLeft) {
		NutritionFactsLeft = nutritionFactsLeft;
	}

	public String[] getNutritionFactsRight() {
		return NutritionFactsRight;
	}

	public void setNutritionFactsRight(String[] nutritionFactsRight) {
		NutritionFactsRight = nutritionFactsRight;
	}

	public String[] getVarieties() {
		return Varieties;
	}

	public void setVarieties(String[] varieties) {
		Varieties = varieties;
	}

	public String[] getHealthBenefits() {
		return HealthBenefits;
	}

	public void setHealthBenefits(String[] healthBenefits) {
		HealthBenefits = healthBenefits;
	}

}
